<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
    <h2><c:out value="${user.getName()}"/></h2>
    <form action="/signin" method="post">
        <input type="text" title="Name" name="name">
        <input type="password" title="Password" name="password">
        <button>Sing in</button>
    </form>
    <form action="/signup" method="post">
        <input type="text" title="Name" name="name">
        <input type="password" title="Password" name="password">
        <button>Sing up</button>
    </form>
    <h2>${user.name}</h2>
    <c:forEach var="question" items="${questions}">
        <br>
        <a href="/question/${question.id}">${question.title}</a>
        <br>
        <p>${question.text}</p>
    </c:forEach>
<br/>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
    <script src="./main.js"></script>
</body>
</html>
