<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2020
  Time: 2:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Appliction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
    <header>
    <nav class="navbar navbar-expand-md navbar-drak" style="...">
        <div>
            <a href="">User Managemet App</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
    <br>
    <div class="container col-md-5">
        <div class="card-body">
            <c:if test="${user != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${user != null}">
                <form action="insert" method="post">
            </c:if>
                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user != null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value="${user.id}" />"/>
                    </c:if>
                    <fieldset class="form-group">
                        <label>User Name</label> <input type="text" value="<c:out value="${use.name}" />" class="form-control" name="name" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>User Email</label> <input type="text" value="<c:out value="${use.email}" />" class="form-control" name="email" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>User Country</label> <input type="text" value="<c:out value="${use.country}" />" class="form-control" name="country" required="required">
                    </fieldset>
                    <button type="submit" class="btn btn-success"></button>
                </form>
        </div>
    </div>
</body>
</html>
