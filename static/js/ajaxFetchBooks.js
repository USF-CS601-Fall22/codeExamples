 function fetchBooks() {
  var xhttp = new XMLHttpRequest();
    	xhttp.onreadystatechange = function() {
      	if (xhttp.readyState == 4 && xhttp.status == 200) {
      	    var jsonObj = JSON.parse(xhttp.responseText);
  	        var jsonArr = jsonObj.books;
  	        let i = 0
  	        let str = '';
            while (i < jsonArr.length) {
                str = str + jsonArr[i].title + ' by ' + jsonArr[i].author + '<br>';
                i++;
            }
            document.getElementById("books").innerHTML = str;
      	}
  	}
  	xhttp.open("GET", "/books", true);
  	xhttp.send();

}