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
    <tiles:putAttribute name="scripts">
        <script>
            $(document).ready(function(){

                initButtons();

            });

            function initButtons(){

                $("#addRoom").on('click', function(){

                    var addRoomArgs = {};

                    if($("#economRadioButton").is(":checked")){
                        addRoomArgs.RoomTypeId = "ac7370f2-a69c-4ac1-9e4b-bf2575d15a36";
                    }
                    if($("#standardRadioButton").is(":checked")){
                        addRoomArgs.RoomTypeId = "ab7270f6-a69d-4ac1-9e4b-bf2575d15a36";
                    }
                    if($("#businessRadioButton").is(":checked")){
                        addRoomArgs.RoomTypeId = "c30cfca7-b5c3-4051-9c4a-3d0c0fb0b6c3";
                    }

                    addRoomArgs.Name = $("#name").val();
                    addRoomArgs.Price = parseFloat($('#price').val()).toFixed(2);
                    addRoomArgs.Number = $("#number").val();
                    addRoomArgs.Floor = $("#floor").val();
                    addRoomArgs.Comment = $("#comment").val();

                    getFileBytes("pic");

setTimeout(function (){

    addRoomArgs.ImageData = imageData;

    <c:url var="addRoomUrl" value="/Secured/Admin/AddRoom"></c:url>
    $.ajax({
        url: '${addRoomUrl}',
        contentType: "application/json",
        dataType: "html",
        method: "POST",
        data: JSON.stringify(addRoomArgs),
        success: function (data) {
            $("#roomsDb").html(data);
            initButtons();
        }
    });
}, 500);


                })

                $(".deleteRoom").on('click', function(e){

                    debugger;

                    var roomId = e.target.parentElement.attributes["data-room-id"].value;

                    <c:url var="deleteRoomUrl" value="/Secured/Admin/DeleteRoom"></c:url>
                    $.ajax({
                        url: '${deleteRoomUrl}',
                        contentType: "application/json",
                        dataType: "html",
                        method: "POST",
                        data: roomId,
                        success: function (data) {
                            $("#roomsDb").html(data);
                            initButtons();
                        }
                    });
                })
            }
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div class="container">
            <div class="row">
                <div class="col-6 col-sm-6 col-md-6 flex-first">
                    <h2>All Rooms</h2>
                    <div id="roomsDb">
                        <jsp:include page="RoomsDB.jsp"/>
                    </div>
                </div>

            </div>

            <%--<div class="row">--%>
                <%--<div class="col-6 col-sm-3 col-md-6 flex-last">--%>
                    <%--<h2>All Bookings</h2>--%>
                    <%--<table class="table table-condensed table-hover">--%>
                        <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th>ID</th>--%>
                            <%--<th>Customer name</th>--%>
                            <%--<th>DateTimeMade</th>--%>
                            <%--<th>Booking comment</th>--%>
                            <%--<th>Edit</th>--%>
                            <%--<th>Delete</th>--%>
                        <%--</tr>--%>
                        <%--</thead>--%>
                        <%--<c:forEach items="${allBookings}" var="booking">--%>
                        <%--<tbody>--%>
                        <%--<tr>--%>
                            <%--<td>--%>
                                <%--<c:out value="${booking.roomId}" />--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<c:out value="${booking.floor}" />--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<c:out value="${booking.number}" />--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<c:out value="${booking.price}" />--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<button class="btn .btn-warning .btn-sm" data-toggle="confirmation">--%>
                                    <%--<div id="edit1" class="glyphicon glyphicon-pencil"></div>--%>
                                <%--</button>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                                <%--<button class="btn .btn-danger .btn-sm" data-toggle="confirmation">--%>
                                    <%--<div id="delete1" class="glyphicon glyphicon-remove-circle"></div>--%>
                                <%--</button>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                        <%--<tbody>--%>
                        <%--</c:forEach>--%>
                    <%--</table>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>