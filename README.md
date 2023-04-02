# Online-Shopping-Application

![1](https://user-images.githubusercontent.com/108060013/228165545-74718570-01b4-46d7-a295-347587c23629.png)

## REST A.P.I
Online Shopping Application allows customers to browse and purchase products with a good user-friendly interface. The API is designed to provide a wide range of functionalities for managing products, orders, and customer along with different functionalities of admin and its information.

The API offers features for browsing products, including the ability to save items to a cart for future purchase.It also supports CRUD operations for managing products and orders.
This application will help Customer to buy the products and view order details.
Customer can register themselves and login. Add product to the cart and purchase it .
This application will help Admin to search Product list ,add new products ,remove products and update product .


The application also includes user and admin validation and authentication.



## Tech Stack

- JAVA
- SPRING
- SPRINGBOOT
- HIBERNATE
- MAVEN
- J.D.B.C
- MYSQL
- JPQL
- POSTMAN

## Dependencies

- SPRING DATA JPA
- SPRING BOOT DEVTOOLS
- SPRING WEB
- HIBERNATE
- MYSQL DRIVER
- VALIDATION
- LOMBOK
- SWAGGER UI

## Setting & Installation 

Install the Spring Tools Suite 
```bash
https://spring.io/tools
```

Install MySQL Community Server

```bash
https://dev.mysql.com/downloads/mysql/
```

Clone the Repository

```bash
git clone https://github.com/Im-vishalanand/adhesive-cactus-7535.git
```

Open MySQL Server
```bash
Create a New Database in SQL: "online_shopping_application" 
```
## Run Locally


Go to the Project Directory

```bas
Open the Online_Shopping_System Folder with S.T.S
```

Go to **src/main/resources > application.properties** & change your username and password (MySQL server username & password)

```bash
spring.datasource.username="username"
spring.datasource.password="password"
```

To change the **Server Port**

```bash
server.port=8888
```

Go to **com.masai package > OnlineShoppingApplication.java**

```bash
Run as Spring Boot App
```
Open the following URL for Swagger-UI 
```bash
http://localhost:8888/swagger-ui/
```

## ER Diagram

![Untitled (4)](https://user-images.githubusercontent.com/108060013/229367477-6b0a3b30-743a-48ba-a84f-d2143e6b4058.png)

## Demo


## URL
```bash
http://localhost:8888
```
## Customer API Reference
![image](https://user-images.githubusercontent.com/108060013/229314507-9e398f0d-b8c2-4355-85d0-e12cec43ea24.png)

## Product API Reference
![image](https://user-images.githubusercontent.com/108060013/229314531-83898492-1b4a-4b01-8e83-ac3caf77d081.png)

## Address API Reference
![image](https://user-images.githubusercontent.com/108060013/229314548-7f7918f8-2595-45c5-8b99-c0b43501cb5f.png)

## Cart API Reference
![image](https://user-images.githubusercontent.com/108060013/229314557-de7e4e02-0524-4fcd-81b9-f0cc793d20f7.png)

## Order API Reference
![image](https://user-images.githubusercontent.com/108060013/229314565-c8fa5f14-87c0-43e7-ad14-0c6d6f74b523.png)


## Acknowledgements

- [Masai School](https://www.masaischool.com/)
