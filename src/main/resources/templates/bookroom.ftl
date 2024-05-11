<!DOCTYPE html>
<html lang="et">
<head>
    <meta charset="UTF-8">
    <title>Koosolekuruumid</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<div class="container">
    <h1>Broneeri ruum</h1>
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
            Roomname:${room.roomName()}
            Room number:${room.roomNumber()}
        </div>
        <button type="submit">Book room</button>
    </form>
</div>
</body>
</html>