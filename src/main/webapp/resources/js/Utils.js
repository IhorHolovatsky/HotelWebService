/**
 * Created by Ihor on 5/21/2017.
 */

Date.prototype.toDefaultDateFormat = function(){
    return this.getDate() + "/" + this.getMonth() + "/" + this.getFullYear();
}