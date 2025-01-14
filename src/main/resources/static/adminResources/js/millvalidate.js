$().ready(function() {
	$("#millvalidate").validate({
		rules : {
			millName : {
				required : true,
			},
			millAddress : "required",
			millMobileNumber : {
				required : true,
				number : true,
				minlength : 8,
				maxlength : 10,
			},
			millGSTNumber : {
				required : true,
				minlength : 0,
				maxlength : 12,
			},
		},
		messages : {
			millName : {
				required : "Please Enter MillName",
			},
			millAddress : "Please Enter Address",
			millMobileNumber : {
				required : "Please enter the mobile number",
				number : "Just enter number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
			millGSTNumber : {
				required : "Please enter the GST number",
				minlength : "Please Enter a valid number",
				maxlength : "Please Enter a valid number",
			},
		}
	});
})