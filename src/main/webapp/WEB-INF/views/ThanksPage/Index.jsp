<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Thanks Page</tiles:putAttribute>

    <tiles:putAttribute name="body">

            <h3>Thank you ! We will contact you shortly!
                <a href="<c:url value="/Contact"></c:url>"> Go to contacts</a></h3>


    </tiles:putAttribute>
</tiles:insertDefinition>
