<%--
  Created by IntelliJ IDEA.
  User: Ihor
  Date: 4/9/2017
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
    <title><tiles:getAsString name="title" /></title>

    <link href="${pageContext.servletContext.contextPath}/content/css/Site.css" rel="stylesheet"></link>
    <link href="${pageContext.servletContext.contextPath}/content/css/Spinner.css" rel="stylesheet"></link>
    <link href="${pageContext.servletContext.contextPath}/content/css/lib/bootstrap.css" rel='stylesheet'>
    <link href="${pageContext.servletContext.contextPath}/content/css/lib/bootstrap-theme.css" rel='stylesheet'>
    <link href="${pageContext.servletContext.contextPath}/content/css/lib/bootstrap-datepicker.css" rel='stylesheet'>

    <tiles:insertAttribute name="styles" />
    <script type='text/javascript' src="${pageContext.servletContext.contextPath}/content/js/lib/jquery.js"></script>
    <script type='text/javascript' src="${pageContext.servletContext.contextPath}/content/js/lib/bootstrap.js"></script>
    <script type='text/javascript' src="${pageContext.servletContext.contextPath}/content/js/lib/bootstrap-datepicker.js"></script>
    <script type='text/javascript' src="${pageContext.servletContext.contextPath}/content/js/lib/spin.js"></script>
    <script type='text/javascript' src="${pageContext.servletContext.contextPath}/content/js/Spinner.js"></script>

</head>
<body>

<nav class="navbar navbar-default navbar-inverse" style="border-radius: 0;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">HWS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="#">Rooms</a></li>
            <li><a href="<c:url value="/Contact" />">Contact Us</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal != null}">
                <li><a href="<c:url value="/Secured/User/Profile" />">Hello ${pageContext.request.userPrincipal.name}!</a></li>
                <li><a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="<c:url value="/Register" />"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="<c:url value="/login" />"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:otherwise>
        </c:choose>
        </ul>
    </div>
</nav>

<!-- Render body -->
<div>
    <tiles:insertAttribute name="body" />
</div>

<script>
    $(document).ready(function() {
        $('li.active').removeClass('active');
        $('a[href="' + location.pathname + '"]').closest('li')
                                                .addClass('active');
    });
</script>

<!-- Render Scripts -->
<div>
    <tiles:insertAttribute name="scripts" />
    <script type="text/javascript">
        $(document).ready(function () {
            $('.datepicker').datepicker({
                autoclose: true,
                format: 'dd/mm/yyyy'
            });
        });
    </script>
</div>

</body>
</html>
