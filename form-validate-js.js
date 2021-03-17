function validateForm(){
  var errormessages = "";
  var validFirstname = false;
  var firstname = document.getElementById("FirstName").value;
  if (firstname === "null" || firstname === "" || firstname.length > 20 || !/^[A-Za-z\s]+$/.test(firstname)){
    errormessages += "The name is required and must be less than 20 characters, ";

  }else{
     validFirstname = true;
  }
  
  var validEmail = false
  var email = document.getElementById("email").value;
  var atpos = email.indexOf("@");
  var dotpos = email.lastIndexOf(".");
  if (email === "null" || email === "" ||atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length){
  errormessages += "The email is required, must have an @ symbol and a valid ending,  ";   
  }else{
    validEmail = true;
  }
  
  var validComment = false;
  var comment = document.getElementById("info").value;
  if (comment === "null"|| comment === ""){
  errormessages += "The comment is required, ";
  }else{
    validComment = true;
  }

  console.log(errormessages);  
  document.getElementById("errorMessages").innerHTML = errormessages;
  if(validFirstname === false || validEmail === false || validComment === false ){
    return (false);
  }
}