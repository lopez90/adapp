<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 27.06.2016
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file ="/WEB-INF/jspf/libraries.jspf"%>


<html>
<head>
    <link href="${SemanticCSS}" rel="stylesheet" />
    <script src="${jQuery}"></script>
    <title>Title</title>
</head>
<body>
<div class="ui two column middle aligned very relaxed stackable grid">
    <div class="column">
        <div class="ui form">
            <div class="field">
                <label>Username</label>
                <div class="ui left icon input">
                    <input vk_15b37="subscribed" placeholder="Username" type="text">
                    <i class="user icon"></i>
                </div>
            </div>
            <div class="field">
                <label>Password</label>
                <div class="ui left icon input">
                    <input vk_15b37="subscribed" type="password">
                    <i class="lock icon"></i>
                </div>
            </div>
            <div class="ui blue submit button">Login</div>
        </div>
    </div>
    <div class="ui vertical divider">
        Or
    </div>
    <div class="center aligned column">
        <div class="ui big green labeled icon button">
            <i class="signup icon"></i>
            Sign Up
        </div>
    </div>
</div>
</body>
</html>
