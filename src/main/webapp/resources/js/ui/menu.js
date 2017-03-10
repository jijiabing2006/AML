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
	// alert("pagename===" + pagename);
//	 alert("frametext===" + frametext);
	if (pagename == '')
		return;
	var userAgent = navigator.userAgent, rMsie = /(msie\s|trident.*rv:)([\w.]+)/, rFirefox = /(firefox)\/([\w.]+)/, rOpera = /(opera).+version\/([\w.]+)/, rChrome = /(chrome)\/([\w.]+)/, rSafari = /version\/([\w.]+).*(safari)/;
	var browser;
	var version;
	var ua = userAgent.toLowerCase();
	function uaMatch(ua) {
		var match = rMsie.exec(ua);
		if (match != null) {
			return {
				browser : "IE",
				version : match[2] || "0"
			};
		}
		var match = rFirefox.exec(ua);
		if (match != null) {
			return {
				browser : match[1] || "",
				version : match[2] || "0"
			};
		}
		var match = rOpera.exec(ua);
		if (match != null) {
			return {
				browser : match[1] || "",
				version : match[2] || "0"
			};
		}
		var match = rChrome.exec(ua);
		if (match != null) {
			return {
				browser : match[1] || "",
				version : match[2] || "0"
			};
		}
		var match = rSafari.exec(ua);
		if (match != null) {
			return {
				browser : match[2] || "",
				version : match[1] || "0"
			};
		}
		if (match != null) {
			return {
				browser : "",
				version : "0"
			};
		}
	}
	var browserMatch = uaMatch(userAgent.toLowerCase());
	if (browserMatch.browser) {
		browser = browserMatch.browser;
		version = browserMatch.version;
	}
	var isExists = false;
	// if (document.all) {// ie 8,9(10没测试)
	if ((browser.indexOf("IE") > -1 && (version == "7.0" || version == "8.0" || version == "9.0"))) {// ie
																										// 8,9(10没测试)
		var frameset = window.parent.document.getElementById("frameset02");
		// alert("IE===" + frameset);
		for ( var i = 1; i < frameset.childNodes.length; i++) {
			var f = frameset.childNodes[i];
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
					window.parent.framesetcols = window.parent.framesetcols
							+ ",0";
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
	} else {// IE11,Chrome,ff
		if (browser.indexOf("IE") > -1 || browser.indexOf("chrome") > -1
				|| browser.indexOf("firefox") > -1) {
			var frameset = window.parent.document.getElementById("frameset02");
			for ( var i = 1; i < frameset.childNodes.length; i++) {
				var f = frameset.childNodes[i];

				if (typeof (f.src) != "undefined") {
					if (f.nodeType == 1 || f.nodeType == 3) {
						if (f.src.indexOf('portal.jsf') == -1) {
							if (f.src.indexOf(pagename) >= 0) {
								isExists = true;
								break;
							}
						}
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
					if (typeof (f.src) != "undefined") {
						if (f.src.indexOf('portal.jsf') == -1) {
							if (f.src.indexOf(pagename) >= 0) {
								window.parent.framesetcols = window.parent.framesetcols
										+ ",*";
								j = i;
							} else
								window.parent.framesetcols = window.parent.framesetcols
										+ ",0";
						} else
							window.parent.framesetcols = window.parent.framesetcols
									+ ",0";
					}
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
					window.parent.framesetcols = window.parent.framesetcols
							+ ",0";
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
				var j = 1;
				if (window.parent.hidemenu == 0)
					window.parent.framesetcols = "210";
				else
					window.parent.framesetcols = "0";
				for ( var i = 3; i < frameset.childNodes.length; i++) {
					var f = frameset.childNodes[i];
					if (typeof (f.src) != "undefined") {
						if (f.src.indexOf('portal.jsf') == -1) {
							if (f.src.indexOf(pagename) >= 0) {
								window.parent.framesetcols = window.parent.framesetcols
										+ ",*";
								j = i;
							} else
								window.parent.framesetcols = window.parent.framesetcols
										+ ",0";
						} else
							window.parent.framesetcols = window.parent.framesetcols
									+ ",0";
					}
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
				self.parent.frameHeader.document.getElementById("loading").style.cssText = 'border:0px;width:24px;';

			}
		} else {
			var frameset = window.parent.document.getElementById("frameset02");
			for ( var i = 1; i < frameset.childNodes.length; i++) {
				var f = frameset.childNodes[i];

				if (typeof (f.src) != "undefined") {
					if (f.nodeType == 1 || f.nodeType == 3) {
						if (f.src.indexOf('portal.jsf') == -1) {
							if (f.src.indexOf(pagename) >= 0) {
								isExists = true;
								break;
							}
						}
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
					if (typeof (f.src) != "undefined") {
						if (f.src.indexOf('portal.jsf') == -1) {
							if (f.src.indexOf(pagename) >= 0) {
								window.parent.framesetcols = window.parent.framesetcols
										+ ",*";
								j = i;
							} else
								window.parent.framesetcols = window.parent.framesetcols
										+ ",0";
						} else
							window.parent.framesetcols = window.parent.framesetcols
									+ ",0";
					}
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
					window.parent.framesetcols = window.parent.framesetcols
							+ ",0";
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
				var j = 1;
				if (window.parent.hidemenu == 0)
					window.parent.framesetcols = "210";
				else
					window.parent.framesetcols = "0";
				for ( var i = 3; i < frameset.childNodes.length; i++) {
					var f = frameset.childNodes[i];
					if (typeof (f.src) != "undefined") {
						if (f.src.indexOf('portal.jsf') == -1) {
							if (f.src.indexOf(pagename) >= 0) {
								window.parent.framesetcols = window.parent.framesetcols
										+ ",*";
								j = i;
							} else
								window.parent.framesetcols = window.parent.framesetcols
										+ ",0";
						} else
							window.parent.framesetcols = window.parent.framesetcols
									+ ",0";
					}
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
				self.parent.frameHeader.document.getElementById("loading").style.cssText = 'border:0px;width:24px;';
			}
		}

	}

}
