package com.accp.springboot.appPushMessageTo;


import java.util.ArrayList;
import java.util.List;

import com.accp.springboot.util.PushBase;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.uitls.AppConditions;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;

public class PushMessageToApp extends PushBase{    
    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
  

    public static void main(String[] args) throws Exception {
    	
        IGtPush push = new IGtPush(API, APPKEY, MASTERSECRET);
        
        LinkTemplate template = linkTemplateDemo();
        AppMessage message = new AppMessage();
        message.setData(template);
        

        message.setOffline(true);
        //离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 1000 * 3600);
        //推送给App的目标用户需要满足的条件
        AppConditions cdt = new AppConditions();
        List<String> appIdList = new ArrayList<String>();
        appIdList.add(APPID);
        message.setAppIdList(appIdList);
        //手机类型
        List<String> phoneTypeList = new ArrayList<String>();
        //省份
        List<String> provinceList = new ArrayList<String>();
        //自定义tag
        List<String> tagList = new ArrayList<String>();
        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
        cdt.addCondition(AppConditions.REGION, provinceList);
        cdt.addCondition(AppConditions.TAG,tagList);
        message.setConditions(cdt);
        IPushResult ret = push.pushMessageToApp(message,"任务别名_toApp");
        System.out.println(ret.getResponse().toString());
    }

    public static LinkTemplate linkTemplateDemo() throws Exception {
        LinkTemplate template = new LinkTemplate();
        template.setAppId(APPID);
        template.setAppkey(APPKEY);
        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("嘿嘿");
        style.setText("今天的天气你怎么看呢?");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);
        template.setUrl("http://www.baidu.com");
        return template;
    }

}
