<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${rooms.size() == 0}">
        <h3>Sorry, No rooms available...</h3>
    </c:when>
    <c:otherwise>
        <c:forEach var="room" items="${rooms}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-3">
                        <c:url var="getImage" value="/GetImage"></c:url>
                        <img width="150px" src="${getImage}?roomId=${room.roomId}">
                    </div>
                    <div class="col-md-7">
                        <div class="col-md-12">
                            <h3><a class="bookRoom"
                                   data-room-id="${room.roomId}"
                                   href="#">${room.name}</a></h3>
                        </div>
                        <div class="col-md-12">
                            <b>$ ${room.price}</b>
                        </div>
                        <div class="col-md-12">
                                ${room.additionalNotes}
                        </div>
                    </div>
                    <div class="col-md-2">
                        <a href="#" class="btn btn-info bookRoom"
                           style="margin-top:20px;"
                           data-room-id="${room.roomId}">Book It</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>