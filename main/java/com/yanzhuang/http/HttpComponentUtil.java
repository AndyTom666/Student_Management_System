package com.yanzhuang.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpComponentUtil
{
    public static String doPostByJson(String url, String json){

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        String response = null;
        try {
            StringEntity s = new StringEntity(json.toString(),"utf-8");        //这里是关键,后面要跟上字符集格式
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = result;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }


}
