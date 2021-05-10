let dateObj = new Date();
let month = dateObj.getUTCMonth() + 1; //months from 1-12
let day = dateObj.getUTCDate();
let year = dateObj.getUTCFullYear();

newdate = year + "-" + (month.length > 1 ? month : '0' + month) + "-" + day;
document.getElementById("fromDate").setAttribute("value", newdate);
document.getElementById("toDate").setAttribute("value", newdate);