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
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:forEach items="${allRooms}" var="rooms">
    <tbody>
    <tr>
        <td>
            <c:out value="${rooms.roomId}" />
        </td>
        <td>
            <c:out value="${rooms.floor}" />
        </td>
        <td>
            <c:out value="${rooms.number}" />
        </td>
        <td>
            <c:out value="${rooms.price}" />
        </td>
        <td>
            <c:out value="${rooms.name}" />
        </td>
        <td>
            <c:out value="${rooms.roomType.roomType}" />
        </td>
        <td>
            <button class="btn btn-warning .btn-sm" id="edit" data-toggle="confirmation">
                <div class="glyphicon glyphicon-pencil"></div>
            </button>
        </td>
        <td>
            <button class="btn btn-danger .btn-sm" id="delete" data-toggle="confirmation">
                <div class="glyphicon glyphicon-remove-circle"></div>
            </button>
        </td>
    </tr>
    <tbody>
    </c:forEach>
</table>