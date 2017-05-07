<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Login</tiles:putAttribute>
    <tiles:putAttribute name="body">

        Hello ${UserName}!!!
        <br/>
        <a href="<c:url value="/logout" />">Logout</a>
    </tiles:putAttribute>
</tiles:insertDefinition>