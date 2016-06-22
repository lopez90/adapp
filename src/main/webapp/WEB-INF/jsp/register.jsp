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
<form class="ui form">
    <div class="field">
        <label>First Name</label>
        <input name="first-name" placeholder="First Name" type="text">
    </div>
    <div class="field">
        <label>Last Name</label>
        <input name="last-name" placeholder="Last Name" type="text">
    </div>
    <div class="field">
        <div class="ui checkbox">
            <input class="hidden" tabindex="0" type="checkbox">
            <label>I agree to the Terms and Conditions</label>
        </div>
    </div>
    <button class="ui button" type="submit">Submit</button>
</form>
</body>
</html>
