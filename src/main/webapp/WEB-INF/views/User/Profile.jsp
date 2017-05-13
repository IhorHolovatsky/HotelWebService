<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">My Profile</tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div>
            <div class="col-md-4 profile-block">
                <h2>Your Profile</h2>
                <br/>
                <form action="/Secured/User/Profile" method="post">
                    <div class="form-group">
                        <label for="firstName" class="col-2 col-form-label">First Name</label>
                        <div class="col-10">
                            <input class="form-control" type="text" value="${userProfile.customer.firstName}" id="firstName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-2 col-form-label">Last Name</label>
                        <div class="col-10">
                            <input id="lastName" class="form-control" type="text" value="${userProfile.customer.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirth" class="col-2 col-form-label">Date Of Birth</label>
                        <div class="col-10">
                            <input class="form-control" type="text" value="${userProfile.customer.dateBirth}" id="dateOfBirth">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-2 col-form-label">Phone</label>
                        <div class="col-10">
                            <input class="form-control" type="text" value="${userProfile.customer.homePhone}" id="phone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="username" class="col-2 col-form-label">Username</label>
                        <div class="col-10">
                            <input class="form-control" type="text" value="${userProfile.login}" id="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-2 col-form-label">Password</label>
                        <div class="col-10">
                            <input class="form-control" type="password" value="" id="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-2 col-form-label"></label>
                        <div class="col-10">
                            <button type="submit" class="btn btn-primary pull-right">Save Changes</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-8">
                <h2>Your Bookings</h2>
                <br/>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6"></div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>