<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>404</title>

    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Cabin:400,700" rel="stylesheet">

    <!-- custom stlylesheet -->
    <style>
        <%@include file='../styles/main.css' %>
    </style>
</head>

<body>
<div id="notfound">
    <div class="notfound">
        <div class="notfound-404">
            <div></div>
            <h1>403</h1>
        </div>
        <h2>Page forbidden</h2>
        <a href="${pageContext.request.contextPath}">home page</a>
    </div>
</div>
</body>
</html>
