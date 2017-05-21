<%--
  Created by IntelliJ IDEA.
  User: Ihor
  Date: 5/7/2017
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Register</tiles:putAttribute>
    <tiles:putAttribute name="body">

        <div class="container">


            <form method="POST" action="/Register" class="form-signin">
                <h2 class="form-heading">Register New User</h2>
                <br/>
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>

                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input id="firstName" name="FirstName" type="text" class="form-control"
                               autofocus="true"/>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input id="lastName" name="LastName" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <span class="tooltip">will be used for login</span>
                        <input id="email" name="Username" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" name="Password" type="password" class="form-control"/>
                    </div>

                    <span>${error}</span>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
                    <h4 class="text-center"><a href="<c:url value="/login"/>">Cancel</a></h4>
                </div>
            </form>

        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>

