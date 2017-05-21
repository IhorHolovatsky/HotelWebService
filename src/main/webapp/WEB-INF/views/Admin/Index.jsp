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

                $("#addRoom").on('click', function(){

                    var addRoomArgs = {};
                    addRoomArgs.RoomId = $("#roomID").val();
                    addRoomArgs.HotelId = $("#hotelID").val();
                    addRoomArgs.RoomTypeId = $("#roomTypeID").val();
                    addRoomArgs.Name = $("#name").val();
                    addRoomArgs.Price = parseFloat($('#price').val()).toFixed(2);
                    addRoomArgs.Number = $("#number").val();
                    addRoomArgs.Floor = $("#floor").val();
                    addRoomArgs.Comment = $("#comment").val();


                    <c:url var="addRoomUrl" value="/Secured/Admin/AddRoom"></c:url>
                    $.ajax({
                        url: '${addRoomUrl}',
                        contentType: "application/json",
                        dataType: "html",
                        method: "POST",
                        data: JSON.stringify(addRoomArgs),
                        success: function (data) {
                            $("#roomsDb").html(data);
                        }
                    });
                })
            });
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-6 col-sm-6 col-md-6 flex-first">
                    <h2>All Rooms</h2>
                    <div id="roomsDb">
                        <jsp:include page="RoomsDB.jsp"/>
                    </div>
                </div>
                <div class="col-6 col-sm-6 col-md-6 flex-last">
                    <h2>Database Rooms</h2>
                    <div class="form-group">
                        <label for="roomID">RoomID</label>
                        <input type="text" class="form-control" id="roomID">
                    </div>
                    <div class="form-group">
                        <label for="hotelID">HotelID</label>
                        <input type="text" class="form-control" id="hotelID">
                    </div>
                    <div class="form-group">
                        <label for="roomTypeID">RoomTypeID</label>
                        <input type="text" class="form-control" id="roomTypeID">
                    </div>
                    <div class="form-group row">
                        <div class="col-xs-5">
                            <label for="name">Name</label>
                            <input class="form-control" id="name" type="text">
                        </div>
                        <div class="col-xs-3">
                            <label for="price">Price</label>
                            <input class="form-control" id="price" type="text">
                        </div>
                        <div class="col-xs-2">
                            <label for="number">Number</label>
                            <input class="form-control" id="number" type="text">
                        </div>
                        <div class="col-xs-2">
                            <label for="floor">Floor</label>
                            <input class="form-control" id="floor" type="text">
                        </div>
                        <div class="form-group row">
                            <div class="col-xs-12">
                                <label for="comment">Comment:</label>
                                <textarea class="form-control" rows="4" id="comment"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6">
                                <button id="addRoom" class="btn btn-primary btn-lg btn-block" data-toggle="confirmation">
                                    <div class="glyphicon glyphicon-plus"></div>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row align-items-center">
                <div class="col-6 col-sm-3 col-md-6 flex-last">
                    <h2>All Bookings</h2>
                    <table class="table table-condensed table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Customer name</th>
                            <th>DateTimeMade</th>
                            <th>Booking comment</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <c:forEach items="${allBookings}" var="booking">
                        <tbody>
                        <tr>
                            <td>
                                <c:out value="${booking.roomId}" />
                            </td>
                            <td>
                                <c:out value="${booking.floor}" />
                            </td>
                            <td>
                                <c:out value="${booking.number}" />
                            </td>
                            <td>
                                <c:out value="${booking.price}" />
                            </td>
                            <td>
                                <button class="btn .btn-warning .btn-sm" data-toggle="confirmation">
                                    <div id="edit1" class="glyphicon glyphicon-pencil"></div>
                                </button>
                            </td>
                            <td>
                                <button class="btn .btn-danger .btn-sm" data-toggle="confirmation">
                                    <div id="delete1" class="glyphicon glyphicon-remove-circle"></div>
                                </button>
                            </td>
                        </tr>
                        <tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>