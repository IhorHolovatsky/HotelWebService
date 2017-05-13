<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">My Profile</tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-md-4">Your Profile</div>
            <div class="col-md-8">
                You rooms
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6"></div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>