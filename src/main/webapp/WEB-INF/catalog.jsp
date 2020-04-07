<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Catalog</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="padding: 2%">
<%@include file="/WEB-INF/jspf/menu.jspf" %>
<h2>catalog</h2>
<jsp:useBean id="productMap" scope="request" class="servlets.CatalogServlet"/>
<c:url value="cart?product=" var="addToCart"/>
<table style="padding: 2%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>add to cart</th>
    </tr>
    <c:forEach items="${productMap.products}" var="product">
        <tr>
            <td>${product.key}</td>
            <td><a href="product">${product.value}</a></td>
            <td><a class="btn btn-primary" href="${addToCart}${product.value}">add</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
