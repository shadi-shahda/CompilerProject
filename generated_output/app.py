from flask import Flask, render_template, request, redirect, url_for
app = Flask(__name__)
products = [
    {
        "details": "High performance laptop for coding.",
        "name": "Laptop",
        "price": 1500,
        "image": "https://via.placeholder.com/150",
        "id": 1,
    },
    {
        "image": "https://via.placeholder.com/150",
        "details": "Smart phone with great camera.",
        "id": 2,
        "price": 800,
        "name": "Phone",
    },
]
@app.route('/')
def index():
    return render_template("index.html", products=products)

@app.route('/product/<int:id>')
def product_detail(id):
    product = None
    for p in products:
        if p["id"] == id:
            product = p
            break

    return render_template("detail.html", product=product)

@app.route('/add', methods=['GET', 'POST'])
def add_product():
    if request.method == "POST":
        new_id = len(products) + 1
        name = request.form["name"]
        price = request.form["price"]
        details = request.form["details"]
        image = request.form["image"]
        new_product = {
            "name": name,
            "price": price,
            "details": details,
            "image": image,
            "id": new_id,
        }
        products.append(new_product)
        return redirect(url_for("index"))
    return render_template("add.html")

@app.route('/delete/<int:id>')
def delete_product(id):
    global products
    products = [p for p in products if p["id"] != id]
    return redirect(url_for("index"))

if __name__ == "__main__":
    app.run(debug=True, port=5001)
