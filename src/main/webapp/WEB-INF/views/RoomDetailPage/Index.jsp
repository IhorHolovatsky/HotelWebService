<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Room Page</tiles:putAttribute>

    <tiles:putAttribute name="body">

        <c:choose>
            <c:when test="${isSuccess == false}">
                <h3>Sorry, something really bad happened! Please, try again later!
                <a href="Contact"> Go to contacts</a></h3>
            </c:when>
            <c:otherwise>
                <div class="container-fluid">
                    <div class="content-wrapper">
                        <div class="item-container">

                            <div class="container">
                                <div class="col-md-12">

                                    <div class="product">

                                        <c:url var="getImage" value="/GetImage"></c:url>
                                        <img src="${getImage}?roomId=${RoomId}">
                                    </div>
                                </div>

                                <div class="col-md-7">
                                    <div class="product-title">${Room.name}</div>
                                    <div class="product-desc">${Room.roomType.roomType}</div>

                                    <hr>
                                    <div class="product-price">$ ${CurrentPrice}</div>

                                    <hr>
                                    <div class="product-price">
                                            ${BookingTime}
                                    </div>
                                    <hr>

                                    <div class="btn-group cart">
                                        <c:url var="addBooking" value="/Secured/RoomDetailPage/Booking"></c:url>
                                        <form method="POST" action="${addBooking}">

                                            <input type="hidden" name="RoomId" value="${RoomId}"/>
                                            <input type="hidden" name="StartDate" value="${StartDate}"/>
                                            <input type="hidden" name="EndDate" value="${EndDate}"/>

                                            <button type="submit" class="btn btn-primary pull-right">
                                                Booking
                                            </button>
                                            <form>
                                    </div>

                                </div>
                            </div>

                        </div>
                        <div class="container-fluid">
                            <div class="col-md-12 product-info">
                                <ul id="myTab" class="nav nav-tabs nav_tabs">

                                    <li class="active">
                                        <a href="#service-one" data-toggle="tab">DESCRIPTION</a>
                                    </li>

                                </ul>
                                <div id="myTabContent" class="tab-content">
                                    <div class="tab-pane fade in active" id="service-one">

                                        <section class="container product-info">
                                                ${Room.additionalNotes}

                                            <h3>Room Features:</h3>

                                            <c:forEach var="facility" items="${FacilitiesList}">
                                                <li>${facility}</li>
                                            </c:forEach>

                                        </section>

                                    </div>

                                </div>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>


    </tiles:putAttribute>
</tiles:insertDefinition>