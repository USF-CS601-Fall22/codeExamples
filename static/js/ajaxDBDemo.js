function showStudent(str){

    var xhttp = new XMLHttpRequest();
    if (str == "") {
	    document.getElementById("studentInfo").innerHTML = "No student selected ";
	    return;
    }
  
    xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
        document.getElementById("studentInfo").innerHTML = this.responseText;
       }
    };
    xhttp.open("GET", "students?q=" + str, true);
    xhttp.send();
}
