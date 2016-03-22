<%--
  Created by IntelliJ IDEA.
  User: ustbgao
  Date: 16-2-27
  Time: 上午11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/getUser.do" method="post">
    <input type="hidden" name="name" value="gao"/>

</form>
<c:forEach var="user" items="${models}">
    ${user.userId}
    ${user.userName}
    ${name}
</c:forEach>

</body>
</html>
