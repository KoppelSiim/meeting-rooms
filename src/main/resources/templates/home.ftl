<!DOCTYPE html>
<html lang="et">
<head>
    <meta charset="UTF-8">
    <title>Koosolekuruumid</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Tubade nimekiri</h1>
    <div class="nav">
        <a href="/addroom">Lisa ruum</a>
        <a href="/freerooms">Vabad ruumid</a>
    </div>
        <#list roomViewModels as room>
            <div class="rooms">
                <ul style="list-style:none;">
                    <li>Ruumi nimi: ${room.roomName()}</li>
                    <li>Ruumi number: ${room.roomNumber()}</li>
                    <li><a href="book/${room.id()}">Broneeri</a></li>
                </ul>
            </div>
        </#list>
</body>
</div>
</html>