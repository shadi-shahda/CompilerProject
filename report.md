# Compiler Project Report

## 1. Project Overview

This project is a compiler-style front end for a Flask-based web application located in `input_files/`. Its purpose is not to generate machine code, but to analyze three related source languages used by the web project:

1. Python/Flask application code in `input_files/app.py`
2. CSS styles in `input_files/static/style.css`
3. Jinja2/HTML templates in `input_files/templates/*.html`

The implementation uses ANTLR4 grammars in `grammars/` to build lexers and parsers, then converts parse trees into custom ASTs in `src/`, and finally walks those ASTs with symbol-table visitors to perform semantic checks and cross-file consistency analysis.

## 2. Target Application

The compiler is built around a small Flask store application. The app contains:

- A product list stored in memory
- A home page that renders products
- A detail page for a single product
- A form to add new products
- A delete route for removing products

The templates use Jinja features such as loops, conditionals, variable printing, and attribute access. The CSS file defines the visual structure of the HTML pages. This makes the project a good candidate for a compiler pipeline that checks consistency across Python, HTML, and CSS.

## 3. Overall Architecture

The project is organized into three main compiler stages:

### 3.1 Lexing and Parsing

ANTLR4 grammars define the syntax for each language family:

- `grammars/FlaskPythonGrammars/FlaskPythonLexer.g4`
- `grammars/FlaskPythonGrammars/FlaskPythonParser.g4`
- `grammars/CssGrammars/CssLexer.g4`
- `grammars/CssGrammars/CssParser.g4`
- `grammars/TemplatesGrammars/TemplatesLexer.g4`
- `grammars/TemplatesGrammars/TemplatesParser.g4`

The generated recognizers are placed in `src/generated/` and duplicated in `bin/generated/` after compilation.

### 3.2 AST Construction

Each language has a dedicated AST hierarchy under `src/`:

- `src/FlaskPythonAST/`
- `src/CssAST/`
- `src/TemplatesAST/`

Visitor classes translate ANTLR parse trees into these AST nodes:

- `src/FlaskPythonVisitor/AntlrToPythonASTVisitor.java`
- `src/CssVisitor/AntlrToCssASTVisitor.java`
- `src/TemplatesVisitor/AntlrToTemplatesVisitor.java`

### 3.3 Semantic Analysis and Symbol Tables

Each language also has a symbol-table layer:

- `src/FlaskPythonSymbolTable/`
- `src/CssSymbolTable/`
- `src/TemplatesSymbolTable/`

These visitors walk the AST and collect information such as variable definitions, route definitions, template availability, and CSS selector usage.

## 4. Entry Point and Execution Flow

The main entry point is [src/App.java](src/App.java). It orchestrates the whole process by reading the files from `input_files/`, tokenizing them, parsing them, building ASTs, and then running symbol-table visitors.

The runtime sequence is:

1. Read the Flask source file `input_files/app.py`
2. Parse it with the Flask/Python ANTLR grammar
3. Convert the parse tree to a Flask AST
4. Print the AST
5. Build a Flask symbol table
6. Inject known template names into the Flask semantic pass
7. Read and analyze `input_files/static/style.css`
8. Parse and print the CSS AST
9. Build a CSS symbol table
10. Read and analyze each HTML template in `input_files/templates/`
11. Parse and print the template AST
12. Build a template symbol table and inject known context variables

This makes the project a multi-language static analysis pipeline rather than a full code generator.

## 5. Language-Specific Breakdown

### 5.1 Flask/Python Front End

The Flask grammar supports:

- Imports
- Route-decorated function declarations
- Assignments
- `if` statements
- `for` loops
- `return`
- `print`
- Function calls and method calls
- Basic arithmetic and comparison expressions
- Lists and dictionaries
- Flask helpers such as `render_template`, `redirect`, and `url_for`

The AST builder in [src/FlaskPythonVisitor/AntlrToPythonASTVisitor.java](src/FlaskPythonVisitor/AntlrToPythonASTVisitor.java) converts those constructs into custom nodes such as function declarations, assignments, expressions, list/dictionary literals, and control-flow statements.

The Flask symbol-table visitor in [src/FlaskPythonSymbolTable/FlaskPythonSymbolTableVisitor.java](src/FlaskPythonSymbolTable/FlaskPythonSymbolTableVisitor.java) currently performs these checks:

- Duplicate route detection
- Duplicate function-name detection
- Undefined variable detection
- Template existence validation for `render_template(...)`
- Basic iteration checks for `for` loops
- Type inference for literals and some expressions

### 5.2 CSS Front End

The CSS grammar supports:

- Rules with selector lists
- Tag, class, and ID selectors
- Declarations and property/value pairs
- Numeric values, percentages, pixels, hex colors, strings, floats, and functions

The CSS symbol-table visitor in [src/CssSymbolTable/CssSymbolTableVisitor.java](src/CssSymbolTable/CssSymbolTableVisitor.java) collects class and ID selectors, while [src/CssSymbolTable/CssSymbolTable.java](src/CssSymbolTable/CssSymbolTable.java) can compare them against selectors found in HTML. That allows the compiler to report:

- CSS classes used in HTML but not defined in `style.css`
- CSS IDs used in HTML but not defined in `style.css`
- CSS selectors defined in `style.css` but never used in HTML

### 5.3 Templates Front End

The templates grammar supports:

- Plain HTML tags and text
- Void and self-closing tags
- Attributes
- Jinja print expressions
- Jinja `if` blocks
- Jinja `for` loops
- Jinja expressions such as member access, dictionary access, boolean operators, and comparisons

The AST visitor in [src/TemplatesVisitor/AntlrToTemplatesVisitor.java](src/TemplatesVisitor/AntlrToTemplatesVisitor.java) constructs a mixed HTML/Jinja AST. The template symbol-table visitor in [src/TemplatesSymbolTable/TemplatesSymbolTableVisitor.java](src/TemplatesSymbolTable/TemplatesSymbolTableVisitor.java) validates:

- Context variables referenced by templates
- Loop-scoped variables
- Basic use of Jinja expressions

## 6. What the Project Already Does Well

The current implementation is strong as a front-end analyzer. It already provides:

- A clear separation between lexing, parsing, AST construction, and semantic passes
- Dedicated language models for Flask/Python, CSS, and templates
- Cross-file awareness between Flask code and template names
- Cross-file awareness between HTML usage and CSS selector definitions
- Human-readable AST printers for debugging and inspection

This is a solid base for a compiler or static-analysis pipeline targeting web applications.

## 7. Observations and Improvement Opportunities

After reading the project, these are the main areas I would change or extend next:

### 7.1 Semantic Scope Handling

The Flask symbol-table visitor currently does not fully model block scope. In particular, variables created inside `if` and `for` bodies are treated in a way that can leak into the surrounding scope. That can hide real errors and produce inaccurate analysis for code like loop-local variables.

Recommendation:

- Introduce proper scope entry and exit for block statements where Python semantics require it, or at least model the project’s intended scoping rules explicitly.
- Preserve symbol metadata such as declaration site, inferred type, and scope depth.

### 7.2 Stronger Type Analysis

Type inference is currently lightweight. It works for literals and some simple expressions, but many calls and member accesses still collapse to `UNKNOWN`.

Recommendation:

- Add a real type lattice and propagation rules
- Validate operator compatibility more consistently
- Check function call arguments against known signatures where possible
- Infer collection element types for lists and dictionaries

### 7.3 Intermediate Representation

The project stops after AST and symbol-table analysis. If the goal is to evolve this into a fuller compiler, the next major step should be an intermediate representation.

Recommendation:

- Lower the AST into a simpler IR, such as three-address code or a control-flow graph
- Represent branches, loops, calls, and assignments in a normalized form
- Use the IR as the base for later passes instead of operating directly on the AST

### 7.4 Optimization Passes

No optimization phase is currently present.

Recommendation:

- Add constant folding and constant propagation
- Remove dead assignments and unreachable blocks
- Simplify redundant member access and repeated string operations
- Cache repeated symbol lookups if the project grows

### 7.5 Grammar Cleanup and Robustness

The grammars are functional, but there are a few places where they could be tightened for maintainability and correctness.

Recommendation:

- Review duplicated grammar alternatives and repeated visitor branches
- Tighten parsing for route decorators and template expressions
- Normalize selector storage so class and ID names are represented consistently
- Add parser-level tests for ambiguous or edge-case inputs

### 7.6 Better Error Reporting

Implemented improvements:

- AST printers now emit stable `NodeId` and node type for each AST node, improving traceability between diagnostics and AST nodes.
- Printers retain line numbers for each node, making it easier to map errors to source locations.
- These changes support grouping and richer diagnostics in later passes and make it simpler to emit structured diagnostics for editor integration.

Remaining recommendations:

- Add full source spans (start/end offsets) at the parser level to accompany node metadata.
- Introduce severity levels (warning, error, info) in the diagnostic model and group errors by file and phase for reporting.
- Emit language-server-friendly structured diagnostics as a follow-up.

### 7.7 Testing and Regression Coverage

This project would benefit from more automated tests around the compiler pipeline.

Recommendation:

- Add grammar tests for the three languages
- Add AST-construction tests for representative inputs
- Add symbol-table tests for variable scope, route duplication, and template/CSS cross-checks
- Add regression tests for known Flask project edge cases

## 8. Summary

This project is a multi-language compiler front end for a Flask application. It already performs lexical analysis, parsing, AST construction, and basic semantic validation across Python, HTML/Jinja, and CSS. The design is modular and well suited for future expansion.

The most important next steps are better scope handling, stronger type analysis, an intermediate representation, and optimization passes. Those changes would move the project from a static analyzer into a more complete compiler pipeline.
