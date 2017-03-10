/**
 * <pre> 
 * @fileoverview
 *                      Copyright (c) www.MarsClan.org
 * ============================================================================
 * JavaScript   : ��֤�������ļ�
 * Version      : 2.1
 * Author       : Х����
 * Date         : 2012-08-15
 * Dependences  : common-validator-2.1.min.js
 * Description  : 
 * 
 * ------------------------- Revision of history ------------------------------
 *  Х����@2012-08-15: �޸�����
 * 
 * 
 * ============================================================================
 * </pre>
 **/
(function($) {
  /**
   * ������Ϣ����
   */
  var Global = {
    
    /**
     * ������Ϣ��ʾ��ʽ.
     */
    showErrorType : {
      ALERT : 1, //ԭʼalert��ʾ
      PANLE : 2, //����Ϣ�������ʾ
      STYLE : 3, //����֤ʧ�ܵ��ֶ�����ʾ
      LABLE : 4  //����Ϣ��ǩ����ʾ
    }, 
    
    /**
     * ��֤�Ǽ�ģʽ.
     */
    registerType : {
      ADD       : 0, //���ģʽ
      FORM      : 1, //������ģʽ
      ADD_FORM  : 2  //ȫģʽ��֧����Ӻͱ�����ģʽ
    }
  };
  
	$.Config = {
	  registerType           : Global.registerType.ADD, 
    isFocus                : true, //��֤ʧ�ܺ��Ƿ���佹�� 
    enableSubValidator     : true, //�����ӣ�Ƕ�ף���֤��
    isManyErrorMessage     : true, //��֤ʧ�ܺ󣬴�����Ϣ�Ƿ�һ����ʾ
    showErrorType          : Global.showErrorType.ALERT, 
    alert                  : function(msg) {
      window.alert(msg);
    }
	};
})(jValidator);
