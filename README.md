# OftenShopping - Backend

The backend of **OftenShopping** is a full-stack e-commerce application built with **Java** and **Spring Boot**. It handles all server-side logic, database operations, and REST APIs for the platform.

## Table of Contents
- [About](#about)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Architecture](#architecture)
- [Installation](#installation)
- [API Testing](#api-testing)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## About
The backend provides the core functionality for the e-commerce platform, supporting **three types of users**:  
- **Customer**: Browse and purchase products.  
- **Admin**: Add and manage products, monitor orders.  
- **Delivery Person**: Manage delivery of orders.  

The backend is designed using **microservices architecture** and exposes **REST APIs** for seamless communication with the frontend.

## Technologies Used
- **Programming Language:** Java  
- **Framework:** Spring Boot  
- **Architecture:** Microservices  
- **Database:** MySQL  
- **API Testing:** Postman  
- **Tools:** Git, Maven  

## Features
- Multi-user system: Customer, Admin, Delivery Person  
- Admin panel for product management  
- Customer can browse products, add to cart, and purchase  
- Delivery person manages deliveries  
- Microservices for scalable architecture  
- REST API endpoints for frontend integration  

## Architecture
- Microservices-based backend for modularity and scalability  
- REST APIs for handling requests and responses  
- Separate services for users, products, orders, and delivery  

## Installation
Clone the repository and set up the backend locally:

```bash
git clone <your-repo-link>
cd backend
mvn clean install
mvn spring-boot:run
