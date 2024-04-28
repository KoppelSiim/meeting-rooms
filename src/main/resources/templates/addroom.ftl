<!DOCTYPE html>
<html>
<head>
	<title>Add room view</title>
</head>
<body>
<h1>Add room</h1>
<form action="api/addroom" method="post">
    <div>Roomname:</div>
    <input type="text" name="roomName"/>
    <div>Room number:</div>
    <input type="number" name="roomNumber"/></br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>