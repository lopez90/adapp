<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 22.06.2016
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jspf/libraries.jspf"%>

<html>
<head>
    <title>Adapp register</title>

    <link href="${SemanticCSS}" rel="stylesheet" />
    <script src="${SemanticJS}"></script>
</head>
<body>
<div class="ui grid">
    <div class="four wide column">

    </div>
    <div class="eight wide column">
        <form class="ui form">
            <div class="field">
                <label>Username</label>
                <input name="username" placeholder="Username" type="text">
            </div>
            <div class="field">
                <label>Password</label>
                <input name="password" placeholder="Password" type="text">
            </div>
            <button class="ui center aligned button" type="submit">Submit</button>
        </form>
    </div>
    <div class="four wide column">

    </div>
</div>
</body>
</html>
