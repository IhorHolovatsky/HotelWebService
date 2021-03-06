<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultLayout">
    <tiles:putAttribute name="styles">
        <link href="${pageContext.servletContext.contextPath}/content/css/contactForm.css" rel="stylesheet"></link>
    </tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div id="#fuckingJava">
            <div>
                <center><h1><b><i> Contact Us </i></b></h1></center>
            </div>
            <br/>
            <div class="row">
                <div class="col-md-12 titlebar">
                    <h1>Some <strong>words about</strong> us</h1>
                    <p>Praesent semper, lacus sed cursus porta, odio augue feugiat tincidunt ligula massa in primis
                        faucibus
                        posuere cubilia </p>
                </div>
            </div>

            <div id="about-1-text" class="col-md-8 animated fadeInLeft">

                <h4>What we do?</h4>

                <p>Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur
                    magni
                    dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum,
                    quia
                    dolor sit,
                    Numquam eius modi tempora incidunt, ut labore et dolore magnam aliquam quaerat voluptatem.
                </p>

                <!--  Accordion -->
                <div id="accordion_holder">
                    <h4>Why choose us?</h4>

                    <!-- Text #1 -->
                    <button class="accordion">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit?
                    </button>
                    <div class="panel">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua.
                            Nostrud exercitation ullamco laboris aliquipea commodo consequat.
                        </p>
                    </div>

                    <!-- Text #2 -->
                    <button class="accordion">
                        Aenean consequat lorem ut felis ullamcorper?
                    </button>
                    <div class="panel">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua.
                            Ut enim ad minim veniam.
                        </p>
                    </div>

                    <!-- Text #3 -->
                    <button class="accordion">
                        Aenean rhoncus diam eleifend, pulvinar feugiat feugiat dolor?
                    </button>
                    <div class="panel">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua.
                            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
                        </p>
                    </div>

                </div>    <!--  End Accordion -->
            </div>

            <form action="#0" class="col-md-4 animated fadeInRight">

                <div>
                    <input type="text" id="first_name" name="first_name" required placeholder=" "/>
                    <label for="first_name">First Name</label>
                </div>

                <div>
                    <input type="email" id="email" name="email" required placeholder=" "/>
                    <label for="email">Email Address</label>
                    <div class="requirements">
                        Must be a valid email address.
                    </div>
                </div>

                <div id="last_name" name="last_name" required placeholder=" ">
                    <textarea rows="5" cols="57"> </textarea>
                    <label for="last_name">
                        <center>Message</center>
                    </label>
                </div>
                <input type="submit" value="Send Message"/>

            </form>
        </div>
    </tiles:putAttribute>
    <tiles:putAttribute name="scripts">
        <script>
            $(document).ready(function(){
                var acc = document.getElementsByClassName("accordion");
                var i;

                for (i = 0; i < acc.length; i++) {
                    acc[i].onclick = function() {
                        this.classList.toggle("active");
                        var panel = this.nextElementSibling;
                        if (panel.style.maxHeight){
                            panel.style.maxHeight = null;
                        } else {
                            panel.style.maxHeight = panel.scrollHeight + "px";
                        }
                    }
                }
            });
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>