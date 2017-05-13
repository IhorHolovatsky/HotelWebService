<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>All Rooms</h2>
<c:choose>
    <c:when test="${rooms.size() == 0}">
        <h3>Sorry, No rooms available...</h3>
    </c:when>
    <c:otherwise>
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
                    <button class="btn btn-warning .btn-sm" data-toggle="confirmation">
                        <div id="edit" class="glyphicon glyphicon-pencil"></div>
                    </button>
                </td>
                <td>
                    <button class="btn btn-danger .btn-sm" data-toggle="confirmation">
                        <div id="delete" class="glyphicon glyphicon-remove-circle"></div>
                    </button>
                </td>
            </tr>
            <tbody>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>