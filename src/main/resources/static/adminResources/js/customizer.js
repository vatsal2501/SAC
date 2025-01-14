$(document).ready(function() {
    $('#example').DataTable(
        
         {     

      "aLengthMenu": [[ 10, 25, -1], [ 10, 25, "All"]],
        "iDisplayLength": 10
       } 
        );
} );


function checkAll(bx) {
	
  var cbs = document.getElementsByTagName('input');
  for(var i=0; i < cbs.length; i++) {
    if(cbs[i].type == 'checkbox') {
      cbs[i].checked = bx.checked;
    }
  }
}


