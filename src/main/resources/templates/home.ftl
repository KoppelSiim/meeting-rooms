<!DOCTYPE html>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
    <h1>List of Rooms</h1>
    <a href="/addroom"> Add room </a></br>
    <a href="/freerooms"> Free rooms </a>
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