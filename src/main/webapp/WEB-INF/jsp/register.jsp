<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 22.06.2016
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file ="/WEB-INF/jspf/libraries.jspf"%>

<html>
<head>
    <title>Adapp register</title>
    <link href="${SemanticCSS}" rel="stylesheet" />
    <link href="${SemanticJS}" />
</head>
<body>
<div class="three column row">
    <div class="column">
        lewa
    </div>
    <div class="column">
        <form class="ui form">
            <div class="field">
                <label>User name</label>
                <input name="user-name" placeholder="User Name" type="text">
            </div>
            <div class="field">
                <label>Password</label>
                <input name="password" placeholder="Password" type="text">
            </div>
                <button class="ui green button" type="submit">Register</button>
        </form>
    </div>
    <div class="column">
        prawa
    </div>
</div>
</body>
</html>
