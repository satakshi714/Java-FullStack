

ROOM API

POST 
http://localhost:9092/rooms

{
  "roomId": 1,
  "roomNumber": "A101",
  "roomType": "Single",
  "price": 2500,
  "status": "Available"
}

GET 
http://localhost:9092/rooms


GET by Id 
http://localhost:9092/rooms/1


PUT 
http://localhost:9092/rooms/1

{
  "roomId": 1,
  "roomNumber": "A101",
  "roomType": "Deluxe",
  "price": 4000,
  "status": "Occupied"
}


DELETE
http://localhost:9092/rooms/1



BOOKING APIs


POST 
http://localhost:9092/bookings

{
  "bookingId": 101,
  "customerName": "Satakshi",
  "customerPhone": "9876543210",
  "checkInDate": "2026-03-10",
  "checkOutDate": "2026-03-12",
  "room": {
    "roomId": 1
  }
}

GET 
http://localhost:9092/bookings



GET by Id
http://localhost:9092/bookings/101


PUT 
http://localhost:9092/bookings/101

{
  "bookingId": 101,
  "customerName": "Satakshi Sharma",
  "customerPhone": "9999999999",
  "checkInDate": "2026-03-11",
  "checkOutDate": "2026-03-14",
  "room": {
    "roomId": 1
  }
}



DELETE 
http://localhost:9092/bookings/101

