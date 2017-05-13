<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Rooms</tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div>
            <div class="col-md-4 profile-block">
                <h2>Room Types</h2>
                <br/>

                <ul id="#roomType" class="nav nav-pills nav-stacked">
                    <c:forEach var="roomType" items="${roomTypes}">
                        <li>${roomType.roomType}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-md-8">
                <h2>Rooms</h2>
                <br/>

                <div class="row">
                    <div class="form-group">
                        <label for="startDate">Start Date:</label>
                        <div class="input-group" style="max-width: 300px">
                            <input class="form-control datepicker" type="text" id="startDate">
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                    <div class="form-group" style="padding-left: 10px;">
                        <label for="endDate">End Date:</label>
                        <div class="input-group" style="max-width: 300px">
                            <input class="form-control datepicker" type="text" id="endDate">
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>