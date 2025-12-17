from flask import Flask, render_template

app = Flask(__name__)

@app.route("/home")
def home():
    title = "Home Page"
    return render_template("test.html", username="Alice", title="Welcome to Flask Demo", isAdmin=True, notifications=[])

@app.route("/users")
def get_users():
    admin_id = 1
    return "users.html"

app.run()