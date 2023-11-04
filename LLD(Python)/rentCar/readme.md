// renting a car
// vehicle
- basic info
- mileage
- model
- total km run
- make year
- vehicle type -> (enum: car, bike)
- vehicle status -> active, inactive


vehicle Inventory
- list<vehicles>
- CRUD


Store:
- storeid
- vehicle inventory obj
- location
- list<reservations> // booking

location:
- address
- store obj
- pincode

Reservation: //against a vehicle
reservation id
vehicle -> full info
booking date
to 
from
user


User
- user id
- driving license
- personal info

bill/invoice
- Reservation
- amount
- ispaid


payment
- Bill
- paymentDone?




Vehicle Rental Systems
list<user>
list<store>

// CRUD

