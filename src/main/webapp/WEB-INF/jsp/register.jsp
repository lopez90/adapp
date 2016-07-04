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
        $('.ui.form')
                .form({
                    fields: {
                        username: {
                            identifier: 'username',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter a username'
                                }
                            ]
                        },
                        email: {
                            identifier: 'email',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter a email'
                                },
                                {
                                    type   : 'minLength[6]',
                                    prompt : 'Your password must be at least {ruleValue} characters'
                                },
                                {
                                    type   : 'email',
                                    prompt : 'Incorrect email address'
                                }
                            ]
                        },
                        password: {
                            identifier: 'password',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter a password'
                                },
                                {
                                    type   : 'minLength[6]',
                                    prompt : 'Your password must be at least {ruleValue} characters'
                                },
                                {
                                    type   : 'minLength[6]',
                                    prompt : 'Your password must be at least {ruleValue} characters'
                                }
                            ]
                        },
                        confirmPassword: {
                            identifier: 'confirmPassword',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter a password'
                                },
                                {
                                    type   : 'match[password]',
                                    prompt : 'Your passwords must be match'
                                },
                                {
                                    type   : 'minLength[6]',
                                    prompt : 'Your password must be at least {ruleValue} characters'
                                },
                                {
                                    type   : 'regExp[/[0-9]/]',
                                    prompt : 'Your password must have number characters'
                                },
                                {
                                    type   : 'regExp[/[A-Z]/]',
                                    prompt : 'Your password must have big letter characters'
                                }
                            ]
                        },
                    }
                });

        $(document).ready(function() {
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
