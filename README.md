# dc-service
Debt Collection Service made for evaluation by Intrum Justitia

## Requirements
Create a REST service, that would support following functionality:
* Simple registration (email, password). No email verification is required
* Creating a customer record (name, surname, email address, personal Id)
* Submit a debt collection case against the client (due date, amount)
* Close the debt case as either resolved (client paid all amount) or defaulted (not paid)
* Creating customer, submitting and modifying DC case must be protected using authentication - json web token or alternative
* Customers and their cases can only belong to one user. If more than one user is registered, they should not see each other's clients and DC cases

## What will be evaluated
* Functionality according to the requirements
* Code quality
* Test quality
* Ease of deployment

## Technologies
* Java + Spring
* Testing framework, DB and everything else is a personal choice

## How to run
This will launch the app on port 8080:
```
git clone https://github.com/Valentin-Paramonov/dc-service.git
cd dc-service
./gradlew bootRun
```

## Endpoints
* /user/register

 Authentication: None

 Request:
```json
{
    "email": "a@b.cd",
    "password":"ha"
}
```
* /user/login

 Authentication: None

 Request:
```json
{
    "email": "a@b.cd",
    "password":"ha"
}
```
* /customer/create

 Authentication: Required (JWT)

 Request:
```json
{
    "name": "Mark",
    "surname": "Plank",
    "personalId": "personalId",
    "email": "mark@b.cd"
}
```
* /debt-case/:personal-id/submit

 Authentication: Required (JWT)

 Request:
```json
{
    "dueDate": "2016-09-18",
    "amount": "420.69"
}
```
Response:
```
Debt Case Id
```
* /debt-case/:case-id/close

 Authentication: Required (JWT)
 Request:
```json
{
    "resolution": "Resolved|Defaulted"
}
```
