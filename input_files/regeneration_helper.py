import re
import subprocess
from pathlib import Path
from pprint import pformat


def regenerate(products):
    project_root = Path(__file__).resolve().parent.parent
    app_file = project_root / "input_files" / "app.py"

    # ---------------------------------------------------------
    # 1. Read app.py
    # ---------------------------------------------------------

    content = app_file.read_text(
        encoding="utf-8"
    )

    # ---------------------------------------------------------
    # 2. Convert current runtime products to Python source
    # ---------------------------------------------------------

    products_source = (
        "products = "
        + pformat(
            products,
            width=100,
            sort_dicts=False
        )
    )

    # ---------------------------------------------------------
    # 3. Replace only the global products list in app.py
    # ---------------------------------------------------------

    pattern = r"^products\s*=\s*\[.*?\]\s*(?=\n\s*@app\.route)"
    updated_content, replacement_count = re.subn(
        pattern,
        products_source,
        content,
        count=1,
        flags=re.MULTILINE | re.DOTALL
    )

    if replacement_count != 1:
        raise RuntimeError(
            "Could not locate the products list inside app.py."
        )

    app_file.write_text(
        updated_content,
        encoding="utf-8"
    )

    # ---------------------------------------------------------
    # 4. Run Java Translator
    # ---------------------------------------------------------

    classpath = (
        str(project_root / "out" / "production" / "CompilerProject")
        + ";"
        + str(
            project_root
            / "dependencies"
            / "antlr-4.13.2-complete.jar"
        )
    )

    subprocess.run(
        [
            "java",
            "-cp",
            classpath,
            "App"
        ],
        cwd=str(project_root),
        check=True
    )