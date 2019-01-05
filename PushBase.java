package com.accp.springboot.util;

import java.util.Date;

public class PushBase {
		
		protected static  String APPID = "YpPMjJgDycAoKql1wU9Jx4";
		protected static  String APPKEY = "7WS272uOZk7xpMfOp0Vet4";
		protected static  String MASTERSECRET = "A3f9UCVxm5AspWYjzi7vB9";
		protected static  String API = "http://sdk.open.api.igexin.com/apiex.htm"; 	//OpenService接口地址
		protected static String getDate(){
			Date date = new Date();
			return date.toLocaleString();
	}


}
