//For a table of 4 subtables, will keep them hidden until clicked
function show1(nr) {
    document.getElementById("table1").style.display = "none";
    document.getElementById("table2").style.display = "none";
    document.getElementById("table3").style.display = "none";
    document.getElementById("table4").style.display = "none";
    document.getElementById("table" + nr).style.display = "block";
}
//For a table of 3 subtables, will keep them hidden until clicked
function show2(nr) {
    document.getElementById("table1").style.display = "none";
    document.getElementById("table2").style.display = "none";
    document.getElementById("table" + nr).style.display = "block";
}
//Shows total number of bands or rows in main table.
function BandCount() {
    var x = document.getElementById("myTable").rows.length - 1;
    document.getElementById("demo").innerHTML = "Number of bands currently: " + x + " but this number will be higher soon";
}
function validateForm() {
    //Checking to see if a value is null
    let x = document.forms["myForm"]["Genre"].value;
    if (x == "") {
        alert("Genre must be filled out");
        return false;
    }
    //Checking to see if a value is null
    let y = document.forms["myForm"]["BName"].value;
    if (y == "") {
        alert("Band name must be filled out");
        return false;
    }
    var phoneNumber = document.getElementById('phone-number').value;
    //I found this regex online to check if its an actual phone number
    var phoneRGEX = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;

    var phoneResult = phoneRGEX.test(phoneNumber);
    if (phoneResult == false) {
        alert('Please enter a valid phone number');
        return false;
    }

    return true;
}

var click = document.getElementById('clickme');
click.addEventListener('click', showArt);

function showArt() {
  var tablewrap = document.getElementById('displaytable');
  tablewrap.classList.toggle('hidden')
};