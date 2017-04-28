<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Login</tiles:putAttribute>
    <tiles:putAttribute name="body">

        <div class="container">

            <c:url value="/login" var="loginUrl" />
            <form method="POST" action="${loginUrl}" class="form-signin">
                <h2 class="form-heading">Log in</h2>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" placeholder="Username"
                           autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <span>${error}</span>
                    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                    <h4 class="text-center"><a href="#">Create an account</a></h4>
                </div>

            </form>

        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>

