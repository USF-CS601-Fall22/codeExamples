function validateName(name) {
    var numval = name.value;
   // should start with an upper case letter
    if ( numval.charAt(0) != numval.charAt(0).toUpperCase()) {
  	    alert ('First letter must be uppercase!');
    }
    else if (numval.length > 5) {
    	   alert('Name too long. Can not be more than 5 characters');
    }
}
