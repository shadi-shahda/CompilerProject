from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

products = [
    {
        "id": 1,
        "name": "Laptop",
        "price": 1500,
        "details": "High performance laptop for coding.",
        "image": "https://via.placeholder.com/150"
    },
    {
        "id": 2,
        "name": "Phone",
        "price": 800,
        "details": "Smart phone with great camera.",
        "image": "https://via.placeholder.com/150"
    }
]

# 1. الصفحة الرئيسية: عرض المنتجات
@app.route('/')
def index():
    return render_template('index.html', products=products)

# 2. صفحة عرض التفاصيل
@app.route('/product/<int:id>')
def product_detail(id):
    product = None
    for p in products:
        if p["id"] == id:
            product = p
            break
    return render_template('detail.html', product=product)

# 3. صفحة إضافة منتج
@app.route('/add', methods=['GET', 'POST'])
def add_product():
    if request.method == 'POST':
        new_id = len(products) + 1
        name = request.form['name']
        price = request.form['price']
        details = request.form['details']
        image = request.form['image']
        
        new_product = {
            "id": new_id,
            "name": name,
            "price": price,
            "details": details,
            "image": image
        }
        products.append(new_product)
        return redirect(url_for('index'))
    
    return render_template('add.html')

# 4. حذف منتج (الميزة الإضافية)
@app.route('/delete/<int:id>')
def delete_product(id):
    global products
    products = [p for p in products if p["id"] != id]
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)