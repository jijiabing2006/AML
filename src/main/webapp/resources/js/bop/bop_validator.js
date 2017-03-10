
function checkdata(boptype) {
	var actiontype = document.getElementById("dataForm:actiontype");
	var actiondesc = document.getElementById("dataForm:actiondesc");
	var importdate = document.getElementById("dataForm:importdateInputDate");
	var custnm = document.getElementById("dataForm:custnm");
	var txccy = document.getElementById("dataForm:txccyInput");
	var txamt = document.getElementById("dataForm:txamt");
	var buscode = document.getElementById("dataForm:buscode");
	var lcyamt = document.getElementById("dataForm:lcyamt");
	var lcyacc = document.getElementById("dataForm:lcyacc");
	var exrate = document.getElementById("dataForm:exrate");
	var fcyamt = document.getElementById("dataForm:fcyamt");
	var fcyacc = document.getElementById("dataForm:fcyacc");
	var othamt = document.getElementById("dataForm:othamt");
	var othacc = document.getElementById("dataForm:othacc");
	var actuamt = document.getElementById("dataForm:actuamt");
	var actuccy = document.getElementById("dataForm:actuccyInput");
	var inchargeamt = document.getElementById("dataForm:inchargeamt");
	var outchargeamt = document.getElementById("dataForm:outchargeamt");
	var lcbgno = document.getElementById("dataForm:lcbgno");
	var tenor = document.getElementById("dataForm:tenor");
	var issdate = document.getElementById("dataForm:issdate");
	var idnumber=document.getElementById("dataForm:idnumber");

	errorinfo = checkRequired(actiontype, "操作类型");
	if (errorinfo == false) {
		return false;
	}
	errorinfo = checkRequired(importdate, "业务发生日期");
	if (errorinfo == false) {
		return false;
	}
	errorinfo = checkRequired(buscode, "银行业务编号");
	if (errorinfo == false) {
		return false;
	}
	errorinfo = checkRequired(idnumber, "证件代码");
	if (errorinfo == false) {
		return false;
	}
	lcyhead = "";
	if ("BopA" == boptype || "BopD" == boptype) {
		errorinfo = checkRequired(custnm, "收款人名称");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(txamt, "收款金额");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(txccy, "收款币种");
		if (errorinfo == false) {
			return false;
		}
		lcyhead = "结汇";
		
		
	}
	if ("BopB" == boptype || "BopC" == boptype || "BopE" == boptype
			|| "BopF" == boptype) {
		errorinfo = checkRequired(custnm, "付款人名称");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(txamt, "付款金额");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(txccy, "付款币种");
		if (errorinfo == false) {
			return false;
		}
		lcyhead = "购汇";
		if ( "BopC" == boptype || "BopF" == boptype) {
			errorinfo = checkRequired(actuamt, "实际付款金额");
			if (errorinfo == false) {
				return false;
			}
			errorinfo = checkRequired(actuccy, "实际付款币种");
			if (errorinfo == false) {
				return false;
			}
			if(actuccy.value!="" || actuamt.value!=""){
				if(actuccy.value == ""){
					errorinfo = showAlert(actuccy, "实际付款币种不为空时,实际付款金额必须输入");
					if (errorinfo == false) {
						return false;
					}
				}
				if(actuamt.value==""){
					errorinfo = showAlert(actuamt, "实际付款币种有值时,必须输入实际付款金额");
					if (errorinfo == false) {
						return false;
					}
				}
			}
			if(lcbgno.value!="" || tenor.value!="" || issdate.value!=""){
				
				errorinfo = checkRequired(lcbgno, "开证日期、期限不为空时,信用证/保函编号");
				if (errorinfo == false) {
					return false;
				}
				errorinfo = checkRequired(issdate, "信用证/保函编号、期限不为空时,开证日期");
				if (errorinfo == false) {
					return false;
				}
				errorinfo = checkRequired(tenor, "信用证/保函编号部、开证日期不为空时,期限");
				if (errorinfo == false) {
					return false;
				}
			}
		}
		
	}
	if (actiontype.value != "A") {
		errorinfo = checkRequired(actiondesc, "当操作类型不为新建时，修改/删除原因");
		if (errorinfo == false) {
			return false;
		}
	}

	if (exrate.value != "" || lcyamt.value != "" || lcyacc.value != "") {
		errorinfo = checkRequired(exrate, lcyhead + "金额、人民币帐号/银行卡号不为空时,"
				+ lcyhead + "汇率");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(lcyamt, lcyhead + "汇率、人民币帐号/银行卡号不为空时,"
				+ lcyhead + "金额");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(lcyacc, lcyhead + "汇率、" + lcyhead
				+ "金额不为空时,人民币帐号/银行卡号");
		if (errorinfo == false) {
			return false;
		}
	}
	if (fcyamt.value != "" || fcyacc.value != "") {
		errorinfo = checkRequired(fcyamt, "外汇帐号/银行卡号不为空时,现汇金额");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(fcyacc, "现汇金额不为空时,外汇帐号/银行卡号");
		if (errorinfo == false) {
			return false;
		}
	}
	if (othamt.value != "" || othacc.value != "") {
		errorinfo = checkRequired(othamt, "其他帐号/银行卡号不为空时,其他金额");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(othacc, "其他金额不为空时,其他帐号/银行卡号");
		if (errorinfo == false) {
			return false;
		}
	}
	if (lcyamt.value == "" && fcyamt.value == "" && othamt.value == "") {
		errorinfo = showAlert(lcyamt, lcyhead + "金额,现汇金额,其他金额必须有一项要输入");
		if (errorinfo == false) {
			return false;
		}
	}
	
	
	errorinfo=checkMoney(boptype,txamt,lcyamt,fcyamt,othamt,actuamt,inchargeamt,outchargeamt);
	if (errorinfo == false) {
		return false;
	}
}
function checkMethodAndLGNO(methodValue) {
	var lcbgno = document.getElementById("dataForm:lcbgno");
	var tenor = document.getElementById("dataForm:tenor");
	var issdate = document.getElementById("dataForm:issdate");
	if(methodValue=="L" ||methodValue =="G"){
		if(lcbgno.value=="" || issdate.value=="" || tenor.value==""){
			errorinfo = showAlert(lcbgno, "当结算方式为[L-信用证]或[G-保函]时,请输入信用证/保函编号、开证日期、期限");
			if (errorinfo == false) {
				return false;
			}
		}
	}else{
		if(lcbgno.value !="" || issdate.value !="" || tenor.value !=""){
			errorinfo = showAlert(lcbgno, "仅当结算方式为[L-信用证]或[G-保函]时,才需输入信用证/保函编号、开证日期、期限");
			if (errorinfo == false) {
				return false;
			}
		}
	}
	
	
}
function checkcharges(boptype,inchargeccy,outchargeccy) {
	var inchargeamt = document.getElementById("dataForm:inchargeamt");
	var outchargeamt = document.getElementById("dataForm:outchargeamt");
	if ("BopA" == boptype||"BopD" == boptype ){
		if(inchargeccy.getValue()!="" || inchargeamt.value!=""){
			if(inchargeccy.getValue() == ""){
				errorinfo = showAlert(null, "国内银行扣费金额不为空时,国内银行扣费币种必须输入",false);
				if (errorinfo == false) {
					return false;
				}
			}
			if(inchargeamt.value == ""){
				errorinfo = showAlert(inchargeamt, "国内银行扣费币种不为空时,国内银行扣费金额必须输入");
				if (errorinfo == false) {
					return false;
				}
			}
		}
	}	
	if ("BopA" == boptype||"BopC" == boptype ||"BopF" == boptype  ){
		var message="国外";
		if("BopA" == boptype){
			message+="银行扣费金额不为空时,银行扣费币种必须输入";
		}else{
			message="银行扣费金额不为空时,银行扣费币种必须输入";
		}
		if(outchargeccy.getValue()!="" || outchargeamt.value!=""){
			
			if(outchargeccy.getValue() == ""){
				errorinfo = showAlert("", message);
				if (errorinfo == false) {
					return false;
				}
			}
			if(outchargeamt.value == ""){
				errorinfo = showAlert(outchargeamt, message);
				if (errorinfo == false) {
					return false;
				}
			}
		}
	}
}

function checkMoney(boptype,txamt,lcyamt,fcyamt,othamt,actuamt,inchargeamt,outchargeamt){
	var total = new Number("0");
	if(lcyamt.value!=""){
		total = Math.round(new Number(lcyamt.value));
	}
	if(fcyamt.value!=""){
		total = total + new Number(fcyamt.value);
	}
	if(othamt.value!=""){
		total = total + new Number(othamt.value);
	}
	
	if ("BopA" == boptype || "BopD" == boptype) {
		if(parseInt(txamt.value) < total){
			errorinfo=showAlert("结汇金额、现汇金额、其它金额之和不能大于收入款金额",txamt.value);
			if (errorinfo == false) {
				return false;
			}
		}
	}
	
	if ("BopB" == boptype || "BopC" == boptype || "BopE" == boptype
			|| "BopF" == boptype) {
		if(parseInt(txamt.value) != total){
			errorinfo=showAlert("购汇金额、现汇金额、其它金额之和应等于付款金额",txamt.value);
			if (errorinfo == false) {
				return false;
			}
		}
		
		
		if ("BopC" == boptype || "BopF" == boptype) {
			var actucharge = new Number("0");
			if(actuamt.value!=""){
				actucharge = Math.round(new Number(actuamt.value));
			}
			if(outchargeamt.value!=""){
				actucharge = actucharge + new Number(outchargeamt.value);
			}
			if(parseInt(txamt.value) != actucharge){
				errorinfo=showAlert("实际付款金额、扣费金额之和应等于付款金额",txamt.value);
				if (errorinfo == false) {
					return false;
				}
			}
		}
	}
	
}
