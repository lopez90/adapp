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
  <a href="?mylocale=en">English </a> | <a href="?mylocale=pl">Polish</a>
  <h3> <spring:message code="Index.Message"/></h3>
  <div class="ui steps">
    <div class="step">
      Shipping
    </div>
  </div>
  </body>
  </html>
  </body>
</html>
