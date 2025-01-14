$().ready(function() {
	$("#reelvalidate").validate({
		rules : {
			reelNumberOld : {
				required : true,
			},
			reelWeightOld : {
				required : true,
			},
			reelGSMOld : {
				required : true,
			},
			reelBFOld : {
				required : true,
			},
			reelDecalOld : {
				required : true,
			},
		},
		messages : {
			reelNumberOld : {
				required : "Please Enter a Reel Number",
			},
			reelWeightOld : {
				required : "Please Enter a Weight",
			},
			reelGSMOld : {
				required : "Please Enter a GSM",
			},
			reelBFOld : {
				required : "Please Enter a BF",
			},
			reelDecalOld : {
				required : "Please Enter a Decal",
			},

		}
	});

})