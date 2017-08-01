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
