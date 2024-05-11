<!DOCTYPE html>
<html lang="et">
<head>
    <meta charset="UTF-8">
    <title>Koosolekuruumid</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Tubade nimekiri</h1>
    <a href="/addroom">Lisa ruum</a></br>
    <a href="/freerooms">Vabad ruumid</a>
        <#list roomViewModels as room>
            <div>
                <ul style="list-style:none;">
                <li>Room name: ${room.roomName()}</li>
                <li>Room number: ${room.roomNumber()}</li>
                <a href="book/${room.id()}">Book</a>
                </ul>
            </div>
        </#list>
</body>
</html>