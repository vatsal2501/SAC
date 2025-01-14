$().ready(function() {
	$("#toppapervalidate").validate({
		rules : {
			topPaperBundleNumber: {
				required : true,
			},
			topPaperPiecesOld : {
				required : true,
			},
			topPaperGSMOld : {
				required : true,
			},
			topPaperBFOld : {
				required : true,
			},
			topPaperDecalOld : {
				required : true,
			},
		},
		messages : {
			topPaperBundleNumber : {
				required : "Please Enter a Top Paper Bundle Number",
			},
			topPaperPiecesOld : {
				required : "Please Enter a Top Paper Pieces",
			},
			topPaperGSMOld : {
				required : "Please Enter a Top Paper GSM",
			},
			topPaperBFOld : {
				required : "Please Enter a Top Paper BF",
			},
			topPaperDecalOld : {
				required : "Please Enter a Top Paper Decal",
			},

		}
	});

})