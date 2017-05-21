<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-condensed table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Floor</th>
        <th>Number</th>
        <th>Price</th>
        <th>Name</th>
        <th>Type</th>
        <th>Image</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${allRooms}" var="rooms">
    <tr>
        <td>
            <c:out value="${rooms.roomId}"/>
        </td>
        <td>
            <c:out value="${rooms.floor}"/>
        </td>
        <td>
            <c:out value="${rooms.number}"/>
        </td>
        <td>
            <c:out value="${rooms.price}"/>
        </td>
        <td>
            <c:out value="${rooms.name}"/>
        </td>
        <td>
            <c:out value="${rooms.roomType.roomType}"/>
        </td>
        <td>
            <img height="90" width="90" src="/GetImage?roomId=${rooms.roomId}">
        </td>

        <td>
            <button class="btn btn-warning .btn-sm" id="editRoom" data-toggle="confirmation" data-room-id="${rooms.roomId}">
                <div class="glyphicon glyphicon-pencil"></div>
            </button>
        </td>
        <td>
            <button class="btn btn-danger .btn-sm deleteRoom" data-room-id="${rooms.roomId}" data-toggle="confirmation">
                <div class="glyphicon glyphicon-remove-circle"></div>
            </button>
        </td>
    </tr>
    </c:forEach>





    <tbody>

</table>

<button class="btn btn-primary" data-toggle="modal" data-target="#addModal" id="add">
    <div class="glyphicon glyphicon-plus"></div>
</button>

<!--Add Modal -->
<div id="addModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add room</h4>
            </div>
            <div class="modal-body">

                <div class="form-group row">
                    <div class="col-xs-3">
                        <label for="name">Room Image</label>
                    </div>
                    <input id="pic" type="file" name="pic" accept="image/*">
                </div>

                <div class="form-group row">
                    <div class="col-xs-3">
                        <label for="name">Room type</label>
                    </div>
                    <label class="radio-inline col-xs-2">
                        <input type="radio" name="optradio" id="economRadioButton">Econom
                    </label>
                    <label class="radio-inline col-xs-2">
                        <input type="radio" name="optradio" id="standardRadioButton">Standard
                    </label>
                    <label class="radio-inline col-xs-2">
                        <input type="radio" name="optradio" id="businessRadioButton">Business
                    </label>
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
                </div>
                <div class="form-group row">
                    <div class="col-xs-12">
                        <label for="comment">Comment:</label>
                        <textarea class="form-control" rows="2" id="comment"></textarea>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="addRoom" class="btn btn-primary" data-dismiss="modal">Add</button>
            </div>
        </div>

    </div>
</div>