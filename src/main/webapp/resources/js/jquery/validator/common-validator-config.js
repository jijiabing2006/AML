/**
 * <pre> 
 * @fileoverview
 *                      Copyright (c) www.MarsClan.org
 * ============================================================================
 * JavaScript   : 验证器配置文件
 * Version      : 2.1
 * Author       : 啸白腥
 * Date         : 2012-08-15
 * Dependences  : common-validator-2.1.min.js
 * Description  : 
 * 
 * ------------------------- Revision of history ------------------------------
 *  啸白腥@2012-08-15: 修改内容
 * 
 * 
 * ============================================================================
 * </pre>
 **/
(function($) {
  /**
   * 配置信息常量
   */
  var Global = {
    
    /**
     * 错误信息提示方式.
     */
    showErrorType : {
      ALERT : 1, //原始alert提示
      PANLE : 2, //在信息面板中提示
      STYLE : 3, //在验证失败的字段上显示
      LABLE : 4  //在信息标签中显示
    }, 
    
    /**
     * 验证登记模式.
     */
    registerType : {
      ADD       : 0, //添加模式
      FORM      : 1, //表单生成模式
      ADD_FORM  : 2  //全模式。支持添加和表单两种模式
    }
  };
  
	$.Config = {
	  registerType           : Global.registerType.ADD, 
    isFocus                : true, //验证失败后是否会落焦点 
    enableSubValidator     : true, //启用子（嵌套）验证器
    isManyErrorMessage     : true, //验证失败后，错误信息是否一块显示
    showErrorType          : Global.showErrorType.ALERT, 
    alert                  : function(msg) {
      window.alert(msg);
    }
	};
})(jValidator);
