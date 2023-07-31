package com.yanzhuang.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

//文件名必须是SendSms否则接口调用会出错

/*public class SendSms {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18013976186");
        request.putQueryParameter("SignName", "98飞翔的zz");
        request.putQueryParameter("TemplateCode", "SMS_172601251");
        request.putQueryParameter("TemplateParam", "{\"code\":\"3845\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}*/
public class SendSms {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", 
        		"LTAIK53mK811W2Ho", "r75IJjRnvdyUvcVzSo5hNTcysHHDNY");//自己的accessKeyId 自己的accessSecret
        IAcsClient client = new DefaultAcsClient(profile);
        int verificationcode=(int)((Math.random()*9+1)*1000);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //自定
        request.putQueryParameter("PhoneNumbers", "18013976186");//自己的电话号码
        request.putQueryParameter("SignName", "98飞翔的zz");//自己的短信签名名称
        request.putQueryParameter("TemplateCode", "SMS_172601251");//自己的短信模板ID
        //可无
        request.putQueryParameter("TemplateParam", "{\"code\":\""+verificationcode+"\"}");//自己的短信模板变量对应的值，例如：{\"code\":\"1111\"}
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}