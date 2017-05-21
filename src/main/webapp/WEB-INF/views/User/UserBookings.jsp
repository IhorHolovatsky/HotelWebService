<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${userBookings == null || userBookings.size() == 0}">
        <h3>Sorry, You don't have active bookings</h3>
    </c:when>
    <c:otherwise>
        <c:forEach var="booking" items="${userBookings}">
            <c:set var="room" value="${booking.BookingRooms.get(0).Room}"></c:set>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-3">
                        <img width="150px" src="/GetImage?roomId=${booking.BookingRooms.get(0).roomId}">
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