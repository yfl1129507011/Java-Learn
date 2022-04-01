<%--
  Created by IntelliJ IDEA.
  User: fenlon
  Date: 2022/3/15
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include</title>
</head>
<body>
    <%@include file="common/header.jsp"%>
    <h1>include-main</h1>
    <%@include file="common/footer.jsp"%>

    <jsp:include page="common/header.jsp" />
    <h1>jsp-main</h1>
    <jsp:include page="common/footer.jsp" />
</body>
</html>
