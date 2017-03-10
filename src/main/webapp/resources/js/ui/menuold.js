//
// 给字符串对象添加一个startsWith()方法
//
String.prototype.startsWith = function(substring) {
	var reg = new RegExp("^" + substring);
	return reg.test(this);
};

//
// 给字符串对象添加一个endsWith()方法
//
String.prototype.endsWith = function(substring) {
	var reg = new RegExp(substring + "$");
	return reg.test(this);
};

//
// 删除所有空白字符
//
String.prototype.deleteWhiteSpaces = function() {
	var extraSpace = /[\s\n\r]+/g;

	return this.replace(extraSpace, "");
};

function addFrame(pagename, frametext) {
//	alert("pagename===" + pagename);
//	alert("frametext===" + frametext);
	if (pagename == '')
		return;
	var isExists = false;
alert("document.all"+document.all)
	if (document.all) {// ie
		var frameset = window.parent.document.getElementById("frameset02");
//		alert("IE===" + frameset);
		for ( var i = 1; i < frameset.childNodes.length; i++) {
			var f = frameset.childNodes[i];
//			alert("frameset.childNodes====" + frameset.childNodes[i]);
//			alert("f.src====" + f.src);
//			alert("f.src.toString().endsWith===="
//					+ f.src.toString().endsWith('portal.jsf'));

			if (!f.src.endsWith('portal.jsf')) {
				if (f.tag == pagename)
					isExists = true;
			}
		}

		if (isExists) {
			var j = 1;
			if (window.parent.hidemenu == 0)
				window.parent.framesetcols = "210";
			else
				window.parent.framesetcols = "0";
			for ( var i = 1; i < frameset.childNodes.length; i++) {
				var f = frameset.childNodes[i];
				if (!f.src.endsWith('portal.jsf')) {
					if (f.tag == pagename) {
						window.parent.framesetcols = window.parent.framesetcols
								+ ",*";
						j = i;
					} else
						window.parent.framesetcols = window.parent.framesetcols
								+ ",0";
				} else
					window.parent.framesetcols = window.parent.framesetcols + ",0";
			}
			frameset.cols = window.parent.framesetcols;
			var header = parent.frames["frameHeader"];
			var ulList = header.document.getElementById('tabcontainer').childNodes;
			for ( var i = 2; i < ulList.length; i++)
				ulList[i].className = "";
			for ( var i = 2; i < ulList.length; i++) {
				if (j == i - 1)
					ulList[i].className = "ui-tabs-selected";
			}
		} else {
			var wincount = window.parent.wincount + 1;
			if (window.parent.hidemenu == 0)
				window.parent.framesetcols = "210";
			else
				window.parent.framesetcols = "0";
			for ( var i = 1; i < frameset.childNodes.length; i++) {
				window.parent.framesetcols = window.parent.framesetcols + ",0";
			}
			window.parent.framesetcols = window.parent.framesetcols + ",*";
			frameset.cols = window.parent.framesetcols;
			var frame = parent.document.createElement("frame");
			frame.id = "tab" + wincount;
			frame.name = "tab" + wincount;
			frame.src = pagename;
			frame.tag = pagename;
			frameset.appendChild(frame);
			window.parent.wincount = wincount;
			window.parent.tabIndex = wincount;
			self.parent.frames[0].addTab(frametext);
			self.parent.frameHeader.document.getElementById("loading").style.cssText = 'border:0px;width:24px;';
		}
	} else {// ff,注意frame要把id加上
		var frameset = window.parent.window.document
				.getElementById("frameset02");
		alert("FF frameset.childNodes==11111==" + frameset.childNodes.length);
		for ( var j = 3; j < frameset.childNodes.length; j++) {
			var f = frameset.childNodes[j];
			if (f.nodeType == 1) {
				alert("FF f.src====" + f.src);
				if (!f.src.endsWith('portal.jsf')) {
					if (f.tag == pagename)
						isExists = true;
				}
			}
		}

		if (isExists) {
			var j = 1;
			if (window.parent.hidemenu == 0)
				window.parent.framesetcols = "210";
			else
				window.parent.framesetcols = "0";
			for ( var i = 3; i < frameset.childNodes.length; i++) {
				var f = frameset.childNodes[i];
				if (!f.src.endsWith('portal.jsf')) {
					if (f.tag == pagename) {
						window.parent.framesetcols = window.parent.framesetcols
								+ ",*";
						j = i;
					} else
						window.parent.framesetcols = window.parent.framesetcols
								+ ",0";
				} else
					window.parent.framesetcols = window.parent.framesetcols + ",0";
			}
			frameset.cols = window.parent.framesetcols;
			var header = parent.frames["frameHeader"];
			var ulList = header.document.getElementById('tabcontainer').childNodes;
			for ( var i = 2; i < ulList.length; i++)
				ulList[i].className = "";
			for ( var i = 2; i < ulList.length; i++) {
				if (j == i - 1)
					ulList[i].className = "ui-tabs-selected";
			}
		} else {
			var wincount = window.parent.wincount + 1;
			  alert("wincount===" + wincount);
			if (window.parent.hidemenu == 0)
				window.parent.framesetcols = "210";
			else
				window.parent.framesetcols = "0";
			for ( var i = 3; i < frameset.childNodes.length; i++) {
				if (f.nodeType == 1) {
					window.parent.framesetcols = window.parent.framesetcols + ",0";
				}
			}
			window.parent.framesetcols = window.parent.framesetcols + ",*";
			frameset.cols = window.parent.framesetcols;
			var frame = parent.document.createElement("frame");
			frame.id = "tab" + wincount;
//			frame.name = "tab" + wincount;
			frame.src = pagename;
			frame.tag = pagename;
			alert("FF frame id=="+frame.id);
//			alert("FF frame name=="+frame.name);
			alert("FF frame src=="+frame.src);
			alert("FF frame tag=="+frame.tag);
			frameset.appendChild(frame);
		
			window.parent.wincount = wincount;
			window.parent.tabIndex = wincount;
			alert("FF self.parent.frames[0]===" + self.parent.frames[0]);
			parent.document.frames[0].location=frametext;
			self.parent.frames[0].addTab(frametext);
			self.parent.frameHeader.document.getElementById("loading").style.cssText = 'border:0px;width:24px;';
		}
		

	}

}
