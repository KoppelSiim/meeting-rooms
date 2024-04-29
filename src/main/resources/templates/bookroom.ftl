<!DOCTYPE html>
<html>
<head>
    <title>Book room</title>
</head>
<body>
<h1>Book room</h1>
<form action="/api/book/${room.id()}" method="post">
    <div>
        <label for="bookedFrom">Booked From:</label>
        <input type="datetime-local" id="bookedFrom" name="bookedFrom">
    </div>
    <div>
        <label for="bookedTo">Booked To:</label>
        <input type="datetime-local" id="bookedTo" name="bookedTo">
    </div>
    <div>
        Roomname:${room.roomName()}</br>
        Room number:${room.roomNumber()}
    </div>
    <button type="submit">Book room</button>
</form>
</body>
</html>