var aCity = {
	11 : "北京",
	12 : "天津",
	13 : "河北",
	14 : "山西",
	15 : "内蒙古",
	21 : "辽宁",
	22 : "吉林",
	23 : "黑龙江",
	31 : "上海",
	32 : "江苏",
	33 : "浙江",
	34 : "安徽",
	35 : "福建",
	36 : "江西",
	37 : "山东",
	41 : "河南",
	42 : "湖北",
	43 : "湖南",
	44 : "广东",
	45 : "广西",
	46 : "海南",
	50 : "重庆",
	51 : "四川",
	52 : "贵州",
	53 : "云南",
	54 : "西藏",
	61 : "陕西",
	62 : "甘肃",
	63 : "青海",
	64 : "宁夏",
	65 : "新疆",
	71 : "台湾",
	81 : "香港",
	82 : "澳门",
	91 : "国外"
};
// 特殊字符
var specialcharacter = "?,!,$,%,^,*,？,！";

var orgcodemapping = [ '0:0', '1:1', '2:2', '3:3', '4:4', '5:5', '6:6', '7:7',
		'8:8', '9:9', 'A:10', 'B:11', 'C:12', 'D:13', 'E:14', 'F:15', 'G:16',
		'H:17', 'I:18', 'J:19', 'K:20', 'L:21', 'M:22', 'N:23', 'O:24', 'P:25',
		'Q:26', 'R:27', 'S:28', 'T:29', 'U:30', 'V:31', 'W:32', 'X:33', 'Y:34',
		'Z:35' ];

var weightedfactors = [ 3, 7, 9, 10, 5, 8, 4, 2 ];
//
// 给字符串对象添加一个endsWith()方法
//
String.prototype.endsWith = function(substring) {
	var reg = new RegExp(substring + "$");
	return reg.test(this);
};
// 去前后空格
String.prototype.Trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

// 去左边空格
String.prototype.LTrim = function() {
	return this.replace(/(^\s*)/g, "");
}

// 去右边空格
String.prototype.RTrim = function() {
	return this.replace(/(\s*$)/g, "");
}
// 非空
function checkRequired(obj, alertmsg) {
	if (null != obj) {

		if (obj.value == "" || null == obj.value) {
			showAlert(alertmsg, "不能为空.");
			return false;
		}

		if (obj.value.Trim().length == 0) {
			showAlert(alertmsg, "不能为空.");
			return false;
		}

		return true;
	} else {
		return false;
	}
}
// 非空
function checkRequiredByValue(objValue, alertmsg) {
	if (objValue == "" || null == objValue) {
		showAlert(alertmsg, "不能为空.");
		return false;
	}

	if (objValue.Trim().length == 0) {
		showAlert(alertmsg, "不能为空.");
		return false;
	}
	return true;
}
// 校验特殊字符,返回true代表校验通过，否则返回错误提示信息
function checkspecialcharacter(objValue, alertmsg) {
	if (objValue == "" || objValue == null) {
		return false;
	}
	var str = specialcharacter.split(",");
	for ( var i = 0; i < objValue.length; i += 1) {
		var subCheckStr = objValue.substring(i, i + 1);
		for ( var j = 0; j < str.length; j += 1) {
			if (subCheckStr == str[j]) {
				showAlert(alertmsg, "不得出现:" + subCheckStr + " 特殊字符!");
				return false;
			}
		}
	}
	return true;
}

// 校验是否包含空格
function checkVacant(objValue, alertmsg) {

	if (objValue == "") {
		showAlert(alertmsg, "不能为空.");
		return false;
	}
	if (objValue.Trim().length == 0) {
		showAlert(alertmsg, "不能为空.");
		return false;
	}
	var reg = /\s/gi;
	if (reg.test(objValue)) {
		showAlert(alertmsg, " 不能包含空格");
		return false;
	}
	return true;
}
// 校验前后是否有空格
function checkStartOrEndVacant(objValue, alertmsg) {
	var OLength = objValue.length;
	var TLength = objValue.Trim().length;
	if (OLength != TLength) {
		showAlert(alertmsg, "前后不得有空格!");
		return false;
	} else {
		return true;
	}
}
// 校验字段是否可以使用替代符号,是返回true，否则返回false
function canUseSubstitute(fieldAndName, canusesubstitution) {
	if (canusesubstitution.indexOf(fieldAndName) > -1) {// 包含在可以使用替代符字段范围中，不需要进行后续校验
		return true;
	}
	return false;
}
// 校验字段是否是要满足条件才能使用替代符的。通过支付方式,判断字段名不在needchecktype范围时，判定为直接不可以使用
function isDonotUseSubstitute(fieldAndName, needchecktype) {
	var substitutes = needchecktype.split(",");
	for ( var i = 0; i < substitutes.length; i++) {
		if (substitutes[i].indexOf(fieldAndName[0]) > -1) {// 包含在条件范围中
			return true;
		}
	}
	showAlert(fieldAndName[1], "不得使用替代符!");
	return false;// 判定为直接不可以使用
}
// 校验字段是否可以使用替代符号,是返回空字符，否则返回错误提示信息
function checkIsUseSubstitute(fieldAndName, methodtype, needchecktype) {

	var substitutes = needchecktype.split(",");
	for ( var i = 0; i < substitutes.length; i++) {
		var nameAndtypes = substitutes[i].split("@");
		if (nameAndtypes[0] == fieldAndName[0]) {
			if (nameAndtypes[1].indexOf(methodtype.substring(0, 1)) > -1) {// A,B,C,D,E√
				// 满足相关条件时不能使用替代符
				showAlert("交易方式为“" + methodtype.substring(2, 100) + "”时, "
						+ fieldAndName[1], "不得使用替代符!");
				return false;
			}
		}
	}
	return true;
}

function getPaymethodType(tstpValue) {
	if (typeof (tstpValue) != "undefined") {
		var methodfirst = tstpValue.substring(0, 2);
		if (methodfirst == "00") {// 人民币业务
			var methodsecond = tstpValue.substring(2, 4);

			var methodthird = tstpValue.substring(4, 6);
			// A.现钞交易
			// “交易方式TSTP”第三至四位为00（第五至六位不为11、15、16、17）
			if (methodsecond == '00') {
				if (methodthird != '11' ? methodthird != '15' ? methodthird != '16' ? methodthird != '17' ? true
						: false
						: false
						: false
						: false) {
					return "A.现钞交易";
				}
			}
			// B.非现钞交易——人民币汇票
			// 类型识别：对于人民币交易，“交易方式TSTP”第三至六位为0100、0101或0102。
			var sAndT = tstpValue.substring(2, 6);
			if (sAndT == '0100' || sAndT == '0101' || sAndT == '0102') {
				return "B.非现钞交易——人民币汇票";
			}
			// C.非现钞交易——人民币本票
			// 类型识别：对于人民币交易，“交易方式TSTP”第三至六位为0103。
			if (sAndT == '0103') {
				return "C.非现钞交易——人民币本票";
			}
			// D.非现钞交易——人民币支票
			// 类型识别：对于人民币交易，“交易方式TSTP”第三至六位为0104。
			if (sAndT == '0104') {
				return "D.非现钞交易——人民币支票";
			}
			// E.非现钞交易——其他
			// 类型识别：对于人民币交易，“交易方式TSTP”第三至六位为0110、0112、0113、0114、0120、0121、0130、0131、0132、0133、0134、0135、0136、0151；
			if (sAndT == '0110' || sAndT == '0112' || sAndT == '0113'
					|| sAndT == '0114' || sAndT == '0120' || sAndT == '0121'
					|| sAndT == '0130' || sAndT == '0131' || sAndT == '0132'
					|| sAndT == '0133' || sAndT == '0134' || sAndT == '0135'
					|| sAndT == '0136' || sAndT == '0151') {
				return "E.非现钞交易——其他";
			}

			// F.境外银行卡交易
			// “交易方式TSTP”第五至六位为11、15、16、17；
			if (methodthird == '11' || methodthird == '15'
					|| methodthird == '16' || methodthird == '17') {
				return "F.境外银行卡交易";
			}

		} else if (methodfirst == "01") {// 外币业务
			var methodsecond = tstpValue.substring(2, 6);
			// A.现钞交易
			// “交易方式TSTP”第三至六位为0001、0002、0003、0004、0111。
			if (methodsecond == '0001' || methodsecond == '0002'
					|| methodsecond == '0003' || methodsecond == '0004'
					|| methodsecond == '0111') {
				return "A.现钞交易";
			}
			// E.非现钞交易——其他
			// 对于外币交易，“交易方式TSTP”第三至六位为0101、0102、0103、0104、0105、0106、0107。
			if (methodsecond == '0101' || methodsecond == '0102'
					|| methodsecond == '0103' || methodsecond == '0104'
					|| methodsecond == '0105' || methodsecond == '0106'
					|| methodsecond == '0107') {
				return "E.非现钞交易——其他";
			}
			// F.境外银行卡交易
			// “交易方式TSTP”第三至六位为0108、0109、0110、0005、0006、0007。
			if (methodsecond == '0108' || methodsecond == '0109'
					|| methodsecond == '0110' || methodsecond == '0005'
					|| methodsecond == '0006' || methodsecond == '0007') {
				return "F.境外银行卡交易";
			}
		}
		return "NULL";
	}
	return "NULL";
}

// 校验值是否全部由全角半角数字组成
function checkIsAllNumber(objValue, alertmsg) {
	reg = /^[１２３４５６７８９０1234567890]*$/;
	if (reg.test(objValue)) {// 全是数字返回true
		showAlert(alertmsg, "不能仅由数字组成!");
		return true;
	}
	return false;
}
function checkLength(objValue, standardLength, compare, alertmsg, tips) {
	var lengths = objValue.replace(/[^\x00-\xff]/g, "**").length;
	if (compare == ">") {
		if (lengths <= standardLength) {
			if (typeof (tips) == "undefined" || tips == '') {
				showAlert(alertmsg, " 必须大于: " + (standardLength) + "位!");
			} else {

				showAlertWithTips(alertmsg,
						" 必须大于: " + (standardLength) + "位!", tips);
			}
			return false;
		}
	}
	if (compare == "<") {
		if (lengths > standardLength) {
			if (typeof (tips) == "undefined" || tips == '') {
				showAlert(alertmsg, " 必须小于 " + (standardLength + 1) + "位!");
			} else {
				showAlertWithTips(alertmsg, " 必须小于 " + (standardLength + 1)
						+ "位!", tips);
			}
			return false;
		}
	}
	if (compare == "=") {
		if (lengths != standardLength) {
			if (typeof (tips) == "undefined" || tips == '') {
				showAlert(alertmsg, " 必须等于: " + standardLength + "位!");
			} else {
				showAlertWithTips(alertmsg, " 必须等于: " + standardLength + "位!",
						tips);
			}
			return false;
		}
	}
	return true;
}
// 校验居民身份证或临时身份证
function checkCard(objValue, alertmsg) {
	if (objValue == "") {
		showAlert(alertmsg, "不能为空");
		return false;
	}
	var iSum = 0;
	if (objValue.length < 15 || objValue.length > 18) {
		showAlert(alertmsg, "由15或18位数字(或17位数字加字母X)组成");
		return false;
	}
	if (objValue.length == 15) {
		if (!/^\d{15}$/i.test(objValue)) {
			showAlert("15位的 " + alertmsg, " 必须全是数字");
			return false;
		}
		sBirthday = Number(objValue.substr(6, 2) + 80) + "-"
				+ Number(objValue.substr(8, 2)) + "-"
				+ Number(objValue.substr(10, 2));
	} else {
		var regs = /^\d{17}(\d|X)$/;
		if (!regs.test(objValue)) {
			showAlert("18位" + alertmsg, "只能包含字母X");
			return false;
		}
		sBirthday = Number(objValue.substr(6, 4) + 80) + "-"
				+ Number(objValue.substr(10, 2)) + "-"
				+ Number(objValue.substr(12, 2));
	}
	if (aCity[parseInt(objValue.substr(0, 2))] == null) {
		showAlert(alertmsg, "前两位行政区代码为无效数字");
		return false;
	}
	var d = new Date(sBirthday.replace(/-/g, "/"));
	if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d
			.objValue())) {
		showAlert(alertmsg, "日期是不合法的");
		return false;
	}
	return true;
}
// 校验是否包含有全角字符
function checkSBCcase(objValue, alertmsg) {
	var reg = /[\uFE30-\uFFA0]/gi;
	if (reg.test(objValue)) {
		showAlert(alertmsg, "不得出现全角字符!");
		return false;
	}
	return true;
}

// 校验是否是字符或数字或"-"字符,
function checkNumOrletterOrSidelong(objValue, alertmsg) {
	var reg1 = /^[A-Za-z0-9]$/;
	var reg2 = /^[\-]$/;
	var count = 0;
	for ( var i = 0; i < objValue.length; i += 1) {
		var substr = objValue.substring(i, i + 1);
		if (reg1.test(substr) || reg2.test(substr)) {
			count += 1;
		}
	}
	if (count == objValue.length)
		return true;
	else {
		showAlert(alertmsg, "中不得含有除数字、字母、“-”之外的字符!");
		return false;
	}

}

// 判断字段是否全部为连续相同的数字
function checkConcatenationNumber(objValue, alertmsg) {
	if (checkNumber(objValue)) {
		var lengths = objValue.length;
		var count = 0;
		var onestr = objValue.substring(0, 1);
		for ( var i = 1; i < lengths; i += 1) {
			var schar = objValue.substring(i, i + 1);
			if (schar == onestr) {
				count++;
			}
		}
		if (count == (lengths - 1)) {
			showAlert(alertmsg, "不得为连续相同的数字组成!");
			return false;
		} else {
			return true;
		}
	}
	return true;
}
// 判断字段是否为数字
function checkNumber(obj) {
	var reg = /^[0-9]{0,}$/;
	if (reg.test(obj)) {
		return true;
	} else {
		return false;
	}
}
// 证件号码中如出现“(”（或“[”、“{”），则其后必须相应出现 “)”（或“]”、“}”）返回的字符串为空则代表校验通过，否则返回错误提示信息
function checkTwin(objValue, alertmsg) {
	var parenthesis = new Array();
	var k = 0;
	for ( var i = 0; i < objValue.length; i++) {
		var temp = objValue.charAt(i);
		if (temp == "(" || temp == ")" || temp == "[" || temp == "]"
				|| temp == "{" || temp == "}") {
			parenthesis[k] = temp;
			k++;
		}
	}
	if (parenthesis.length % 2 != 0) {
		showAlert(alertmsg, "中的括号不配对");
		return false;
	}
	for (j = 0; j < parenthesis.length;) {
		var temppar = parenthesis[j];
		if (temppar == ")") {
			if (parenthesis[j - 1] == "(") {
				parenthesis.splice(j - 1, 2);
				j = 0;
			} else {
				showAlert(alertmsg, "中的小括号不匹配");
				return false;
			}
		}
		if (temppar == "]") {
			if (parenthesis[j - 1] == "[") {
				parenthesis.splice(j - 1, 2);
				j = 0;
			} else {
				showAlert(alertmsg, "中的中括号不匹配");
				return false;
			}
		}
		if (temppar == "}") {
			if (parenthesis[j - 1] == "{") {
				parenthesis.splice(j - 1, 2);
				j = 0;
			} else {
				showAlert(alertmsg, "中的大括号不匹配");
				return false;
			}
		}
		j++;
	}
	if (parenthesis.length != 0) {
		showAlert(alertmsg, "中的括号不配对");
		return false;
	}
	return true;
}

// 校验长日期格式的合法性，是返回空字符，否则返回错误提示信息.格式为：20071022000000时分秒可以使用替代符号:t，例：2007102210tttt
function checkLongDate(objValue, alertmsg) {
	if (!checkLength(objValue, 14, "=", alertmsg)) {
		return false;
	}
	if (!checkShortDate(objValue.substring(0, 8), alertmsg)) {
		return false;
	}

	hour = objValue.substring(8, 10);
	if (hour != "tt") {
		if (checkNumber(hour)) {
			if (hour < 00 || hour > 24) {
				showAlertWithTips(alertmsg, "的小时的范围为:00-24",
						"格式为:年年年年月月日日时时分分秒秒，如无法获取准确时间，则相应位用”t”取代");
				return false;
			}
		} else {
			showAlertWithTips("未使用替代符号:tt时," + alertmsg, "的小时格式错误",
					"格式为:年年年年月月日日时时分分秒秒，如无法获取准确时间，则相应位用”t”取代");
			return false;
		}
	}
	minute = objValue.substring(10, 12);
	if (minute != "tt") {
		if (checkNumber(minute)) {
			if (minute < 00 || minute > 59) {
				showAlertWithTips(alertmsg, "的分钟的范围为:00-60",
						"格式为:年年年年月月日日时时分分秒秒，如无法获取准确时间，则相应位用”t”取代");
				return false;
			}
		} else {
			showAlertWithTips("未使用替代符号:tt时," + alertmsg, "的分钟格式错误",
					"格式为:年年年年月月日日时时分分秒秒，如无法获取准确时间，则相应位用”t”取代");
			return false;
		}
	}
	second = objValue.substring(12, 14);
	if (second != "tt") {
		if (checkNumber(second)) {
			if (second < 00 || second > 59) {
				showAlertWithTips(alertmsg, "的秒的范围为:00-60",
						"格式为:年年年年月月日日时时分分秒秒，如无法获取准确时间，则相应位用”t”取代");
				return false;
			}
		} else {
			showAlertWithTips("未使用替代符号:tt时," + alertmsg, "的秒格式错误",
					"格式为:年年年年月月日日时时分分秒秒，如无法获取准确时间，则相应位用”t”取代");
			return false;
		}
	}
	return true;
}

// 校验日期的格式是否合法,是返回空字符，否则返回错误提示信息.格式为：20071022
function checkShortDate(objValue, alertmsg) {
	if (!checkNumber(objValue)) {
		showAlert(alertmsg, "请输入8位数字");
		return false;
	}
	var year = objValue.substring(0, 4)
	if (year < 1900 || year > 2050) {
		showAlert(alertmsg, "的年的范围为:1900-2050");
		return false;
	}
	var month = objValue.substring(4, 6);
	if (month < 1 || month > 12) {
		showAlert(alertmsg, "的月的范围为:01-12");
		return false;
	}
	var day = objValue.substr(6, 8);
	if (day < 1 || day > 31) {
		showAlert(alertmsg, "的日的范围为:01-31");
		return false;
	}
	if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30)) { // 4,6,9,11月份日期不能超过30
		showAlert(alertmsg, ":" + year + "年" + month + "月的天数不的超过30天!");
		return false;
	}
	if (month == 2) {
		if (LeapYear(year)) {
			if (day > 29 || day < 1) {
				showAlert(alertmsg, ":" + year + "年" + month + "月的天数范围为:01-29!");
				return false;
			}
		} else {
			if (day > 28 || day < 1) {
				showAlert(alertmsg, ":" + year + "年" + month + "月的天数范围为:01-28!");
				return false;
			}
		}
	}
	return true;
}
// 判断是否闰年 参数（intYear 代表年份的值）（ return true: 是闰年 false: 不是闰年）
function LeapYear(intYear) {
	if (intYear % 100 == 0) {
		if (intYear % 400 == 0) {
			return true;
		}
	} else {
		if ((intYear % 4) == 0) {
			return true;
		}
	}
	return false;
}
// 比较格式为yyyyMMddtt的2个日期,第一个日期晚于等于第二个日期时,返回True
function compareDateNoHyphen(DateOne, DateTwo) {
	var OneYear = DateOne.substring(0, 4);
	var OneMonth = DateOne.substring(4, 6);
	var OneDay = DateOne.substring(6, 8);
	var TwoYear = DateTwo.substring(0, 4);
	var TwoMonth = DateTwo.substring(4, 6);
	var TwoDay = DateTwo.substring(6, 8);
	if (Date.parse(OneMonth + "/" + OneDay + "/" + OneYear) >= Date
			.parse(TwoMonth + "/" + TwoDay + "/" + TwoYear)) {
		return true;
	} else {
		return false;
	}
}
function compareDates(DateOne, DateTwo) {
	var OneMonth = DateOne.substring(5, DateOne.lastIndexOf("-"));
	var OneDay = DateOne
			.substring(DateOne.length, DateOne.lastIndexOf("-") + 1);
	var OneYear = DateOne.substring(0, DateOne.indexOf("-"));

	var TwoMonth = DateTwo.substring(5, DateTwo.lastIndexOf("-"));
	var TwoDay = DateTwo
			.substring(DateTwo.length, DateTwo.lastIndexOf("-") + 1);
	var TwoYear = DateTwo.substring(0, DateTwo.indexOf("-"));
	if (Date.parse(OneMonth + "/" + OneDay + "/" + OneYear) >= Date
			.parse(TwoMonth + "/" + TwoDay + "/" + TwoYear)) {
		return true;
	} else {
		return false;
	}
}
function daysUntilNow(sDate) { // sDat1是20021218格式
	var oDate1, oDate2, iDays;
	oDate1 = new Date(sDate.substring(0, 4), sDate.substring(4, 6) - 1, sDate
			.substring(6, 8));
	oDate2 = new Date();

	iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24);
	return iDays;
}
function checkenode(custypeValue) {
	var idnumber = document.getElementById("dataForm:idnumber");
	if (custypeValue == "C") {
		errorinfo = checkorgcode(idnumber, "组织机构代码");
		if (errorinfo == false) {
			return false;
		}
	}
}

// 校验组织机构代码是否符合校验规则
function checkorgcode(obj, msg) {
	if (obj.value.length != 9) {
		showAlert(msg, "长度必须为9位.");
		return false;
	}
	var patrn = /^[0-9A-Z]+$/;
	if (patrn.test(obj.value) == false) {
		showAlert(msg, "只可为数字或大写拉丁字母.");
		return false;
	}
	var lastpatrn = /^[0-9X]+$/;
	var checkcode = obj.value.substring(8, 9);
	if (lastpatrn.test(checkcode) == false) {
		showAlert(msg, "最后一位只可为数字或大写拉丁字母:X");
		return false;
	}
	var ancode;
	var ancodevalue;
	var total = 0;
	for ( var i = 0; i < obj.value.length - 1; i++) {
		ancode = obj.value.substring(i, i + 1);
		ancodevalue = findvalueinorgcodemapping(ancode);
		total = total + ancodevalue * weightedfactors[i];
	}
	var logiccheckcode = 11 - total % 11;
	if (logiccheckcode == 10) {
		logiccheckcode = 'X';
	}
	if (logiccheckcode == 11) {
		logiccheckcode = '0';
	}
	if (checkcode != logiccheckcode) {
		showAlert(msg, "最后一位校验码应为:" + logiccheckcode);
		return false;
	} else {
		return true;
	}
}
function findvalueinorgcodemapping(ancode){
	var mapping;
	var result=-1;
	for(var i=0;i<orgcodemapping.length;i++){
		mapping=orgcodemapping[i];
		if(mapping.substring(0,1)==ancode){
			result= mapping.substring(2,mapping.length);
			break;
		}
	}
	return result;
}
//
function checkactiontype(_actiontype) {

	var actiondesc = document.getElementById("dataForm:actiondesc");
	var isinsafe = document.getElementById("dataForm:isinsafe");

	if (_actiontype == "") {
		errorinfo = checkRequiredByValue(_actiontype, "操作类型");
		if (errorinfo == false) {
			return false;
		}
	} else if (_actiontype == "A") {
		errorinfo = checkRequiredByValue(null, "操作类型");
		if (errorinfo == false) {
			return false;
		}
	}

	if (_actiontype != "A") {

		errorinfo = checkRequired(actiondesc, "操作类型不为新建时，修改/删除原因");
		if (errorinfo == false) {
			return false;
		}
	} else if (isinsafe.value == "1") {
		errorinfo = checkRequiredByValue(null, "修改/删除,操作类型");
		if (errorinfo == false) {
			return false;
		}
	}
}

String.prototype.startsWith = function(substring) {
	var reg = new RegExp("^" + substring);
	return reg.test(this);
};

function showAlert(msgh, msghc) {
	var api = $.dialog({
		title : '标题',
		fixed : true,
		content : '请拖动滚动条查看',
		lock : true,
		background : 'red', // 背景色
		opacity : 0.87, // 透明度
		cache : true,
		ok : true,
	});
	api.content(
			'<font style=color:#6666>' + msgh + '</font>' + '<b>' + ' ' + msghc
					+ '</b>').title('校验结果:');
	return false;
}
function showAlertWithTips(msgh, msghc, tips) {
	var api = $.dialog({
		title : '校验结果:',
		fixed : true,
		content : '<font style=color:#678>' + msgh + '</font>' + '<b>' + ' '
				+ msghc + '</b>',
		lock : true,
		cache : true,
		ok : function() {
			$.dialog.tips(tips, 5);
			this.close();
			return false;
		},
	});
	return false;
}
function showTips(tips, s) {
	$.dialog.tips(tips, 2);
}
