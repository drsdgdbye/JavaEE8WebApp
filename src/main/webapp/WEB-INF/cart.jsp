<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Cart</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="padding: 2%">
<%@include file="/WEB-INF/jspf/menu.jspf" %>
<h2>cart</h2>
<jsp:useBean id="cartList" scope="session" class="servlets.CartServlet"/>
<jsp:setProperty name="cartList" property="productToCart" param="product"/>
<c:if test="${cartList.cartList.size() == 0}">
    <p>cart is empty</p>
</c:if>
<c:if test="${cartList.cartList.size() > 0}">
    <ul style="list-style-type: none">
        <c:forEach items="${cartList.cartList}" var="cartItem">
            <li>
                    ${cartItem}
            </li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
