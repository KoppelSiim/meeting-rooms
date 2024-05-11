<!DOCTYPE html>
<html lang="et">
<head>
    <meta charset="UTF-8">
	<title>Koosolekuruumid</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Lisa ruum</h1>
    <form action="api/addroom" method="post">
        <div>Ruumi nimi:</div>
        <input type="text" name="roomName"/>
        <div>Ruumi number:</div>
        <input type="number" name="roomNumber"/></br>
        <input type="submit" value="Submit"/>
    </form>
    <a href="/home">Kodu</a>
    </div>
</body>
</html>