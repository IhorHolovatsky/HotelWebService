<%--
  Created by IntelliJ IDEA.
  User: Ihor
  Date: 4/9/2017
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><tiles:getAsString name="title" /></title>

    <link href="content/css/Site.css" rel="stylesheet"></link>
    <link href="content/css/lib/bootstrap.css" rel='stylesheet'>
    <link href="content/css/lib/bootstrap-theme.css" rel='stylesheet'>
    <script type='text/javascript' src="content/js/lib/jquery.js"></script>
    <script type='text/javascript' src="content/js/lib/bootstrap.js"></script>
</head>
<body>

<div>
    I'm layout text!
</div>

<br/>
<!-- Render body -->
<div>
    <tiles:insertAttribute name="body" />
</div>

</body>
</html>
