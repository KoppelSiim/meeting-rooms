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
    <form id="book" action="/api/book/${room.id()}" method="post">
        <div class="form-item">
            <label for="bookedFrom">Broneeringu algus</label>
            <input type="datetime-local" id="bookedFrom" name="bookedFrom">
        </div>
        <div class="form-item">
            <label for="bookedTo">Broneeringu lõpp</label>
            <input type="datetime-local" id="bookedTo" name="bookedTo">
        </div>
        <button type="submit">Broneeri</button>
    </form>
    <div class="rooms book-align">
        <ul style="list-style:none;">
            <li> Ruumi nimi: ${room.roomName()}</li>
            <li> Ruumi number: ${room.roomNumber()}</li>
        </ul>
    </div>
</div>
</body>
</html>