function checkdata(jshtype) {
	var actiontype = document.getElementById("dataForm:actiontype");
	var actiondesc = document.getElementById("dataForm:actiondesc");
	var importdate = document.getElementById("dataForm:importdateInputDate");
	var custnm = document.getElementById("dataForm:custnm");
	var fcyccy = document.getElementById("dataForm:fcyccyInput");
	var lcyccy = document.getElementById("dataForm:lcyccyInput");
	var buscode = document.getElementById("dataForm:buscode");
	var lcyamt = document.getElementById("dataForm:lcyamt");
	var lcyacc = document.getElementById("dataForm:lcyacc");
	var exrate = document.getElementById("dataForm:exrate");
	var fcyamt = document.getElementById("dataForm:fcyamt");
	var fcyacc = document.getElementById("dataForm:fcyacc");
	var oppuser = document.getElementById("dataForm:oppuser");
	var oppbank = document.getElementById("dataForm:oppbank");
	// 以下为管理信息字段
	var usetype = document.getElementById("dataForm:usetypeselValue");	
	var txcode = document.getElementById("dataForm:txcodeselValue");	
	var crtuser = document.getElementById("dataForm:crtuser");	
	var usedetail = document.getElementById("dataForm:usedetail");	
	var regno = document.getElementById("dataForm:regno");	
	var inptelc = document.getElementById("dataForm:inptelc");	
	var cap = document.getElementById("dataForm:isCap");	
	
	errorinfo = checkRequired(actiontype, "操作类型");
	if (errorinfo == false) {
		return false;
	}
	
	errorinfo = checkRequired(buscode, "银行业务编号");
	if (errorinfo == false) {
		return false;
	}
	if ("JshD" == jshtype||"JshE" == jshtype) {
		errorinfo = checkRequired(importdate, "业务发生日期");
		if (errorinfo == false) {
			return false;
		}
		
		if ("JshD" == jshtype) {
			errorinfo = checkRequired(custnm, "结汇申请人名称");
			if (errorinfo == false) {
				return false;
			}
			errorinfo = checkRequired(fcyamt, "结汇金额");
			if (errorinfo == false) {
				return false;
			}
			errorinfo = checkRequired(fcyccy, "结汇币种");
			if (errorinfo == false) {
				return false;
			}
			errorinfo = checkRequired(oppuser, "人民币收款人名称");
			if (errorinfo == false) {
				return false;
			}
		
			if (lcyacc.value != "" ) {
				errorinfo = checkRequired(oppbank, "有人民币账户时,人民币开户行");
				if (errorinfo == false) {
					return false;
				}
		}
	}
	if ("JshE" == jshtype) {
		errorinfo = checkRequired(custnm, "购汇申请人名称");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(lcyamt, "购汇金额");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(lcyccy, "购汇币种");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(oppuser, "外汇收款人名称");
		if (errorinfo == false) {
			return false;
		}
		
		errorinfo = checkRequired(oppbank, "外汇账户开户行");
		if (errorinfo == false) {
			return false;
		}
		
	}
	}
	if ("JshF" == jshtype||"JshG" == jshtype) {
		if(cap.value){
			if(txcode.value.startsWith("5")
					||txcode.value.startsWith("6")
					||txcode.value.startsWith("7")
					||txcode.value.startsWith("8")){
				if(regno.value.Trim().length == 0){
				 showAlert("资本项目项下交易(涉外收支交易编码以“5”、“6”、“7”、“8”和部分“9”开头)" +
				 		"的“外汇局批件号/备案表号/业务编号”为必输项。如果确实没有应填写“N/A”（大写英文字符）。","");
				 regno.focus();
				 return false;
			}
			}
		}
		
		
		if("JshF" == jshtype){
			if(usetype.value=="005"||usetype.value=="006"||usetype.value=="099"){
				errorinfo = checkRequired(usedetail, "结售汇详细用途");
				if (errorinfo == false) {
					return false;
				}
			}
		}
		errorinfo = checkRequired(txcode, "交易代码");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(crtuser, "填报人");
		if (errorinfo == false) {
			return false;
		}
		errorinfo = checkRequired(inptelc, "填报人电话");
		if (errorinfo == false) {
			return false;
		}
	}
	
	
	
	
	errorinfo = checkRequired(fcyacc, "外汇账号");
	if (errorinfo == false) {
		return false;
	}
	
	errorinfo = checkRequired(exrate, "汇率");
	if (errorinfo == false) {
		return false;
	}
	
	
	if (actiontype.value != "A") {
		errorinfo = checkRequired(actiondesc, "操作类型不为新建时，修改/删除原因");
		if (errorinfo == false) {
			return false;
		}
	}

	
}
