package com.xxx.weixin.ssh.API;

import com.xxx.weixin.ssh.Model.WxUserInfo;
import com.xxx.weixin.ssh.Util.CommonUtil;

import net.sf.json.JSONObject;

public class WxGetUserinfo {

	
	/**
     * 获取用户信息
     * 
     * @param accessToken 接口访问凭证
     * @param openId 用户标识
     * @return WxUserInfo
     */
    public static WxUserInfo getUserInfo(String accessToken, String openId) {
        WxUserInfo weixinUserInfo = null;
        // 拼接请求地址
        String requestUrl = ConstantData.get_userinfo_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 获取用户信息
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                weixinUserInfo = new WxUserInfo();
                // 用户的标识
//                openid	用户的唯一标识
//                nickname	用户昵称
//                sex	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
//                province	用户个人资料填写的省份
//                city	普通用户个人资料填写的城市
//                country	国家，如中国为CN
//                headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
//                privilege	用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
//                unionid	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
                weixinUserInfo.setOpenId(jsonObject.getString("openid"));
                // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
//                weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
                // 用户关注时间
//                weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
                // 昵称
                weixinUserInfo.setNickname(jsonObject.getString("nickname"));
                // 用户的性别（1是男性，2是女性，0是未知）
                weixinUserInfo.setSex(jsonObject.getInt("sex"));
                // 用户所在国家
                weixinUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                weixinUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                weixinUserInfo.setCity(jsonObject.getString("city"));
                // 用户的语言，简体中文为zh_CN
//                weixinUserInfo.setLanguage(jsonObject.getString("language"));
                // 用户头像
                weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
            } catch (Exception e) {
//                if (0 == weixinUserInfo.getSubscribe()) {
//                  System.out.println("用户{"+ weixinUserInfo.getOpenId()+"}已取消关注");
//                } else {
//                    int errorCode = jsonObject.getInt("errcode");
//                    String errorMsg = jsonObject.getString("errmsg");
//                   System.out.println("获取用户信息失败 errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
//                }
            }
        }
        return weixinUserInfo;
    }
    
    public static void main(String args[]){
    	 getUserInfo("lDtrLfzPe0mO-6LXr71RYol2p1bp32jXeCC9hWTOPWyhCu1R3gJAKZH8Agm2GfarG8QugRu9ZeGBnIzBIPylu3NerFOwRw-aNQfKiknd-bw", "o9kTfwQzOMx-vlKgAq2cJBJHw8Pk");
    }
	
}
