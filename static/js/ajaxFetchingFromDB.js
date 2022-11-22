function showStudent(str) {
     if (str == "") {
    	    document.getElementById("studentInfo").innerHTML = "No student selected ";
    	    return;
     }
     fetch('students?q=' + str, {method :'get'}).
     then(res => res.text()).
     then(data => {
           document.getElementById("studentInfo").innerHTML = data;

      }).
     catch(err => {
       console.log(err);
     });
}
