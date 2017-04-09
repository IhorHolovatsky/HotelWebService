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

    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap.min.css") %>'>
    <link rel='stylesheet' href='<%= org.webjars.AssetLocator.getWebJarPath("css/bootstrap-theme.min.css") %>'>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.min.js") %>'></script>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("js/bootstrap.min.js") %>'></script>
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
