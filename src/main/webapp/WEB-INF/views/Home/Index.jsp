<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultLayout" >
    <tiles:putAttribute name="title">Index Page</tiles:putAttribute>


    <tiles:putAttribute name="body">

        I'm Index Content
        <br/>
        ${TestObject.name}



    </tiles:putAttribute>
</tiles:insertDefinition>

