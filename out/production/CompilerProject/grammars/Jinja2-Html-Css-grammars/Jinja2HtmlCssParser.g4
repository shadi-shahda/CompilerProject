parser grammar Jinja2HtmlCssParser;

options { tokenVocab=Jinja2HtmlCssLexer; }

template : content* EOF;

content
    : htmlElement                           # HtmlContent
    | JINJA_VAR_OPEN J_ID JINJA_VAR_CLOSE   # JinjaVar
    | jinjaBlock                            # JinjaBlockContent
    | plainText                             # TextContent
    ;

htmlElement
    : TAG_OPEN TAG_ID attribute* TAG_CLOSE content* TAG_CLOSE_OPEN TAG_ID TAG_CLOSE # StandardTag
    | TAG_OPEN TAG_ID attribute* SLASH_CLOSE                                        # SelfClosingTag
    ;

attribute
    : styleAttr      # StyleAttribute
    | genericAttr    # GenericAttribute
    ;

// CSS Handling
styleAttr : STYLE_ATTR cssRule* CSS_END;
cssRule   : CSS_PROP CSS_COLON CSS_VAL CSS_SEMI;

// Standard Attribute (e.g., class="btn", charset="UTF-8")
genericAttr : TAG_ID EQUALS STRING
            | TAG_ID // Boolean attributes like 'checked' or 'disabled'
            ;

plainText : HTML_TEXT;

jinjaBlock
    : JINJA_BLOCK_OPEN IF J_ID JINJA_BLOCK_CLOSE content* JINJA_BLOCK_OPEN ENDIF JINJA_BLOCK_CLOSE               # IfBlock
    | JINJA_BLOCK_OPEN FOR J_ID IN J_ID JINJA_BLOCK_CLOSE content* JINJA_BLOCK_OPEN ENDFOR JINJA_BLOCK_CLOSE     # ForBlock
    ;