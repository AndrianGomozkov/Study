<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
<input type="hidden" value="${product.id}" name="id" />
<label>Model</label><br>
<input name="model" value="${car.model}" /><br><br>
<label>Color</label><br>
<input name="color" value="${car.color}" /><br><br>
<label>Complect</label><br>
<input name="complect" value="${car.complect}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>