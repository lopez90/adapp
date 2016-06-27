<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 20.06.2016
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file ="/WEB-INF/jspf/libraries.jspf"%>
<link href="${SemanticCSS}" rel="stylesheet" />
<script src="${jQuery}"></script>

<html>
  <head>
    <title><spring:message code="Index.Message"/></title></head>
    <link href="${SemanticCSS}" rel="stylesheet" />
    <script src="${jQuery}"></script>
  <body>
  <div class="ui inverted vertical masthead center aligned segment">
    <div class="ui container">
      <div class="ui large secondary inverted pointing menu">
        <a class="toc item">
          <i class="sidebar icon"></i>
        </a>
        <a class="active item">Home</a>
        <a class="item">Work</a>
        <a class="item">Company</a>
        <a class="item">Careers</a>
        <div class="right item">
          <a class="ui inverted button">Log in</a>
          <a class="ui inverted button">Sign Up</a>
        </div>
      </div>
    </div>
  </div>
  </body>
  </html>
  </body>
</html>
