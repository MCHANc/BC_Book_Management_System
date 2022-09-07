package com.bk.util;
//工具类，进行字符串空串等的工具
public class ToolUtil {

	//判断字符串是否为空
	public static Boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
	//判断字符串不为空
	public static Boolean isnotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
}
