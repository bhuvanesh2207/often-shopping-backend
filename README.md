# 🛒 E-Commerce Backend System

## 🚀 Overview
This project is a **Full Stack Java e-commerce solution** built using **Spring Boot Microservices architecture**. It provides role-based functionality for three types of users: **Admin, Customer, and Delivery Personnel**. The system ensures secure authentication, modular scalability, and seamless integration with databases and APIs, making it suitable for real-world e-commerce applications.

---

## 👥 User Roles and Responsibilities  
| Role            | Responsibilities                                                                 |
|-----------------|---------------------------------------------------------------------------------|
| **Admin**       | Add/manage products, view customer orders, and monitor system activities        |
| **Customer**    | Browse products, add items to cart, place orders, and track order status        |
| **Delivery**    | Update delivery status, manage shipping, and confirm order completion           |

---

## 💻 Tech Stack  
- **Java 17** (Core programming language)  
- **Spring Boot 3.1** (Backend framework)  
- **Spring Security** (Authentication & Authorization)  
- **MySQL 8.0** (Database)  
- **Maven** (Dependency management & build tool)  
- **Postman** (API Testing)  

---

## 🔑 Key Features  
- ✅ **Multi-role authentication system** (Admin, Customer, Delivery)  
- ✅ **Product CRUD operations** (Create, Read, Update, Delete)  
- ✅ **Shopping cart functionality** (Add/remove items, quantity adjustment)  
- ✅ **Order processing pipeline** (Place order, payment, confirmation)  
- ✅ **Delivery tracking** (Real-time status updates)  
- ✅ **RESTful APIs** (Well-documented endpoints for integration)  
- ✅ **Microservices architecture** (Scalable and modular design)  

---

## 🏗️ Architecture Overview  
The system follows **Spring Boot Microservices** architecture:  
1. **Authentication Service** – Handles login, registration, and role management  
2. **Product Service** – Manages product catalog & CRUD operations  
3. **Cart Service** – Manages shopping cart items for customers  
4. **Order Service** – Handles order placement, processing, and confirmation  
5. **Delivery Service** – Updates delivery tracking and status  

---

## 🛠 Setup Guide  

### 🔧 Prerequisites  
Before running the application, make sure you have the following installed:  

| Requirement      | Version | Download Link                                                                 |
|------------------|---------|-------------------------------------------------------------------------------|
| **Java JDK**     | 17+     | [Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) |
| **MySQL Server** | 8.0+    | [Download](https://dev.mysql.com/downloads/mysql/)                            |
| **Maven**        | 3.8+    | [Download](https://maven.apache.org/download.cgi)                             |
| **Postman**      | Latest  | [Download](https://www.postman.com/downloads/)                                |

---

## 🚀 Quick Start  
Follow these steps to set up and run the project locally:  

```bash
# Clone the repository
git clone https://github.com/yourusername/OftenShopping-Backend.git
cd OftenShopping-Backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```


## 🎯 Conclusion
This E-Commerce Backend System demonstrates the use of Spring Boot Microservices in building a scalable, modular, and secure application. It provides essential features such as role-based access, product management, order handling, and real-time delivery tracking. The architecture is designed to be easily extendable, making it adaptable for future enhancements such as payment gateway integration, recommendation systems, and advanced analytics, ensuring long-term scalability and business growth.
