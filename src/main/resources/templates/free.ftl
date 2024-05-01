<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#list roomViewModels as room>
<div>
    <ul style="list-style:none;">
        <li>Room ${room_index + 1}</li>
        <li>Room name: ${room.roomName()}</li>
        <li>Room number: ${room.roomNumber()}</li>
    </ul>
</div>
</#list>
</body>
</html>