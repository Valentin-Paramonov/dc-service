#!/bin/bash

set -o nounset
set -o errexit
set -ex

curl -iX POST -H 'Content-Type: application/json' localhost:8080/user/register --data '{"email": "a@b.cd", "password":"ha"}'
auth_header="$(curl -i -H 'Content-Type: application/json' localhost:8080/user/login --data '{"email": "a@b.cd", "password":"ha"}' | grep 'Authentication')"
curl -iX POST -H 'Content-Type: application/json' -H "$auth_header" localhost:8080/customer/create --data '{"name": "Mark", "surname": "Plank", "personalId": "whatever", "email": "mark@b.cd"}'
id=$(curl -X POST -H 'Content-Type: application/json' -H "$auth_header" localhost:8080/debt-case/whatever/submit --data '{"dueDate": "2016-09-18", "amount": "420.69"}')
curl -iX POST -H 'Content-Type: application/json' -H "$auth_header" localhost:8080/debt-case/$id/close --data '{"resolution": "Resolved"}'
