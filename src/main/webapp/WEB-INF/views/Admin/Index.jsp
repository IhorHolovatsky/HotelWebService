<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 5/13/2017
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">My Profile</tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div class="col-md-4 profile-block">
        <h2>All Rooms</h2>
        <br/>
        <form action="/Secured/Admin/Index/" method="post">
            <div class="form-group">
                <div class="col-10">
                    <input class="form-control" type="text" value="${allRooms[0].name}" id="firstName">
                </div>
            </div>
        </form>

    </tiles:putAttribute>
</tiles:insertDefinition>
