/**
 * Created by Ihor on 5/21/2017.
 */

Date.prototype.toDefaultDateFormat = function(){
    return this.getDate() + "/" + this.getMonth() + "/" + this.getFullYear();
}

var imageData;
function getFileBytes(fileControlId){
    var fileList = new Array();
    fileList = document.getElementById(fileControlId).files;

    var reader = new FileReader();
    reader.onload = function() {

        var arrayBuffer = this.result;

        imageData = _arrayBufferToBase64(arrayBuffer);
    }
    reader.readAsArrayBuffer(fileList[0]);

    return imageData;
}

function _arrayBufferToBase64( buffer ) {
    var binary = '';
    var bytes = new Uint8Array( buffer );
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode( bytes[ i ] );
    }
    return window.btoa( binary );
}