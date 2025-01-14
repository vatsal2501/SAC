function addfunc(){
	var table = document.getElementById("plyDetailsTable");
	
	table.innerHTML = "";
	var selectply = document.getElementById("plySelect");
	/*alert(selectply.value);*/
	
	var rh=table.insertRow(-1);
	var ch0 = rh.insertCell(0);
	var ch1 = rh.insertCell(1);
	var ch2 = rh.insertCell(2);
	var ch3 = rh.insertCell(3);	
	var ch4 = rh.insertCell(4);
	var ch5 = rh.insertCell(5);

	ch0.innerHTML="Paper No.";
	ch1.innerHTML="Paper GSM";
	ch2.innerHTML="Paper BF";
	ch3.innerHTML="Flute GSM";
	ch4.innerHTML="Flute BF";
	ch5.innerHTML="";
	var rowCount = table.rows.length;
	
	table.style.display="";
	for(let j=0 ; j< selectply.value-1 ; j++){
	
	var r=table.insertRow(-1);
	
	var c0 = r.insertCell(0);
	var c1 = r.insertCell(1);
	var c2 = r.insertCell(2);
	var c3 = r.insertCell(3);
	var c4 = r.insertCell(4);
	var c5 = r.insertCell(5);
	
	c0.innerHTML=j+1;
	c1.innerHTML='<input type="text" id="paperGsm['+j+']" class="form-control" name="plyDetailsList['+j+'].paperGsm">';
	c2.innerHTML='<input type="text" id="paperBf['+j+']" class="form-control" name="plyDetailsList['+j+'].paperBf">';
	c3.innerHTML='<input type="text" id="fluteGsm['+j+']" class="form-control" name="plyDetailsList['+j+'].fluteGsm">';
	c4.innerHTML='<input type="text" id="fluteBf['+j+']" class="form-control" name="plyDetailsList['+j+'].fluteBf">';
	c5.innerHTML='<button type="button" onclick="clearfun('+j+')" class="btn btn-outline-secondary">Reset</button>';
	} 
}

function clearfun(j) {
	document.getElementById("paperGsm["+j+"]").value="";
	document.getElementById("paperBf["+j+"]").value="";
	document.getElementById("fluteGsm["+j+"]").value="";
	document.getElementById("fluteBf["+j+"]").value="";
}

$().ready(function() {
	$("#clientreqvalidate").validate({
		rules : {
		
			clientItems : "required",
			width : {
				required : true,
				number : true,
			},
			length : {
				required : true,
				number : true,
			},
			height : {
				required : true,
				number : true,
			},
			millGSTNumber : {
				required : true,
				minlength : 0,
				maxlength : 12,
			},
		},
		messages : {
		
			clientItems : "Please Enter Items",
			height : {
				required : "Please enter the height",
				number : "Just enter number",
			},
			width : {
				required : "Please enter the width",
				number : "Just enter number",
			},
			length : {
				required : "Please enter the length",
				number : "Just enter number",
			},
			
			millGSTNumber : {
				required : "Please enter the GST number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
		}
	});
})


function getPlyDetailsByClientReqId(clientReqId) {

			//	var clientReqId = document.getElementById("clientReqId");

			var htp = new XMLHttpRequest();

			htp.onreadystatechange = function() {

				if (htp.readyState == 4) {

					var jsn = JSON.parse(htp.responseText);

					var plyDataTable = "";

					if (jsn.length > 0) {
						
						for(let i=0 ; i < jsn.length ; i++){
							var data = jsn[i];
							plyDataTable = plyDataTable +'<tr>' + 
							 '<td>' + i + '</td>' +
							 '<td>' + data.paperGsm + '</td>' +
							 '<td>' + data.paperBf + '</td>' +
							 '<td>' + data.fluteGsm + '</td>' +
							 '<td>' + data.fluteGsm + '</td>' +
							 '</tr>';
						}
						
						$("#tbody").html(plyDataTable);
						$('#dataTable').DataTable().draw();
						
					}
				}
			}
			
			

			htp.open("get", "getPlyDetailsByClientReqId?clientReqId="+clientReqId, true);
			htp.send();

		}