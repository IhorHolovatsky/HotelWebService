<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${rooms.size() == 0}">
        <h3>Sorry, No rooms available...</h3>
    </c:when>
    <c:otherwise>
        <c:forEach var="room" items="${rooms}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-4">
                        Fucking Image
                    </div>
                    <div class="col-md-8">
                        <div class="col-md-12">
                            <h3><a href="/RoomDetailPage?roomId=${room.roomId}">${room.name}</a></h3>
                        </div>
                        <div class="col-md-12">
                            <b>$ ${room.price}</b>
                        </div>
                        <div class="col-md-12">
                                ${room.additionalNotes}
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>