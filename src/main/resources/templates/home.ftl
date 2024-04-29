<!DOCTYPE html>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
    <h1>List of Rooms:</h1>
    <ul>
        <#list roomViewModels as room>
            <div>
            <li>${room.roomName()}</li>
            <li>${room.roomNumber()}</li>
            <li><a href="book/${room.id()}">Book</a><li/>
            </div>
        </#list>
    </ul>
</body>
</html>