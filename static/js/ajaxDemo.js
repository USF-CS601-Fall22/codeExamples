function updatePage(){	
    var xhttp = new XMLHttpRequest();
   	xhttp.onreadystatechange = function() {
     	if (xhttp.readyState == 4 && xhttp.status == 200) {
     	    var jsonObj = JSON.parse(xhttp.responseText);
 	        var message = jsonObj.message;
 	        // should be "cleaning" the message we get from the server!
 	        document.getElementById("messageFromServer").innerHTML = jsonObj.message;
     	}
 	}

 	xhttp.open("GET", "counter", true);
 	xhttp.send();

}
setInterval(updatePage, 1000);

