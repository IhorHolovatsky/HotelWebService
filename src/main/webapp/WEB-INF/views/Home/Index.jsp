<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="title">Index Page</tiles:putAttribute>


    <tiles:putAttribute name="body">

        <div class="video-background">
            <div class="video-foreground">
                <iframe src="https://www.youtube.com/embed/bDpO8i4Aty0?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=bDpO8i4Aty0"
                        frameborder="0" allowfullscreen></iframe>
            </div>
        </div>

        <div id="vidtop-content">

            <div class="vid-info">
                <h1>Hotel Web Service</h1>
                <p>
                    Your perfect summer vacations! Lot of fun, sea, drugs, girls and drugs!
                <p>
                    Pick your start date!
                <p>
                    <input class="datepicker">
                    <a href="">Go, pick up your perfect room!</a>
            </div>

        </div>
        <tiles:putAttribute name="scripts">Index Page
            <script type="text/javascript">
                $(document).ready(function () {
                    $('.datepicker').datepicker({
                        autoclose: true
                    });
                });
            </script>
        </tiles:putAttribute>
    </tiles:putAttribute>
</tiles:insertDefinition>

