# Online-Bank-API

A REST API built using Java Spring framework with Maven build.

This API works as a service for Users, the services provided by the API emulate an online banking service.

This project is intended to work with other REST APIs in a microservices environment.

The data is stored in MySQL database, you just need to create the schema with the name `BankAPI` or change the properties file to your liking. Also in the properties file you can uncomment the SQLServer configuration commands and work with the SQLServer database.

Mapstruct plugin is used for DTO mapping.

Here are the HTTP requests you can use with this API:

## HTTP Requests

### User Requests

#### GET A User by National ID

<http://localhost:8080/api/users/nid?nid=value>

This requset takes a String parameter `nid` and its value represents the NID of the user you want to get.

#### GET A User by phone number

<http://localhost:8080/api/users/phone?phone=value>

This requset takes a long parameter `phone` and its value represents the phone number of the user you want to get.

#### POST A User

<http://localhost:8080/api/users>

The body of the request should have a JSON object like this :

```JSON
{
    "full_name": "full name",
    "phone_number": 123456789,
    "national_id": "xyz987654321"
}
```

#### PATCH A User

<http://localhost:8080/api/users/nid?nid=value>

The body of the request should have a JSON object like this :

```JSON
{
    "full_name": "full name",
    "phone_number": 123456789
}
```

This requset takes a String parameter `nid` and its value represents the NID of the User you want to edit.

### Account Requests

#### GET An Account by ID

<http://localhost:8080/api/accounts/{id}>

The {id} integer represents the id of the Account in the database.

#### GET All Transactions of An Account

<http://localhost:8080/api/accounts/{id}/transactions>

The {id} integer represents the id of the Account in the database.

#### POST An Account

<http://localhost:8080/api/accounts?nid=value>

The body of the request should have a JSON object like this :

```JSON
{
    "account_type":"saving||current",
    "balance":2500
}
```

This requset takes a String parameter `nid` and its value represents the NID of the User you want to add an account to.

#### DELETE An Account by ID

<http://localhost:8080/api/accounts/{id}>

The {id} integer represents the id of the Account in the database.

#### POST A Deposit to An Account

<http://localhost:8080/api/accounts/{id}/deposit?d=value>

The {id} integer represents the id of the Account in the database. And this requset takes an int parameter `d` and its value represents the amount to be deposited.

#### POST A Withdrawal from An Account

<http://localhost:8080/api/accounts/{id}/withdraw?w=value>

The body of the request should have a JSON object like this :

The {id} integer represents the id of the Account in the database. And this requset takes an int parameter `w` and its value represents the amount to be withdrawn.

### Transfer Requests

#### POST A Transfer

<http://localhost:8080/api/transfers>

The body of the request should have a JSON object like this :

```JSON
{
    "sender_id":2,
    "receiver_id":1,
    "amount":1000
}
```

### Error Codes

The Requests has the following Error Codes :

#### 1- ResourceNotFound

```JSON
{
    "code": 1,
    "message": "item with this id not found",
    "details": "make sure to submit a viable id"
}
```

#### 2- InsufficientBalance

```JSON
{
    "code": 2,
    "message": "Insufficient funds for the completion of the transaction",
    "details": "Make sure the required funds are available"
}
```
