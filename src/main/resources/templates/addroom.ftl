<!DOCTYPE html>
<html lang="et">
<head>
    <meta charset="UTF-8">
    <title>Koosolekuruumid</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<div class="container">
    <h1>Lisa ruum</h1>
    <form action="api/addroom" method="post">
        <div class="form-item">
            <label for="roomName">Ruumi nimi</label>
            <input type="text"  id="roomName" name="roomName"/>
        </div>
        <div class="form-item">
            <label for="roomNumber">Ruumi number</label>
            <input type="number" id="roomNumber" name="roomNumber"/>
        </div>
        <button type="submit" value="Submit">Lisa</button>
    </form>
    <a href="/home">Kodu</a>
</div>
</body>
</html>