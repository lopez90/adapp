<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 22.06.2016
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jspf/libraries.jspf"%>

<html>
<head>
    <title>Adapp register</title>

    <script src="${jQuery}"></script>

    <link href="${SemanticCSS}" rel="stylesheet" />
    <script src="${SemanticJS}"></script>

    <script>
        $(document).ready(function() {

            // init .ui.form validation
            $('.ui.form')
                    .form({
                        on: 'blur',
                        fields: {
                        username: {
                            identifier  : 'username',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter a gender'
                                },
                                {
                                    type   : 'regExp[/^[a-z0-9_-]{3,16}$/]',
                                    prompt : 'Username is incorrect'
                                }
                            ]
                        },
                        email: {
                            identifier  : 'email',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter your email'
                                },
                                {
                                    type   : 'email',
                                    prompt : 'Email is incorrect'
                                }
                            ]
                        },
                        password: {
                            identifier  : 'password',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter your name'
                                },
                                {
                                    type   : 'minLength[6]',
                                    prompt : 'Password must have 6 sings'
                                }
                            ]
                        },
                        confirmPassword: {
                            identifier  : 'confirmPassword',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter your name'
                                },
                                {
                                    type   : 'match[password]',
                                    prompt : 'Passwords must be the same'
                                }
                            ]
                        }}
                    })
            ;

            // send form by Ajax
            $('.ui.form').on('submit', function(e){
                e.preventDefault();
                $.ajax({
                    url: '<c:url value=""/>',
                    type: "post",
                    data: formToJSON(),
                    dataType : "json",
                    contentType: 'application/json; charset=utf-8',
                    async: false,
                    success: function(data) {
                        console.log(formToJSON());
                        location.replace("/")
                    }
                })
            })
        });

        // pack ui.form data to JSON format
        function formToJSON() {
            return JSON.stringify({
                "username": $('.ui.form').form('get value', 'username'),
                "email": $('.ui.form').form('get value', 'email'),
                "password": $('.ui.form').form('get value', 'password'),
            })
        }
    </script>
</head>
<body>
<div class="ui grid">
    <div class="eight wide centered column">
        <form class="ui form">
            <div class="field">
                <label>Username</label>
                <input name="username" placeholder="Username" type="text">
            </div>
            <div class="field">
                <label>Email</label>
                <input name="email" placeholder="Email" type="text">
            </div>
            <div class="field">
                <label>Password</label>
                <input name="password" placeholder="Password" type="password">
            </div>
            <div class="field">
                <label>Confirm password</label>
                <input name="confirmPassword" placeholder="Confirm password" type="password">
            </div>
            <button class="ui button" type="submit">Submit</button>
            <div class="ui error message"></div>
        </form>
    </div>
</div>
</body>
</html>
