/*function getItemsByClient() {

	var clientname = document.getElementById("clientname");
	var clientItems = document.getElementById("clientItems");

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText);

			if (jsn.length > 0) {

				clientItems.innerHTML = "";

				var opn = document.createElement("option");

				opn.text = "Select";
				clientItems.options.add(opn);

				for (var index = 0; index < jsn.length; index++) {

					var opn = document.createElement("option");

					opn.value = jsn[index].clientreqId
					opn.text = jsn[index].clientItems

					clientItems.options.add(opn);

				}

			}

		}
	}

	htp.open("get", "getItemsByClient?clientId=" + clientname.value, true);
	htp.send();
}*/

function getverifyOrderDetailsById() {

	var orderId = document.getElementById("orderId");

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText);

			if (jsn.length > 0) {

				var data = jsn[0];

				$('#orderQuantity').val(data.orderQuantity);
				$('#twoPly').val(data.twoPly);
				$('#clientName').val(data.clientVO.clientName);
				$('#clientItems').val(data.clientReqVO.clientItems);
				$('#height').val(data.clientReqVO.height);
				$('#width').val(data.clientReqVO.width);
				$('#length').val(data.clientReqVO.length);
				$('#topPaper').val(data.clientReqVO.papertypeVO.paperType);	
				$('#printing1').val(data.clientReqVO.printing);
				$('#decal').val(data.clientReqVO.decal);
				$('#cutting').val(data.clientReqVO.cutting);
			}
		}
	}

	htp.open("get", "getverifyOrderDetailsById?orderId="
			+ orderId.value, true);
	htp.send();

}




function getverifyOrderDetailsByOrderId() {

	var orderId = document.getElementById("orderId");

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState == 4) {

			var jsn = JSON.parse(htp.responseText);

			if (jsn.length > 0) {

				var data = jsn[0];

				$('#clientName').val(data.clientName);
			}
		}
	}

	htp.open("get", "getverifyOrderDetailsByOrderId?orderId="
			+ orderId.value, true);
	htp.send();

}


/*$().ready(function() {
	$("#ordervalidate").validate({
		rules : {
		
			orderQuantity : {
				required : true,
				minlength : 0,
				maxlength : 12,
			},
		},
		messages : {
			
			orderQuantity : {
				required : "Please enter the Order number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
		}
			
		
	});
})
*/