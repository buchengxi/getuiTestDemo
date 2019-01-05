package com.accp.springboot.appPushMessageTo;

import com.accp.springboot.util.PushBase;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;

/**
 * 发送消息到个人APP,指定用户群体
 * @author buchengxi
 *
 */
public class PushMessageToSingle extends PushBase{
    
	
   /* private static String appId = "YpPMjJgDycAoKql1wU9Jx4"; //所指定用户的appId,key,masterSecret
    private static String appKey = "7WS272uOZk7xpMfOp0Vet4";
    private static String masterSecret = "A3f9UCVxm5AspWYjzi7vB9";
*/
    static String CID = "f9f23d5071ef2dbfbb8333cd342c9023";//客户端Clientid,唯一,使用者提供
    
    //别名推送方式
    // static String Alias = "";
    //static String host = "http://sdk.open.api.igexin.com/apiex.htm";//官方推送接口
    

    public static void main(String[] args) throws Exception {
        IGtPush push = new IGtPush(API, APPKEY, MASTERSECRET);
        
        LinkTemplate template = linkTemplateDemo();
        
        SingleMessage message = new SingleMessage();
        
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(APPID);
        target.setClientId(CID);
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }
    
    public static LinkTemplate linkTemplateDemo() {
        LinkTemplate template = new LinkTemplate();
        // 设置APPID与APPKEY
        template.setAppId(APPID);
        template.setAppkey(APPKEY);

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("娃哈哈");
        style.setText("你是一个逗比!~");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);

        // 设置打开的网址地址
        template.setUrl("http://www.baidu.com");
        return template;
    }
}
