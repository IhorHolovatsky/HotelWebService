<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${userBookings == null || userBookings.size() == 0}">
        <h3>Sorry, You don't have active bookings</h3>
    </c:when>
    <c:otherwise>
        <c:if test="${deleteResult != null && deleteResult}">
            <h2 class="alert-success">Booking was successfully cancelled!</h2>
        </c:if>
        <c:forEach var="booking" items="${userBookings}">

            <c:set var="BookingRoom" value="${booking.getBookingRooms().get(0)}"></c:set>
            <c:set var="room" value="${BookingRoom.getRoom()}"></c:set>

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
                        <div class="col-md-3">
                            <b>From:</b>
                        </div>
                        <div class="col-md-3">
                                ${BookingRoom.getStartDateFormat()}
                        </div>
                        <div class="col-md-1">
                            <b>To:</b>
                        </div>
                        <div class="col-md-5">
                                ${BookingRoom.getEndDateFormat()}
                        </div>
                        <div class="col-md-5">
                            <b>Amount Paid:</b>
                        </div>
                        <div class="col-md-7">
                            $${booking.getRoomCost()}
                        </div>
                        <div class="col-md-5">
                            <b>Additional Notes:</b>
                        </div>
                        <div class="col-md-7">
                                ${room.additionalNotes}
                        </div>
                        <div class="col-md-12"> </div>
                        <div class="col-md-5">
                            <b>Booking Made On:</b>
                        </div>
                        <div class="col-md-7">
                                ${booking.getDateTimeMadeFormat()}
                        </div>
                    </div>
                    <div class="col-md-2">
                        <a href="#" class="btn btn-danger removeBooking"
                           style="margin-top:20px;"
                           data-booking-id="${booking.bookingId}">Cancel</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>