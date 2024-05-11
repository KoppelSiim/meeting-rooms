<!DOCTYPE html>
<html lang="et">
<head>
    <meta charset="UTF-8">
    <title>Koosolekuruumid</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <div class="container">
    <h1>Vabad ruumid</h1>
    <a href="/home">Kodu</a>
    <#list roomViewModels as room>
    <div class="rooms">
        <ul style="list-style:none;">
            <li>${room_index + 1}</li>
            <li>Toa nimi: ${room.roomName()}</li>
            <li>Toa number: ${room.roomNumber()}</li>
        </ul>
    </div>
    </#list>
    </div>
</body>
</html>