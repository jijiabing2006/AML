//大额普通字段
var bhoriginalfields = "rinm:报告机构名称:1,ricd:报告机构编码:1,ctnm:客户名称/姓名:1,citp:客户身份证件/证明文件类型:0,ctid:客户身份证件/证明文件号码:1,csnm:客户号:1,htdt:大额交易发生日期:1,finn:金融机构网点名称:1,finc:金融机构网点代码:1,ctac:账号:1,tbnm:代办人姓名:1,tbit:代办人身份证件/证明文件类型:0,tbid:代办人身份证件/证明文件号码:1,tstm:交易日期:1,ticd:业务标示号:1,tstp:交易方式:0,tdrc:交易方向:0,trcd:交易发生地:0,crpp:资金用途:1,crat:交易金额:1,cfin:对方金融机构网点名称:1,cfic:对方金融机构网点代码:1,tcnm:交易对手姓名/名称:1,tcit:交易对手身份证件/证明文件类型:0,cfct:对方金融机构代码网点类型:0,tcid:交易对手身份证件/证明文件号码:1,tcac:交易对手账号:1";
// Richfaces 下拉列表（使用RF的字段） crcd:大额交易特征代码,
var bhoriginalfieldsRFselect = "ctnt:客户国籍,firc:金融机构所在地区行政区划代码,tbnt:代办人国籍,tsct:涉外收支交易分类与代码,tsdr:资金收付标志,rltp:金融机构与大额交易的关系,fict:金融机构网点代码类型";
// RichFaces autocomplete组件
var bhoriginalfieldsRFvalue = "catp:账户类型,tcat:交易对手账户类型,crtp:币种";

// 可以有空格
var bhcanhasspace="finn,cfin";

// 可以有空格，但是前后不能有空格
var bhfrontandbackhasspace="ctnm,tbnm,tcnm";

// CTNM 客户名称/姓名 允许包含特殊字符“&”(特殊字符校验规则中好像就不包含&）

// A,B,C,D,E√ 满足相关条件时不能使用替代符
var bhcantusesubstituteneedchecktype="ctnm@A:B:C:D:E,citp@A:B:C:D:E,ctid@A:B:C:D:E,ctnt@A:B:C:D:E,trcd@A,tdrc@B:C:D:E:F";

// 可以使用替代符的字段名
var bhcanusesubstitute="rltp,catp,ctac,tbnm,tbit,tbid,tbnt,tsct,tdrc,crpp,crtp,crat,cfin,cfct,cfic,tcnm,tcit,tcid,tcat,tcac";

//要求名称校验的字段
var bhchecknamefields="ctnm,tbnm,tcnm";
//要求证件号码校验的字段
var bhcheckidnumberfields="ctid,tbid,tcid";

//必须为指定长度的字段(使用替代符时除外)
var bhfixlengthfields="tstm:14,htdt:8,ctnt:3,catp:4,ricd:15,crcd:4,firc:6,finc:12,tbnt:3,tstp:6,tsct:6,crtp:3,tcat:4,cfic:12,tdrc:9,trcd:9";

function checkdata() {
	

	var isexport = document.getElementById("dataForm:isexportselValue");
	var remark = document.getElementById("dataForm:remark");

	/** *********************************校验是否为空*********************************************** */
	/** ********************报送状态 如为:不报送 直接保存报送状态 不再进行校验************************* */
	if (isexport.value == "2") {
		// return true;
		
//		return alertMsg(objValue,  "选择报送状态为不报送","不报送吗?");
//		return showMsg('',"选择报送状态为不报送","?");
		if (!confirm("选择报送状态为<不报送>将不会校验数据的合法性而只修改记录的报送状态.\n确定该条记录的报送状态为<不报送>吗?")) {
			return false;
		} else {
			if (!checkRequiredByValue(remark.value, "不报送原因")) {
				return false;
			}
			return true;
		}
	}
	if (!combinField()) {
		return false;
	}
	// 检验上报字段
	if (!check()) {
		return false;
	}
    //
// return false;
//

// function check() {
//
// return false;
// }
	// ---------------------------------------所有的校验通过后确认保存的提示信息--------------------------------//
	if(confirm('确定保存修改后的大额信息？')){
		return true;
	}else{
		return false;
	}
//	return showConfirm('确定保存修改后的大额信息？');
}

function check() {
	// alert("not RF");
	var fields = bhoriginalfields.split(",");
	for ( var i = 0; i < fields.length; i++) {
		var fieldAndName = fields[i].split(":");
		var elementId = "dataForm:" + fieldAndName[0];
// alert("elementId=====" + elementId);
		var obj = document.getElementById(elementId);
// alert(elementId+"=========" + obj.value);
		obj.style.color="";
		if (!checkByObj(obj.value, fieldAndName)) {
			if(fieldAndName[2]==1){
				obj.style.color="red";
				obj.focus();
			}
			return false;
		}
	}
	// RF
// alert("RF");
	var rfselfields = bhoriginalfieldsRFselect.split(",");
	for ( var i = 0; i < rfselfields.length; i++) {
		var fieldAndName = rfselfields[i].split(":");
		var elementId = "dataForm:" + fieldAndName[0] + "selValue";
// alert("elementId=====" + elementId);
		var obj = document.getElementById(elementId);
// alert(elementId+"=========" + obj.value);
		obj.style.color="";
		if (!checkByObj(obj.value, fieldAndName)) {
			obj.style.color="red";
			return false;
		}
	}
	var rfvaluefields = bhoriginalfieldsRFvalue.split(",");
	for ( var i = 0; i < rfvaluefields.length; i++) {
		var fieldAndName = rfvaluefields[i].split(":");
		var elementId = "dataForm:" + fieldAndName[0] + "Input";
// alert("elementId=====" + elementId);
		var obj = document.getElementById(elementId);
// alert(elementId+"=========" + obj.value);
		obj.style.color="";
		if (!checkByObj(obj.value, fieldAndName)) {
			obj.style.color="red";
			return false;
		}
		
	} 
    return true;
}
// 
function checkByObj(objValue,fieldAndName){
	if (typeof (objValue) != "undefined") {
		// 检验上报字段是否为空
		if (!checkRequiredByValue(objValue, fieldAndName[1])) {
			return false;
		}
		// 校验是否包含特殊字符
		if (!checkspecialcharacter(objValue, fieldAndName[1])) {
			return false;
		}
	    //校验是否满足指定长度(使用替代符时除外)
		if(!objValue.startsWith("@")){
			if(bhfixlengthfields.indexOf(fieldAndName[0])>-1){// 不可以使用空格
				if (!checkfixlength(objValue, fieldAndName)) {
					return false;
				}
			}
		}
		// 校验是否出现空格(包括前后)
		if(bhcanhasspace.indexOf(fieldAndName[0])==-1){// 不可以使用空格
			if(bhfrontandbackhasspace.indexOf(fieldAndName[0])>-1){
				// 前后不能有空格
				if (!checkStartOrEndVacant(objValue, fieldAndName[1])) {
					return false;
				}	
			}else{
				// 不能有空格
				if (!checkVacant(objValue, fieldAndName[1])) {
					return false;
				}	
			}
		}	
//		alert("44444444444"+fieldAndName[1]);
		// 校验是否可以使用替代符
		if(objValue=="@I" || objValue=="@N" || objValue=="@E"){
			if (!canUseSubstitute(fieldAndName[0],bhcanusesubstitute)) {
				if(!isDonotUseSubstitute(fieldAndName,bhcantusesubstituteneedchecktype)){
					return false;
				}
				var methodType=getPaymethodType(document.getElementById("dataForm:tstp").value);
				if("NULL"!=methodType){
					if (!checkIsUseSubstitute(fieldAndName,methodType,bhcantusesubstituteneedchecktype)) {
						return false;
					}
				}
			}	
		}
		// 名称校验
		if(bhchecknamefields.indexOf(fieldAndName[0])>-1){
			if (!checkName(objValue, fieldAndName)) {
				return false;
			}	
		}
		//证件号码的检查校验
		if(bhcheckidnumberfields.indexOf(fieldAndName[0])>-1){
			if (!checkIdnumberOrEncodeLength(objValue, fieldAndName)) {
				return false;
			}	
		}
		//账号校验
		if(!checkAccountno(objValue,fieldAndName)){
			return false;
		}
		//日期的检查校验
		if(!checkDate(objValue,fieldAndName)){
			return false;
		}
		//地区代码校验
		if(!checkAreacode(objValue,fieldAndName)){
			return false;
		}
		//其他校验
		//代办人
		if(!checkTbinfo(objValue,fieldAndName)){
			return false;
		}
		//对于类型“13：银行卡（通过ATM且跨行交易）”的交易，“交易方向（TDRC）”允许填写替代符。
		if(!checkTdrc(objValue,fieldAndName)){
			return false;
		}
		
		return true;
	}
	alert("obj is undefined ...........");
	return false;
}
/*
 * "（一）客户名称不能仅由数字组成 
 * （二）除使用替代符号填写客户名称的情况外，客户名称字段的长度不得少于4个字节，
 * 如根据“客户身份证件/证明文件类型CITP”判定客户类别为对公客户，则“客户名称/姓名CTNM”字段长度不得少于8个字节。
 * （三）根据中心发【2008】4号文，如对公客户“客户名称/姓名”全称确少于8个字节， 则报告机构应在其后用半角括号对客户身份或名称进行解释。
 * 例如对公客户名称为“四五九”，且经客户身份识别后，报告机构确定该客户为某国家安全单位， 则“客户名称/姓名CTNM”可填写为“四五九(国家安全单位)”。"
 */
function checkName(objValue,  fieldAndName){
	// 客户名称不能仅由数字组成
	if(checkIsAllNumber(objValue, fieldAndName[1])){
		return false;
	}
	if(objValue=="@I" || objValue=="@N" || objValue=="@E"){
	}else{ 
		if(!checkLength(objValue, 3, ">","除使用替代符号填写"+fieldAndName[1]+"的情况外，"+fieldAndName[1])){
			return false;
		}
		if(!checkIdnumberOrEncodeLength(objValue,  fieldAndName)){
			return false;
		}
	}
	return true;
}

//***************************************************************************************************//
//---------------------------------------证件号码的检查校验---------------------------------------------//
/*
本规则所指“证件号码”包括列出的大额交易要素
1	CITP	客户身份证件/证明文件类型
2	CTID	客户身份证件/证明文件号码
3	TBIT	代办人身份证件/证明文件类型
4	TBID	代办人身份证件/证明文件号码
5	TCIT	交易对手身份证件/证明文件类型
6	TCID	交易对手身份证件/证明文件号码
*
* 如根据“客户身份证件/证明文件类型CITP”判定客户类别为对公客户，则“客户名称/姓名CTNM”字段长度不得少于8个字节。
* （三）根据中心发【2008】4号文，如对公客户“客户名称/姓名”全称确少于8个字节， 则报告机构应在其后用半角括号对客户身份或名称进行解释。
* 例如对公客户名称为“四五九”，且经客户身份识别后，报告机构确定该客户为某国家安全单位， 则“客户名称/姓名CTNM”可填写为“四五九(国家安全单位)”。"
* 
*/

function checkIdnumberOrEncodeLength(objValue,  fieldAndName){
	    var ctype;
	    var infob="身份证件/证明文件类型为对公客户时，";
	    var infoh="";
	    var tips="确少于8个字节，则报告机构应在其后用半角括号对客户身份或名称进行解释。";
	    
		if(fieldAndName[0]=="ctid"||fieldAndName[0]=="ctnm"){
			infoh="客户";
			ctype = document.getElementById("dataForm:citp");
		}
		if(fieldAndName[0]=="tbid"||fieldAndName[0]=="tbnm"){
			infoh="代办人";
			ctype = document.getElementById("dataForm:tbit");
		}
		if(fieldAndName[0]=="tcid"||fieldAndName[0]=="tcnm"){
			infoh="交易对手";
			ctype = document.getElementById("dataForm:tcit");
		}
		if (typeof (ctype) != "undefined") {
			//证件号码校验
			if(bhcheckidnumberfields.indexOf(fieldAndName[0])>-1){
		    	if(ctype.value==11 || ctype.value==13 || ctype.value==14 || ctype.value==21){
		    		//居民身份证或临时身份证检验
		    		if(ctype.value=="11"){
						if(!checkCard(objValue,fieldAndName[1])){
							return false;
						}
					}
		    		//参照数据字典则得知:证件类型为组织机构代码时长度为9位.
		    		if(ctype.value=="21" ){
			    		if(!checkLength(objValue, 9, "=",infoh+infob+fieldAndName[1])){
			    			return false;
			    		}
			    	}
		    		//填写“居民身份证或临时身份证”、“港澳居民往来内地通行证；台湾居民来往大陆通行证或其他有效旅行证件”、“外国公民护照”、
					//“组织机构代码”时，不得使用全角字符。
		    		if(!checkSBCcase(objValue,fieldAndName[1])){
		    			return false;	
		    		}
		    	}
		    	
				//证件号码中如出现“(”（或“[”、“{”），则其后必须相应出现 “)”（或“]”、“}”）
		    	   if(!checkTwin(objValue,fieldAndName[1])){
		    	    	return false;
		    	    }
				//证件号码字段如未使用“@N”、“@I”、“@E”等替代符号，则证件号码类型字段不得使用上述替代符号
		    	if(!objValue.startsWith('@')){
		    		if(ctype.value.startsWith("@")){
		    			showAlert(fieldAndName[1]+"如未使用“@N”、“@I”、“@E”等替代符号，则"+fieldAndName[1]+"类型字段不得使用上述替代符号",'') ;
		    			return false;
		    		}
		    		//所有证件号码必须大于或等于6位,
		    		if(!checkLength(objValue, 6, ">",fieldAndName[1])){
		    			return false;
		    		}
		    	}
			}
			// 名称校验
			if(bhchecknamefields.indexOf(fieldAndName[0])>-1){
				if(ctype.value=="21"||ctype.value.startsWith("29")){
					if(!checkLength(objValue, 7, ">",infoh+infob+fieldAndName[1],tips)){
						return false;
					}
				}
			}
		
		   
	    }
	return true;
}
//账号校验
function checkAccountno(objValue,  fieldAndName){
	/*
	账号中不得含有除数字、字母、“-”之外的字符，且不得使用全角字符
	账号字段不得全部为连续相同的数字，例如“11111111111111”等。
	“账号CTAC”和“交易对手账号TCAC”
*/
	if(fieldAndName[0]=="ctac"||fieldAndName[0]=="tcac"){
	    if(!checkNumOrletterOrSidelong(objValue, fieldAndName[1])){
	   		return false;
	   	}
	   	if(!checkSBCcase(objValue,fieldAndName[1])){
	   		return false;	
	   	}
	   	if(!checkConcatenationNumber(objValue,fieldAndName[1])){
	   		return false;	
	   	}  
      }
	return true;
}
//日期和时间校验
function checkDate(objValue,  fieldAndName){
//（一）大额交易和可疑交易的“交易日期TSTM”应按照规定时间精度填写，如无法获知准确时间，则相应位置填写半角字母“t”，例如“2007071315tttt”。对“时”、“分”、“秒”位检查校验要求为：0≤时<24，0≤分<60，0≤秒<60。
	if(fieldAndName[0]=="tstm"){
		
		if(!checkLength(objValue, 14, "=",fieldAndName[1])){
			return false;
		}
		if(!checkLongDate(objValue, fieldAndName[1])){
			return false;
		}
		var htdt=document.getElementById("dataForm:htdt");
		if(htdt.value!=objValue.substring(0,8)){
			showAlert("交易日期与大额交易发生日期的年月日应一致","");
			return false;
		}
		if(daysUntilNow(htdt.value)>5){
			showTips("“交易日期TSTM” 中的“年年年年月月日日”部分要早于或等于文件名中的报送日期，但不能超过5个工作日。",3);
		}
		
	}

//（二）在大额交易报文中，“报告生成日期RPDT”要晚于或等于“大额交易发生日期HTDT”，“大额交易发生日期HTDT”要与“交易日期TSTM”中的“年年年年月月日日”部分相同。
//（三）在可疑交易报文中，“报告生成日期RPDT”要晚于或等于“交易日期TSTM”中的“年年年年月月日日”部分，“销户时间CATM”要晚于或等于“开户时间OATM”。
//（四）在大额交易报告的普通报文中，“交易日期TSTM” 中的“年年年年月月日日”部分要早于或等于文件名中的报送日期，但不能超过5个工作日。
//（五）在可疑交易报告的普通报文中，“交易日期TSTM” 中的“年年年年月月日日”部分要早于或等于文件名中报送日期，且整个报文中至少有一个“交易日期TSTM”与文件名中报送日期的差距不多于10个工作日。"

	return true;
}

function checkfixlength(objValue,  fieldAndName){
	var fields = bhfixlengthfields.split(",");
	for ( var i = 0; i < fields.length; i++) {
		var fan = fields[i].split(":");
		if (fan[0]==fieldAndName[0]) {
			if(!checkLength(objValue,fan[1], "=",fieldAndName[1])){
				return false;
			}
		}
	}
	return true;
}
function checkAreacode(objValue,  fieldAndName){
	if(fieldAndName[0]=="trcd"){
		var methodType=getPaymethodType(document.getElementById("dataForm:tstp").value);
		if(objValue.startsWith("@")){
			if("A"==methodType){
				showAlert("当交易方式为现金类交易时必须按境内真实交易发生地填写，不得填写替代符。","");
				return false;
			}
		}
	}
	return true;
}
function checkTbinfo(objValue,  fieldAndName){
	if(fieldAndName[0]=="tbnm"){
		var v1=document.getElementById("dataForm:tbitfirst").value;
		var v2=document.getElementById("dataForm:tbid").value;
		var v3=document.getElementById("dataForm:tbntselValue").value;	
		if(!objValue.startsWith("@")?!v1.startsWith("@")?!v2.startsWith("@")?!v3.startsWith("@")?true:false:false:false:false){
			//全不是@
		}else if(objValue.startsWith("@")?v1.startsWith("@")?v2.startsWith("@")?v3.startsWith("@")?true:false:false:false:false){
			//全是@
		}else{
			showAlert("代办人姓名，身份证件/证明文件类型，身份证件/证明文件号码，国籍可填写替代符号，但这四项中有一项非替代符号，则其他项不得填写替代符号。","");
			return false;
		}
	}
	return true;
}

function checkTdrc(objValue,  fieldAndName){
	if(fieldAndName[0]=="tdrc"){
		if(objValue.startsWith("@")){
			//对于类型“13：银行卡（通过ATM且跨行交易）”的交易，“交易方向（TDRC）”允许填写替代符
			var v=document.getElementById("dataForm:tstp").value;
			if(v!="000113"?v!="000013"?true:false:false){
				showAlert("只有类型“13：银行卡（通过ATM且跨行交易）”的交易，“交易方向（TDRC）”允许填写替代符","");
				return false;
			}
			
		}
	}
	return true;
}


function combinField() {
	// 支付方式
	var methodfirst = document.getElementById("dataForm:methodfirst").value;
	var methodsecond = document.getElementById("dataForm:methodsecond").value;
	if(methodfirst=="00"){
		var methodthird = document.getElementById("dataForm:methodthird").value;
		document.getElementById("dataForm:tstp").value=methodfirst+methodsecond+methodthird;
		// alert("method=====" + methodfirst+methodsecond+methodthird);
	}else{
		document.getElementById("dataForm:tstp").value=methodfirst+methodsecond;
	}
	// alert("tstp==="+document.getElementById("dataForm:tstp").value);
	
	
	// 客户证件类型说明
	var citpfirst = document.getElementById("dataForm:citpfirst").value;
	if (tbitfirst == "19"||tbitfirst == "29") {
	var citpsecond = document.getElementById("dataForm:citpsecond").value;
	document.getElementById("dataForm:citp").value=citpfirst+citpsecond;
	// alert("客户证件类型说明=====" + citpfirst+citpsecond);
	}else{
		document.getElementById("dataForm:citp").value=citpfirst;
	}
	// alert("citp==="+document.getElementById("dataForm:citp").value);
	// 交易对手证件类型说明
	var tcitfirst=document.getElementById("dataForm:tcitfirst").value;
	if (tbitfirst == "19"||tbitfirst == "29") {
		var tcitsecond=document.getElementById("dataForm:tcitsecond").value;
		document.getElementById("dataForm:tcit").value=tcitfirst+tcitsecond;
		// alert("交易对手证件类型说明=====" + tcitfirst+tcitsecond);
	}else{
		document.getElementById("dataForm:tcit").value=tcitfirst;
	}
		
	// alert("tcit==="+document.getElementById("dataForm:tcit").value);
	// 代办人证件类型说明
	var tbitfirst=document.getElementById("dataForm:tbitfirst").value;
	if (tbitfirst == "19"||tbitfirst == "29") {
		var tbitsecond=document.getElementById("dataForm:tbitsecond").value;
		document.getElementById("dataForm:tbit").value=tbitfirst+tbitsecond;
		// alert("代办人证件类型说明=====" + tbitfirst+tbitsecond);
	}else{
		document.getElementById("dataForm:tbit").value=tbitfirst;
	}
	// alert("tbit==="+document.getElementById("dataForm:tbit").value);
	
	
	// 交易方向
	var tdrcfirst=document.getElementById("dataForm:tdrcfirstselValue").value;
	var tdrcsecond=document.getElementById("dataForm:tdrcsecondselValue").value;
	if(tdrcfirst.startsWith("@")){
		document.getElementById("dataForm:tdrc").value=tdrcfirst;
	}else{
		document.getElementById("dataForm:tdrc").value=tdrcfirst+tdrcsecond;
	}

	 if(tdrcfirst.substring(0,2)=="Z0"||tdrcfirst=="CHN"){
		 if(tdrcsecond=="000000"){
			 showAlert("交易方向（TDRC）为CHN或者Z0x时，区域代码不能为“000000”。","");
			 return false;
		 }
	 }
	
	// alert("交易方向=====" + tdrcfirst+tdrcsecond);
	// alert("tdrc==="+document.getElementById("dataForm:tdrc").value);
	// 交易发生地
	var trcdfirst=document.getElementById("dataForm:trcdfirstselValue").value;
	var trcdsecond=document.getElementById("dataForm:trcdsecondselValue").value;
	if(trcdfirst.startsWith("@")){
		document.getElementById("dataForm:trcd").value=trcdfirst;
	}else{
		document.getElementById("dataForm:trcd").value=trcdfirst+trcdsecond;
	}
	if(trcdfirst.substring(0,2)=="Z0"||trcdfirst=="CHN"){
		 if(trcdsecond=="000000"){
			 showAlert("交易发生地（TRCD）为CHN或者Z0x时，区域代码不能为“000000”。","");
			 return false;
		 }
	 }
	
		 
	// alert("交易发生地=====" + trcdfirst+trcdsecond);
	// alert("trcd==="+document.getElementById("dataForm:trcd").value);
	return true;
}
//设置替代字符联动
function setrepalceChar(replacerChar,type){
	if(replacerChar =="@I" || replacerChar =="@N" || replacerChar =="@E"){
		if(type == "tb"){
			document.getElementById("dataForm:tbnm").value=replacerChar;//代办人姓名
			document.getElementById("dataForm:tbitfirst").value=replacerChar;//代办人身份证件类型
			document.getElementById("dataForm:tbid").value=replacerChar;//代办人身份证件号码
			document.getElementById("dataForm:tbntselValue").value=replacerChar;//代办人国籍	
			document.getElementById("dataForm:tbntInput").value=replacerChar;//代办人国籍	
			setTypeclaration('tb');
		}
		if(type == "tc"){
			//document.getElementById("bigamountform:tcnm").value=replacerChar;//交易对手姓名
			document.getElementById("dataForm:tcitfirst").value=replacerChar;//交易对手证件类型
			document.getElementById("dataForm:tcid").value=replacerChar;//交易对手证件号码
			document.getElementById("dataForm:tcatInput").value=replacerChar;//交易对手账号类型
			setTypeclaration('tc');
		}
	}
	if(type=="tb"){
		setTypeclaration('tb');
	}
	if(type=="tc"){
		setTypeclaration('tc');
	}
}
// 客户证件类型/代办人证件类型/交易对手证件类型说明 setTypeclaration setTcitTSecond
function setTypeclaration(type){
	if(type=="ct"){
		var citpfirst=document.getElementById("dataForm:citpfirst").value;
		if (typeof(citpfirst) != "undefined") { 
			if (citpfirst == "19"||citpfirst == "29") {
				document.getElementById("dataForm:citpsecond").disabled =false;
				document.getElementById("dataForm:citpsecond").value ="";
				document.getElementById("dataForm:citpsecond").focus();
			}else{
				document.getElementById("dataForm:citpsecond").value ="身份证件类型为19,29时,需输入说明";
				document.getElementById("dataForm:citpsecond").disabled =true;
				document.getElementById("dataForm:ctid").focus();
			}
		}
	}
	
	if(type=="tc"){
		var tcitfirst=document.getElementById("dataForm:tcitfirst").value;
		if (typeof(tcitfirst) != "undefined") { 
			if (tcitfirst == "19"||tcitfirst == "29") {
				document.getElementById("dataForm:tcitsecond").disabled =false;
				document.getElementById("dataForm:tcitsecond").value ="";
				document.getElementById("dataForm:tcitsecond").focus();
			}else{
				document.getElementById("dataForm:tcitsecond").value ="身份证件类型为19,29时,需输入说明";
				document.getElementById("dataForm:tcitsecond").disabled =true;
				document.getElementById("dataForm:tcid").focus();
			}
		}
	}
	
	if(type=="tb"){
		var tbitfirst=document.getElementById("dataForm:tbitfirst").value;
		if (typeof(tbitfirst) != "undefined") { 
			if (tbitfirst == "19"||tbitfirst == "29") {
				document.getElementById("dataForm:tbitsecond").disabled =false;
				document.getElementById("dataForm:tbitsecond").value ="";
				document.getElementById("dataForm:tbitsecond").focus();
			}else{
				document.getElementById("dataForm:tbitsecond").value ="身份证件类型为19,29时,需输入说明";
				document.getElementById("dataForm:tbitsecond").disabled =true;
				document.getElementById("dataForm:tbid").focus();
			}
		}
	}
}
//客户证件类型说明
function setCitpSecond(){
	var citpfirst=document.getElementById("dataForm:citpfirst").value;
	if (typeof(citpfirst) != "undefined") { 
		if (citpfirst == "19"||citpfirst == "29") {
			document.getElementById("dataForm:citpsecond").disabled =false;
			document.getElementById("dataForm:citpsecond").value ="";
			document.getElementById("dataForm:citpsecond").focus();
			document.getElementById("dataForm:tcc")="red";//提示颜色
		}else{
			document.getElementById("dataForm:citpsecond").value ="身份证件类型为19,29时,需输入说明";
			document.getElementById("dataForm:citpsecond").disabled =true;
			document.getElementById("dataForm:ctid").focus();
			
		}
	}
}

