<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answers</title>
</head>
<body>
    <h3>Question</h3>
    <p>${question}</p>
    <h3>Answers</h3>
    <c:forEach var="answer" items="${answers}">
        <h4>User: </h4>
        <p>${answer.userId}</p>
        <h4>Text: </h4>
        <p>${answer.text}</p>
    </c:forEach>

</body>
</html>
