package com.bk.util;
//�����࣬�����ַ����մ��ȵĹ���
public class ToolUtil {

	//�ж��ַ����Ƿ�Ϊ��
	public static Boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	//�ж��ַ�����Ϊ��
	public static Boolean isnotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
}
