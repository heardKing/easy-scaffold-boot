<%--
  Created by IntelliJ IDEA.
  User: cuixx
  Date: 2019/4/19
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>欢迎页</title>
</head>
<body>
<c:url value="/resources/text.txt" var="url"/>
<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
Spring URL: ${springUrl} at ${time}
<br>
JSTL URL: ${url}
<br>
Message: ${message}
</body>
</html>
