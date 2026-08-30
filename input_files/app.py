from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

next_id = 3

products = [
    {
        "id": 1,
        "name": "Laptop",
        "details": "High performance laptop for coding.",
        "image": "https://via.placeholder.com/150",
        "price": 1500,
    },
    {
        "id": 2,
        "name": "Phone",
        "details": "Smart phone with great camera.",
        "image": "https://via.placeholder.com/150",
        "price": 800,
    },
]

# x = unknown_variable

# bad_value = "price" + 10

# def scope_demo():
#     local_value = 10
# x = local_value

@app.route("/")
def home():
    return render_template("index.html")

@app.route("/index.html")
def index():
    return render_template("index.html")

@app.route("/add.html")
def add_page():
    return render_template("add.html")

@app.route("/detail.html")
def detail_page():
    return render_template("detail.html")

@app.route("/api/products", methods=["GET", "POST", "DELETE"])
def products_api():
    global products, next_id

    if request.method == "GET":
        return jsonify(products)

    if request.method == "POST":
        price_value = request.form.get("price", "0")

        if price_value == "":
            price_value = "0"

        product = {
            "id": next_id,
            "name": request.form.get("name", ""),
            "details": request.form.get("details", ""),
            "image": request.form.get("image", ""),
            "price": int(price_value),
        }

        products.append(product)
        next_id = next_id + 1

        return jsonify(product)

    id = int(request.args.get("id", "0"))

    products = [
        product
        for product in products
        if product["id"] != id
    ]

    return jsonify(products)

if __name__ == "__main__":
    app.run(debug=True, port=5001)