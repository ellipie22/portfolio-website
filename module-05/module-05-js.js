var table = prompt("What number would you like to use?", "Enter here");
//var operator = 'multiplication';//
var i = 1;
var msg = '<h2>Multiplication Table</h2>';

/* if (operator === 'addition') {
  while (i < 11) {
    msg += i + ' + ' + table + ' = ' + (i + table) + '<br />';
    i++;
  }
} else { */
  while (i < 11) {
    msg += i + ' x ' + table + ' = ' + (i * table) + '<br />';
    i++;
  }

var el = document.getElementById('blackboard');
el.innerHTML = msg;