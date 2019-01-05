package com.accp.springboot.util;

import java.util.Date;

public class PushBase {
		/**
		 * APPID,APPKEY,MASTERSECRET:由个推测试Demo提供,如何获取参见[个推技术文档]
		 * 该类是父类,提供个推app秘钥
		 */
		protected static  String APPID = "";
		protected static  String APPKEY = "";
		protected static  String MASTERSECRET = "";
		protected static  String API = "http://sdk.open.api.igexin.com/apiex.htm"; 	//OpenService接口地址
		protected static String getDate(){
			Date date = new Date();
			return date.toLocaleString();
	}


}
