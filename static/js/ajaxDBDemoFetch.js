function showStudent(str){
    alert("Here");
    if (str == "") {
	    document.getElementById("studentInfo").innerHTML = "No student selected ";
	    return;
    }
    fetch('students?q=' + str, {method :'get'}).
    then(res => res.json()).
    then(data => {
        document.getElementById("studentInfo").innerHTML = data.responseText;

     }).
    catch(err => {
      console.log(err);
    });
};
