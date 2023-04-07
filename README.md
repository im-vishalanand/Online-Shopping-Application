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

![Untitled (6)](https://user-images.githubusercontent.com/108060013/230663364-c66551be-ad26-4727-9d69-698fc4e4c40b.png)
## Demo


## URL
```bash
http://localhost:8888
```

## Admin API Reference
![image](https://user-images.githubusercontent.com/108060013/230663739-ab543ce2-d04f-4375-8229-261697b51c6a.png)

## Login & Logout API Reference
![image](https://user-images.githubusercontent.com/108060013/230663800-30c78be6-7482-4829-9d0d-3df87feb169c.png)

## User API Reference
![image](https://user-images.githubusercontent.com/108060013/230663870-cc1b7502-41be-492d-9510-6a7e1082bfc8.png)

## Customer API Reference
![image](https://user-images.githubusercontent.com/108060013/230663453-60e78195-e12b-4e55-85ee-35461721e155.png)

## Product API Reference
![image](https://user-images.githubusercontent.com/108060013/230663499-4431ce14-aed9-4772-8009-57cce1b2b72f.png)

## Address API Reference
![image](https://user-images.githubusercontent.com/108060013/230663546-20e36ee8-e10e-4b81-9551-0673960b30cb.png)

## Cart API Reference
![image](https://user-images.githubusercontent.com/108060013/230663604-78a871d6-fb5f-41b8-b1e9-0c9361cf9b57.png)

## Order API Reference
![image](https://user-images.githubusercontent.com/108060013/230663655-83ffd46b-3520-4495-8994-daead1c76a07.png)



# Contributors

#### Kumar Vishal Anand
> Github: [Im-vishalanand](https://github.com/Im-vishalanand) 
(Teamlead)

> => created the controller of order, product and user.

> => Implemented the service methods order, product and user.

#### Md Humair Raza
> Github: [mdhumairraza](https://github.com/mdhumairraza)

> => Created controller of Customer , admin, cart, address, login and logout.

> => Implemented the service methods of Customer , admin, cart, address, login and logout.

#### Vivek Sangode
>Github: [vivekSangode](https://github.com/vivekSangode)
Worked on Exceptional Handling and Respositories



## Acknowledgements

- [Masai School](https://www.masaischool.com/)
