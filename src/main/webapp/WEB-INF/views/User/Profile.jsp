<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">My Profile</tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div>
            <div class="col-md-4 profile-block">
                <h2>Your Profile</h2>
                <br/>
                <div class="${errorMessage != null ? 'has-error' : ''}">
                    <form action="/Secured/User/Profile" method="post">
                        <input type="hidden" name="UserId" value="${userProfile.userId}">
                        <input type="hidden" name="CustomerId" value="${userProfile.customerId}">
                        <input type="hidden" name="Customer.CustomerId" value="${userProfile.customer.customerId}">
                        <div class="form-group">
                            <label for="firstName" class="col-2 col-form-label">First Name</label>
                            <div class="col-10">
                                <input name="Customer.FirstName" class="form-control" type="text"
                                       value="${userProfile.customer.firstName}" id="firstName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-2 col-form-label">Last Name</label>
                            <div class="col-10">
                                <input name="Customer.LastName" id="lastName" class="form-control" type="text"
                                       value="${userProfile.customer.lastName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dateOfBirth" class="col-2 col-form-label">Date Of Birth</label>
                            <div class="col-10">
                                <div class="input-group">
                                    <input class="form-control datepicker" type="text"
                                           name="Customer.DateBirth"
                                           value="${userProfile.customer.formattedDateBirth}" id="dateOfBirth">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-2 col-form-label">Phone</label>
                            <div class="col-10">
                                <input class="form-control"
                                       name="Customer.HomePhone"
                                       type="text" value="${userProfile.customer.homePhone}" id="phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="col-2 col-form-label">Username</label>
                            <div class="col-10">
                                <input class="form-control"
                                       name="Login"
                                       type="text" value="${userProfile.login}" id="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-2 col-form-label">
                                <span>${errorMessage}</span>
                                <span style="color:green">${success}</span>
                            </label>
                            <div class="col-10">
                                <button type="submit" class="btn btn-primary pull-right">Save Changes</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-8">
                <h2>Your Bookings</h2>
                <br/>
                <div class="container-fluid">
                    <div id="bookings" style="padding-top: 30px;">
                        <jsp:include page="UserBookings.jsp" />
                    </div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>