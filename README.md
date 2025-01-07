<!-- OVERVIEW: -->

 A modern, scalable, and user-friendly e-commerce platform that enables users to browse products, add them to their cart, and complete purchases with secure payment integrations.

<!-- FEATURES: -->

For Customers:
User Authentication:
Secure login and registration (JWT-based or OAuth).

Product Browsing:
View product listings with details such as price, availability, and reviews.

Search and Filters:
Search by name, category, price range, and other parameters.

Shopping Cart:
Add, remove, and update items in the cart with real-time price updates.

Wishlist:
Save products for later purchase.

Checkout:
Secure payment gateway integration for transactions (e.g., Stripe, PayPal).

Order Tracking:
View order history and track shipment status.

For Admins:
Dashboard:
Overview of sales, inventory, and user activity.

Product Management:
Add, edit, or delete products and categories.

Order Management:
View and manage customer orders and their statuses.

User Management:
View and manage customer accounts.

<!-- Technology Stack: -->

Front-End (React):

React:
For building a dynamic and responsive user interface.
React Router:
For navigation between pages.
Axios:
For API calls.
Redux Toolkit (or Context API):
For state management (e.g., user authentication, cart).
CSS/SASS:
For styling the application.
Material-UI or Tailwind CSS:
For modern UI components.

Back-End:
Spring Boot:
For secure and scalable REST APIs.

Database:
MySQL/PostgreSQL:
For relational data like products, users, and orders.

Other Technologies:
Payment Gateways:
Stripe, PayPal, or Razorpay for secure payments.
Cloud Hosting:
AWS, Firebase, or Vercel for deployment.

Core Functionalities
A. User Workflow
Home Page:
Displays featured products, categories, and banners.
Allows users to search for products.

Product Listing:
Paginated list of products with sorting and filters.

Product Details:
Detailed view with images, specifications, reviews, and availability.

Shopping Cart:
Displays items added, total price, and checkout button.

Checkout:
Address input, payment gateway integration, and order confirmation.

B. Admin Workflow
Admin Login:

Secure login for administrators.
Dashboard:

View key metrics (e.g., total sales, orders, users).
Product Management:

Add/edit/delete products and upload images.
Order Management:

View customer orders, update statuses (e.g., shipped, delivered).

User Roles
Guest User:
Can browse products and view details but must log in to add to the cart or purchase.
Registered User:
Can use all shopping features, including order tracking and reviews.
Admin:
Manages the product catalog, orders, and customer accounts.

<!-- BACKEND FILE STRUCTURE --> 

spring-ecommerce/
├── src/
│   ├── main/
│   │   ├── java/com/example/ecommerce/
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── SwaggerConfig.java
│   │   │   ├── controllers/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── ProductController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   └── UserController.java
│   │   │   ├── dto/
│   │   │   │   ├── AuthRequest.java
│   │   │   │   ├── ProductDTO.java
│   │   │   │   └── OrderDTO.java
│   │   │   ├── exceptions/
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   └── ResourceNotFoundException.java
│   │   │   ├── models/
│   │   │   │   ├── Product.java
│   │   │   │   ├── User.java
│   │   │   │   └── Order.java
│   │   │   ├── repositories/
│   │   │   │   ├── ProductRepository.java
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── OrderRepository.java
│   │   │   ├── services/
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── ProductService.java
│   │   │   │   └── OrderService.java
│   │   │   ├── utils/
│   │   │   │   ├── JwtUtil.java
│   │   │   │   └── EmailUtil.java
│   │   │   ├── EcommerceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/ (static files)
│   ├── test/
│       ├── java/com/example/ecommerce/
│           └── EcommerceApplicationTests.java
├── .env
├── pom.xml
├── README.md
└── .gitignore

<!-- FROND END STRUCTURE REACT -->

react-ecommerce/
├── public/
│   ├── index.html
│   ├── favicon.ico
│   └── assets/ (static files like images, fonts)
├── src/
│   ├── assets/
│   │   ├── images/
│   │   └── icons/
│   ├── components/
│   │   ├── Button/
│   │   ├── Header/
│   │   └── Footer/
│   ├── contexts/
│   │   ├── AuthContext.js
│   │   └── CartContext.js
│   ├── hooks/
│   │   ├── useAuth.js
│   │   └── useFetch.js
│   ├── layouts/
│   │   ├── MainLayout.js
│   │   └── AdminLayout.js
│   ├── pages/
│   │   ├── Home/
│   │   ├── ProductDetails/
│   │   ├── Cart/
│   │   └── Login/
│   ├── routes/
│   │   ├── AppRoutes.js
│   │   └── PrivateRoutes.js
│   ├── services/
│   │   ├── apiClient.js
│   │   ├── productService.js
│   │   └── authService.js
│   ├── styles/
│   │   ├── global.css
│   │   └── themes/
│   ├── utils/
│   │   ├── constants.js
│   │   ├── formatCurrency.js
│   │   └── validateForm.js
│   ├── App.js
│   ├── index.js
│   └── reportWebVitals.js
├── .env
├── package.json
├── README.md
└── .gitignore

<!-- DATABASE ecommerce_db -->

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    role ENUM('ADMIN', 'CUSTOMER') DEFAULT 'CUSTOMER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT DEFAULT 0,
    category_id INT,
    image_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE SET NULL
);

CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    status ENUM('PENDING', 'PROCESSING', 'SHIPPED', 'DELIVERED', 'CANCELLED') DEFAULT 'PENDING',
    total_amount DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

CREATE TABLE cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    payment_method ENUM('CREDIT_CARD', 'PAYPAL', 'BANK_TRANSFER') NOT NULL,
    payment_status ENUM('PENDING', 'COMPLETED', 'FAILED') DEFAULT 'PENDING',
    transaction_id VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    user_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

<!-- Relationships Between Tables -->
users ↔ orders: A user can place multiple orders.
orders ↔ order_items: Each order can have multiple items.
products ↔ categories: Products belong to a category.
products ↔ order_items: Order items reference products.
users ↔ cart: Each user has a cart that references products.

<!-- Sample Data -->
INSERT INTO categories (name, description) VALUES
('Electronics', 'Devices and gadgets'),
('Books', 'Wide range of books and literature'),
('Clothing', 'Apparel and fashion items');

INSERT INTO products (name, description, price, stock, category_id, image_url) VALUES
('Smartphone', 'Latest model smartphone', 699.99, 50, 1, 'https://example.com/smartphone.jpg'),
('Novel', 'Bestselling novel', 14.99, 100, 2, 'https://example.com/novel.jpg'),
('T-shirt', 'Comfortable cotton t-shirt', 19.99, 200, 3, 'https://example.com/tshirt.jpg');

INSERT INTO users (first_name, last_name, email, password, phone, role) VALUES
('John', 'Doe', 'john.doe@example.com', 'hashedpassword', '1234567890', 'CUSTOMER'),
('Admin', 'User', 'admin@example.com', 'hashedpassword', '0987654321', 'ADMIN');
