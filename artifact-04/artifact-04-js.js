
function validateForm(){
  var errormessages = "";
  var validFirstname = false;
  var firstname = document.getElementById("FirstName").value;
  if (firstname === "null" || firstname === "" || firstname.length > 20 || !/^[A-Za-z\s]+$/.test(firstname)){
    errormessages += "The first name is required and must be less than 20 characters, ";

  }else{
     validFirstname = true;
  }
  
  var validLastname = false;
  var lastname = document.getElementById("LastName").value;
  if (lastname === "null" || lastname === "" || lastname.length > 50 || !/^[A-Za-z\s]+$/.test(lastname)){
    errormessages += "The last name is required and must be less than 50 characters, ";
  }else{
    validLastname = true;
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

  var validPhone = false
  var phone = document.getElementById("phone").value;
  if (phone === "null"|| phone === ""|| phone.length > 15|| isNaN(phone) === true){
  errormessages += "The phone number is required, must be all numbers and less than 15 characters, ";
  }else{
    validPhone = true;
  }

  var validUsername = false
  var username = document.getElementById("username").value;
  if (username === "null"|| username === ""|| username.length > 12){
  errormessages += "The username is required and must be less than 12 characters, ";
  }else{
    validUsername = true;
  }
  
  var validPassword = false
  var password = document.getElementById("password").value;
  if (password === "null"|| password === ""|| password.length > 7){
  errormessages += "The password is required and must be less than 7 characters, ";
  }else{
    validPassword = true;
  }

  var validAddress = false
  var address = document.getElementById("address").value;
  if (address === "null"|| address === ""){
  errormessages += "The address is required, ";
  }else{
    validAddress = true;
  }

  var validCity = false;
  var city = document.getElementById("city").value;
  if (city === "null"|| city === ""){
  errormessages += "The city is required, ";
  }else{
    validCity = true;
  }

  var country = document.getElementById("country").value;
  var validZipcode = false;
  var zipcode = document.getElementById("zipcode").value;
  if (country === "USA"){
    if(zipcode === "null" || zipcode === "" || zipcode.length > 5){
  errormessages += "The zipcode is required if in the USA, and must be less that 5 characters ";
    }else{
      validZipcode = true;
    }
  }else{
    validZipcode = true;
  }
  console.log(errormessages);  
  document.getElementById("errorMessages").innerHTML = errormessages;
  if(validFirstname === false || validLastname === false || validEmail === false || validPhone === false || validUsername === false || validPassword === false || validAddress === false || validCity === false || validZipcode === false){
    return (false);
  }
}
