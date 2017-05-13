function outputValidationMessage(fieldId, messagetext) {
    var actualContent = $("#validationResult_" + fieldId).html();
    var contentToShow = messagetext;

    if (actualContent) {
        contentToShow += '<br/>' + actualContent;
    } else {
        $("#validationResult_" + fieldId).addClass("help-block");
    }

    $("#validationResult_" + fieldId).html(contentToShow);
    $("#validationResult_" + fieldId).show();
}

function hideValidationMessage(fieldId) {
    $("#validationResult_" + fieldId).removeClass("help-block");
    $("#validationResult_" + fieldId).html("");
    $("#validationResult_" + fieldId).hide();
}

function clearValidationMessages() {
    $(".field-validation-valid").removeClass("help-block");
    $(".field-validation-valid").html("");
    $(".field-validation-valid").hide();
}
//Image upload
function fileInput_loadImageThumbnail(fileInputValue, previewImgId, $dependedElements) {
    if (!fileInputValue && !fileInputValue.files && !fileInputValue.files[0]) {
        console.error("Invalid argument value!");
        return;
    }

    var isIE = (navigator.appName == "Microsoft Internet Explorer");
    var path = fileInputValue.value;
    var ext = path.substring(path.lastIndexOf(".") + 1).toLowerCase();

    if (jQuery.inArray(ext, ["gif", "png", "jpg", "jpeg"]) !== -1 || /^image/.test(fileInputValue.files[0].type)) {
        if (isIE) {
            $("#" + previewImgId).attr("src", path);
            if ($dependedElements)
            {
                $dependedElements.each(function (index, element) {
                    $(element).attr('src', path);
                });
            }
        } else {
            if (fileInputValue.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#" + previewImgId).attr("src", e.target.result);
                    if ($dependedElements)
                    {
                        $dependedElements.each(function (index, element) {
                            $(element).attr('src', e.target.result);
                        });
                    }
                };
                reader.readAsDataURL(fileInputValue.files[0]);
                return true;
            }
        }
        return true;
    } else {
        $("#" + previewImgId).attr("src", '');
        return false;
    }
}

// non-image file upload
function fileInput_loadFileContent(fileInputValue, storageId) {
    if (!fileInputValue && !fileInputValue.files && !fileInputValue.files[0]) {
        console.error("Invalid argument value!");
        return;
    }

    if (fileInputValue.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $("#" + storageId).attr("value", e.target.result);
        };
        reader.readAsDataURL(fileInputValue.files[0]);
        
    }

    return true;
    
}


// format Error Message
function formatErrorMessage(jqXhr, exception) {

    var message = "";
    if (jqXhr.status === 0) {
        message = "Not connect.\n Verify Network.";
    } else if (jqXhr.status == 404) {
        message = "Requested page not found.";
    } else if (jqXhr.status == 500) {
        message = "Internal Server Error.";
    } else if (exception === "parsererror") {
        message = "Requested JSON parse failed.";
    } else if (exception === "timeout") {
        message = "Time out error.";
    } else if (exception === "abort") {
        message = "Ajax request aborted.";
    } else {
        message = "Uncaught Error.\n" + jqXhr.responseText;
    }
    return message;
}

/// Errors the message alert.
function errorMessageAlert(jqXhr, exception) {

    var msg = formatErrorMessage(jqXhr, exception);

    alert(msg);
}

/// Errors the message modal.
function errorMessageModal(jqXhr, exception) {

    var msg = formatErrorMessage(jqXhr, exception);

    alertModal("Something went wrong...", msg);
}


// Display error message to the user in a modal
function alertModal(title, body) {
    $("#alert-modal-title").html(title);
    $("#alert-modal-body").html(body);
    $("#alert-modal").modal("show");
}

// Scrolls to anchor.
function scrollToAnchor(id) {
    
    var tag = $("#" + id );
     
    if (tag.length) {
  
        $('html, body').animate({
            scrollTop: tag.offset().top - 50
        }, 1000);

    }
}

// escape Html tags to avoid "Potentially dangerous request" error if some Html tag is entered
function escapeHtmlTags(formId) {
    var input = $("#" + formId).find("input[type=text], textarea");
    input.each(function (index, field) {
        var value = $(field).val();
        value = escapeHtmlTagsFromText(value);
        $(field).val(value);
    });
}

function escapeHtmlTagsFromText(text) {
    text = text.replace(/</g, "&lt;");
    text = text.replace(/>/g, "&gt;");
    return text;
}

// unsecape Html tags to display values as entered in case of error
function unescapeHtmlTags(formId) {
    var input = $("#" + formId).find("input[type=text], textarea");
    input.each(function (index, field) {
        var value = $(field).val();
        value = unescapeHtmlTagsFromText(value);
        $(field).val(value);
    });
}

function unescapeHtmlTagsFromText(text) {
    text = text.replace(/&lt;/g, "<");
    text = text.replace(/&gt;/g, ">");
    return text;
}

function startTimer(durationSeconds, targetId, callback, callbackParams) {
    var timer = durationSeconds, seconds;

    var refreshIntervalId = setInterval(function () {

        seconds = parseInt(timer % 60, 10);
        //uncomment if you have minutes
        //seconds = seconds < 10 ? "0" + seconds : seconds;

        $('#' + targetId).text(seconds);

        if (--timer < 0) {
            if (callback && typeof callback === "function") {
                callback(callbackParams);
            }

            clearInterval(refreshIntervalId);
        }
    }, 1000);

    return refreshIntervalId;
}

function generateRandomGuid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
          .toString(16)
          .substring(1);
    }
    return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
      s4() + '-' + s4() + s4() + s4();
}