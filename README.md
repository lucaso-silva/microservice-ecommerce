# E-Commerce Microservices
This project is a basic **E-commerce Management System** developed during the **"Bootcamp Dio Riachuelo - First Steps with Java"**, built with **Spring Boot**, and structured as two microservices:

- **Warehouse Service:** manages products, stock, and availability
- **Storefront Service:** exposes available products to customers

The services communicate with each other through **REST** and **RabbitMQ messaging**.
Both services are containerized with **Docker** and orchestrated using **Docker Compose**.

**Gradle** is used as the build tool

## Learning Objectives
- Practice **microservice architecture** with Spring Boot
- Integrate services using **Rest Clients** and **RabbitMQ**
- Configure and run services with **Docker** and **Docker Compose**
- Apply **Spring Data JPA** and **H2 in-memory database** for persistence
- Use **Lombok** and **MapStruct** for cleaner and more maintainable code
- Document APIs with **Springdoc OpenAPI**

## Features
- **Warehouse**
  - Register and manage products
  - Track product stock and status
  - Publish stock available changes via RabbitMQ
- **Storefront**
  - Display products to customers
  - Update product availability in real time (consuming RabbitMQ messages)

## Future Improvements
- Use unit tests
- Replace H2 with a persistent database
- Add a frontend interface

---

### Acknowledgments
- [DIO](https://www.dio.me/en)
- The instructor José Luiz Abreu Cardoso Junior
