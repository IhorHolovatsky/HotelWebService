$(document).ready(function () {
    $("body").append("<div id='overlay'></div>" +
                     "<div id='waitSpinner'></div>");


    $('#waitSpinner').hide();
    $('#overlay').hide();

    var opts = {
        lines: 13, // The number of lines to draw
        length: 3, // The length of each line
        width: 10, // The line thickness
        radius: 30, // The radius of the inner circle
        corners: 1, // Corner roundness (0..1)
        rotate: 0, // The rotation offset
        direction: 1, // 1: clockwise, -1: counterclockwise
        color: '#333333', // #rgb or #rrggbb or array of colors
        speed: 1, // Rounds per second
        trail: 60, // Afterglow percentage
        shadow: false, // Whether to render a shadow
        hwaccel: false, // Whether to use hardware acceleration
        className: 'spinner', // The CSS class to assign to the spinner
        zIndex: 2e9, // The z-index (defaults to 2000000000)
        top: '50%', // Top position relative to parent
        left: '50%' // Left position relative to parent
    };

    var spinner = new Spinner(opts);
    spinner.spin();
    $('#waitSpinner').html(spinner.el);
});

$(document).on({
    ajaxStart: function () {
        startSpinner();
    },
    ajaxSuccess: function () {
        if ($.active < 2) {
            stopSpinner();
        }
    },
    ajaxError: function () {
        if ($.active < 2) {
            stopSpinner();
        }
    }
});

// when an ajax request starts, show spinner
function startSpinner() {
    $('#waitSpinner').show();
    $('#overlay').show();
}

// when an ajax request complets, hide spinner
function stopSpinner() {
    $('#waitSpinner').hide();
    $('#overlay').hide();
}
