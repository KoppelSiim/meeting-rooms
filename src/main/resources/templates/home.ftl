<!DOCTYPE html>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
    <h1>List of Rooms:</h1>
    <ul>
        <#list roomViewModels as room>
            <li>${room.roomName()}</li>
            <li>${room.roomNumber()}</li>
        </#list>
    </ul>
</body>
</html>