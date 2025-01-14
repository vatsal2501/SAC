$().ready(function() {
	$("#clientvalidate").validate({
		rules : {
			clientName : {
				required : true,
			},
			
			clientAddress : { 
				required : true
			},

			pinCode : {
				required : true,
				number : true,
			},
			clientMobileNumber : {
				required : true,
				number : true,
			},
			clientGSTNumber : {
				required : true,
				minlength : 0,
				maxlength : 12,
			},
		},
		messages : {
			clientName : {
				required : "Please Enter MillName",
			},
			
			clientAddress : { 
				required :"Please Enter Address",
			},
			
			pinCode : {
				required : "Please enter the pincode",
				number : "Just enter number",
			},
			
			clientMobileNumber : {
				required : "Please enter the width",
				number : "Just enter number",
			},
			
			clientGSTNumber : {
				required : "Please enter the GST number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
		}
	});
})