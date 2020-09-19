function validateForm() {
  var x = document.forms["Formulario"]["id"].value;
  if (x != parseInt(x)) {
    alert("Enter a valid parameter");
    return false;
  }
}