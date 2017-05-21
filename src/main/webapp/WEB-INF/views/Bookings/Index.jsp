<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Rooms</tiles:putAttribute>
    <tiles:putAttribute name="styles">
        <link href="${pageContext.servletContext.contextPath}/content/css/VerticalTabs.css" rel='stylesheet'>
    </tiles:putAttribute>
    <tiles:putAttribute name="scripts">
        <script type='text/javascript'
                src="${pageContext.servletContext.contextPath}/content/js/CustomTabs.js"></script>
        <script>
            $(document).ready(function(){
                $("#searchButton").unbind('click').on('click', function(){

                    var searchArgs = {};
                    searchArgs.RoomTypeId = selectedRoomType;
                    searchArgs.StartDate = $("#startDate").val();
                    searchArgs.EndDate = $("#endDate").val();

                    <c:url var="searchRoomsUrl" value="/SearchRooms"></c:url>
                    $.ajax({
                        url: '${searchRoomsUrl}',
                        contentType: "application/json",
                        dataType: "html",
                        method: "POST",
                        data: JSON.stringify(searchArgs),
                        success: function (data) {
                            $("#rooms").html(data);
                            initButtons();
                        }
                    });
                })
                initButtons();
            });

            function initButtons(){
                $(".bookRoom").on('click', function(e){
                    var bookUrl = '<c:url value="/Secured/RoomDetailPage" />';
                    var roomId = e.target.attributes["data-room-id"].value;
                    var startDate = $("#startDate").val();
                    var endDate = $("#endDate").val();

                    window.location.href = bookUrl + "/?roomId=" + roomId +
                        "&startDateString=" + startDate +
                        "&endDateString=" + endDate;
                });
            }
        </script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div>
            <div class="col-md-4 profile-block" style="width: 300px; height: 90%">
                <div class="container-fluid">
                    <h2>Room Types</h2>
                    <br/>

                    <div class="tab">
                        <button class="tablinks active" room-type-id="" onclick="selectRoomType(event)">All</button>
                        <c:forEach var="roomType" items="${roomTypes}">
                            <button class="tablinks" room-type-id="${roomType.roomTypeId}" onclick="selectRoomType(event)">${roomType.roomType}</button>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <h2>Rooms</h2>
                <br/>

                <div class="container-fluid">
                    <form id="searchFilters" class="form-inline">
                        <label for="startDate">Start Date:</label>
                        <div class="input-group" style="max-width: 250px">
                            <input class="form-control datepicker" type="text"
                                   value="${startDate}"
                                   id="startDate">
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <label style="padding-left: 50px;" for="endDate">End Date:</label>
                        <div class="input-group" style="max-width: 300px">
                            <input class="form-control datepicker"
                                   type="text"
                                   value="${endDate}"
                                   id="endDate">
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <button id="searchButton" class="btn btn-primary pull-right" type="button">Search</button>
                    </form>

                    <div id="rooms" style="padding-top: 30px;">
                        <jsp:include page="Rooms.jsp"/>
                    </div>
                </div>

            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>