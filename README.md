# NM-full

GET /products
GET /products?page=1
GET /products?sortBy=price&direction=asc
GET /products?sortBy=price&direction=desc
GET /products?page=0&size=5&sortBy=name

the above is ex 4

/products/category/Electronics

/products/search?keyword=key

/products/price/under?max=300

/products/price/above?min=300

the above is ex 5

GET http://localhost:8080/products

PUT http://localhost:8080/products/1

With this JSON body:

json

{
    "name": "Gaming Laptop",
    "price": 1299.99,
    "category": "Electronics"
}


the above is ex 6

GET http://localhost:8080/products
GET http://localhost:8080/products/expensive?minPrice=300
GET http://localhost:8080/products/search?keyword=lap
GET http://localhost:8080/products/search?keyword=Furniture

ex7

CREATE
POST http://localhost:8080/products
Body → raw → JSON:
{
    "name": "Keyboard",
    "price": 89.99,
    "category": "Electronics"
}
READ ALL
GET http://localhost:8080/products
READ ONE
GET http://localhost:8080/products/1
UPDATE
PUT http://localhost:8080/products/1
Body → raw → JSON:
{
    "name": "Gaming Laptop",
    "price": 1299.99,
    "category": "Electronics"
}
DELETE
DELETE http://localhost:8080/products/1

ex8

Test in browser directly
http://localhost:8080/orders/place?product=Laptop
http://localhost:8080/orders/cancel?product=Laptop

ex10

Test in Postman
Flights
GET  /flights
GET  /flights/1
GET  /flights/search?source=Chennai&destination=Mumbai
GET  /flights/fare?max=5000
POST /flights  → { "flightNumber":"IG105", "source":"Mumbai", "destination":"Chennai", "departureTime":"16:00", "fare":4000, "availableSeats":60 }
PUT  /flights/1
DELETE /flights/1
Passengers
GET  /passengers
POST /passengers → { "name":"Sneha", "email":"sneha@gmail.com", "phone":"9876543213" }
PUT  /passengers/1
DELETE /passengers/1
Bookings
GET /bookings
POST /bookings?flightId=1&passengerId=1
GET  /bookings/passenger/1
GET  /bookings/flight/1
PUT  /bookings/1/cancel
DELETE /bookings/1

ex9 and 13

Doctors
GET  /doctors
GET  /doctors/1
GET  /doctors/specialization/Cardiology
POST /doctors
→ { "name":"Dr. Kumar", "specialization":"Dermatology", "phone":"9876543214" }
PUT  /doctors/1
DELETE /doctors/1
Appointments
GET  /appointments
GET  /appointments/doctor/1
GET  /appointments/patient/John

POST /appointments?doctorId=1&patientName=John&date=2024-02-01

PUT  /appointments/1/cancel
DELETE /appointments/1


ex11

Trains
GET  /trains
GET  /trains/1
GET  /trains/search?source=Chennai&destination=Mumbai
POST /trains
→ { "trainNumber":"IR105", "source":"Mumbai", "destination":"Chennai", 
    "departureTime":"14:00", "fare":1100.00, "availableSeats":90 }
PUT  /trains/1
DELETE /trains/1
Bookings
GET  /bookings
GET  /bookings/1
GET  /bookings/train/1
GET  /bookings/passenger/John
POST /bookings?trainId=1&passengerName=Kumar&date=2024-02-05
PUT  /bookings/1/cancel
DELETE /bookings/1

ex12

Projects
GET  /projects
GET  /projects/1
GET  /projects/1/phases       ← all phases of project 1
GET  /projects/1/effort       ← total effort in person-days
GET  /projects/1/cost         ← total cost of project

POST /projects
→ { "projectName":"Payroll", "clientName":"TCS",
    "startDate":"2024-03-01", "endDate":"2024-09-01",
    "status":"ACTIVE", "totalBudget":400000.00 }

PUT    /projects/1
DELETE /projects/1
Phases
GET  /phases
GET  /phases/1

POST /phases?projectId=1&phaseName=Design&effortDays=10&teamSize=3&cost=30000

DELETE /phases/1

ex14

Movies
GET /movies
GET /movies/1
GET /movies/genre/Action
GET /movies/language/English
GET /movies/rating?min=8.0
POST /movies
→ { "title":"Avatar", "genre":"Sci-Fi", "language":"English",
    "director":"Cameron", "duration":192, "rating":7.8,
    "releaseDate":"2022-12-16" }
PUT    /movies/1
DELETE /movies/1
Theatres
GET /theatres
GET /theatres/location/Chennai
POST /theatres
→ { "name":"Cinepolis", "location":"Delhi",
    "totalSeats":400, "availableSeats":300 }
PUT    /theatres/1
DELETE /theatres/1
Tickets
GET /tickets
GET /tickets/customer/John
GET /tickets/movie/1
GET /tickets/theatre/1
POST /tickets?movieId=1&theatreId=1&customerName=Kumar
     &email=kumar@gmail.com&showTime=07:00 PM&seats=2&totalAmount=500
PUT  /tickets/1/cancel
DELETE /tickets/1


ex15
