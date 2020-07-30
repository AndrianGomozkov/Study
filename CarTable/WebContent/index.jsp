<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cars</title>
</head>
<body>
<h2>Car List</h2>
<p><a href='<c:url value="/create" />'>Add new</a></p>
<table>
<tr><th>Model</th><th>Color</th><th>Complect</th></tr>
<c:forEach var="car" items="${car}">
 <tr><td>${car.model}</td>
     <td>${car.color}</td>
     <td>${car.complect}</td>
     <td>
    <a href='<c:url value="/edit?id=${car.idcar}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="id" value="${car.idcar}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>