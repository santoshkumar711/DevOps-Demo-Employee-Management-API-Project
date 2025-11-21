# 🚀 DevOps Demo – Employee Management API (Spring Boot)

A CI/CD automated **Employee Management API** project built using **Spring Boot** and **Hibernate**, deployed on **AWS EC2** and **ECS** using **Docker** and **Jenkins pipelines**.  
This project demonstrates the full DevOps lifecycle — from code commit to deployment and testing automation.

---

## 🧩 Key Features
- 👥 CRUD operations for Employee management  
- 🔐 REST API with Spring Boot and Hibernate ORM  
- 🗄️ Database integration with **AWS RDS (MariaDB & PostgreSQL)**  
- 🐳 Containerized using **Docker & Docker Compose**  
- ⚙️ Automated deployment on **AWS EC2** and **ECS (Elastic Container Service)**  
- 🔁 CI/CD pipeline setup using **Jenkins (Maven-based build)**  
- 🧪 API testing with **Postman**, **Swagger**, and **JMeter**

---

## 🏗️ Tech Stack

| **Category** | **Technology** |
|---------------|----------------|
| Language | Java |
| Framework | Spring Boot, Hibernate, Spring Cloud |
| API Tools | REST API, Swagger |
| Database | MariaDB, PostgreSQL (AWS RDS) |
| Containerization | Docker |
| Deployment | AWS EC2, AWS ECS |
| CI/CD | Jenkins (Maven-based pipelines) |
| Testing | Postman, JMeter |
| Version Control | Git / GitHub |
| Operating System | Ubuntu Linux |

---

## ✅ Application URLs

- **Local:** [http://localhost:8082/employee](http://localhost:8082/employee)  
- **Cloud (AWS EC2):** `http://<AWS-EC2-ENDPOINT>:8082/employee`

---

## ⚙️ Spring Boot Configuration

### 🧱 Local Setup (`application.properties`)
```properties
spring.datasource.url=jdbc:mysql://localhost:3307/santosh
spring.datasource.username=root
spring.datasource.password=santoor711
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
server.port=8082


### Cloud Setup (AWS RDS + EC2)
spring.datasource.url=jdbc:mariadb://ec2-16-170-7-215.eu-north-1.compute.amazonaws.com:3306/employee
spring.datasource.username=santosh
spring.datasource.password=santoor711
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true

server.port=8082

🐳Docker Commands
# Build Docker image
docker build -t employee-app:v1 .

# Run container
docker run -d -p 8082:8082 employee-app:v1

👨‍💻 Author

Santosh Kumar
Role: DevOps Engineer
📧 Email: santoshkumar711711@gmail.com

🌐 GitHub: https://github.com/santoshkumar711/DevOps-Demo-Employee-Management-API-Project
