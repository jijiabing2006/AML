	var wincount = 1;
	var tabIndex = 1;
	var hidemenu = 0;
	var framesetcols = "210,*";
	function frameControl() {
		
		if (window.parent.hidemenu == 0)
			window.parent.framesetcols = "210";
		else
			window.parent.framesetcols = "0";
		var frameset = window.parent.document.getElementById("frameset02");
		for ( var i = 1; i < frameset.childNodes.length; i++) {
			var frame = frameset.childNodes[i];
			frame.name == 'tab' + tabIndex ? window.parent.framesetcols = window.parent.framesetcols
					+ ",*"
					: window.parent.framesetcols = window.parent.framesetcols
							+ ",0";
		}
		window.parent.document.all.frameset02.cols = window.parent.framesetcols;
	}