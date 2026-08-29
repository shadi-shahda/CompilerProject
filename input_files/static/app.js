const PRODUCTS_API = "/api/products";

document.addEventListener("DOMContentLoaded", () => {
    const page = document.body.dataset.page;

    if (page === "index") {
        loadProductsPage();
    }

    if (page === "add") {
        setupAddProductPage();
    }

    if (page === "detail") {
        loadProductDetailsPage();
    }
});

async function getProducts() {
    const response = await fetch(PRODUCTS_API);

    if (!response.ok) {
        throw new Error("Failed to load products");
    }

    return await response.json();
}

async function loadProductsPage() {
    const container = document.getElementById("productsContainer");

    if (!container) {
        return;
    }

    try {
        const products = await getProducts();

        if (products.length === 0) {
            container.innerHTML = "<p>No products found.</p>";
            return;
        }

        container.innerHTML = products.map(product => `
            <div class="card">
                <img src="${escapeHtml(product.image || '')}" alt="${escapeHtml(product.name || '')}">

                <h3>${escapeHtml(product.name || '')}</h3>

                <p>${escapeHtml(product.details || '')}</p>

                <strong>${escapeHtml(String(product.price || 0))}$</strong>

                <div class="actions">
                    <a class="btn" href="/detail.html?id=${product.id}">
                        Details
                    </a>

                    <button class="btn-delete" onclick="deleteProduct(${product.id})">
                        Delete
                    </button>
                </div>
            </div>
        `).join("");

    } catch (error) {
        container.innerHTML = "<p>Failed to load products.</p>";
        console.error(error);
    }
}

function setupAddProductPage() {
    const form = document.getElementById("addProductForm");

    if (!form) {
        return;
    }

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const body = new URLSearchParams(new FormData(form));

        const response = await fetch(PRODUCTS_API, {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body
        });

        if (!response.ok) {
            alert("Failed to add product");
            return;
        }

        window.location.href = "/index.html";
    });
}

async function loadProductDetailsPage() {
    const container = document.getElementById("productDetails");

    if (!container) {
        return;
    }

    const params = new URLSearchParams(window.location.search);
    const id = Number(params.get("id"));

    if (!id) {
        container.innerHTML = "<p>Missing product id.</p>";
        return;
    }

    try {
        const products = await getProducts();

        const product = products.find(item => Number(item.id) === id);

        if (!product) {
            container.innerHTML = "<p>Product not found.</p>";
            return;
        }

        container.innerHTML = `
            <div class="details-card">
                <img src="${escapeHtml(product.image || '')}" alt="${escapeHtml(product.name || '')}">

                <h1>${escapeHtml(product.name || '')}</h1>

                <p>${escapeHtml(product.details || '')}</p>

                <strong>${escapeHtml(String(product.price || 0))}$</strong>
            </div>
        `;

    } catch (error) {
        container.innerHTML = "<p>Failed to load product details.</p>";
        console.error(error);
    }
}

async function deleteProduct(id) {
    const response = await fetch(`${PRODUCTS_API}?id=${id}`, {
        method: "DELETE"
    });

    if (!response.ok) {
        alert("Failed to delete product");
        return;
    }

    window.location.reload();
}

function escapeHtml(value) {
    return String(value)
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}