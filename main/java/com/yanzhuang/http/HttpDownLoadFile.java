package com.yanzhuang.http;
import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.ParseException;

import org.apache.http.Consts;
import org.apache.http.Header;  
import org.apache.http.HeaderElement;  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;  

public class HttpDownLoadFile {
	 public static final int cache = 10 * 1024;  
	    /** 
	     * ����url�����ļ������浽filepath�� 
	     * @param url 
	     * @param filepath 
	     * @return 
	     */  
	    public static void download(String url, String filepath) {  
	        try {  
	        	CloseableHttpClient httpclient = HttpClients.createDefault(); 
	            HttpGet httpget = new HttpGet(url);  
	            HttpResponse response = httpclient.execute(httpget);  
	  
	            HttpEntity entity = response.getEntity();  
	            InputStream is = entity.getContent();
	            
	            if (filepath == null) return ; 
	                
	            File file = new File(filepath);  
	            FileOutputStream fileout = new FileOutputStream(file);  
	            /** 
	             * ����ʵ������Ч�� ���û�������С 
	             */  
	            byte[] buffer=new byte[cache];  
	            int ch = 0;  
	            while ((ch = is.read(buffer)) != -1) {  
	                fileout.write(buffer,0,ch);  
	            }  
	            is.close();  
	            fileout.flush();  
	            fileout.close();  
	  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return ;  
	    }  
	  
	    public void postFile(String filePath,String upURL) throws ParseException, IOException
	    {
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        try{
	            // Ҫ�ϴ����ļ���·��
	          
	            // ��һ����ͨ�������ļ��ϴ������������ַ ��һ��servlet
	            HttpPost httpPost =new HttpPost(upURL);
	                  
	            // ���ļ�ת����������FileBody
	            File file =new File(filePath);
	            String fileName=file.getName();
	            FileBody bin =new FileBody(file); 
	            StringBody uploadFileName =new StringBody(
	                    fileName, ContentType.create(
	                            "text/plain", Consts.UTF_8));
	            //�����������ģʽ���У���ֹ�ļ������롣 
	            HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
	                    .addPart("file", bin)//uploadFile��Ӧ��������ͬ������<File����>
	                     //uploadFileName��Ӧ��������ͬ������<String����>
	                    .setCharset(CharsetUtils.get("UTF-8")).build();
	     
	            httpPost.setEntity(reqEntity);
	     
	            System.out.println("���������ҳ���ַ "+ httpPost.getRequestLine());
	            // �������� �������������Ӧ
	            CloseableHttpResponse response = httpClient.execute(httpPost);
	            try{
	                System.out.println("----------------------------------------");
	                // ��ӡ��Ӧ״̬
	                System.out.println(response.getStatusLine());
	                // ��ȡ��Ӧ����
	                HttpEntity resEntity = response.getEntity();
	                if(resEntity !=null) {
	                    // ��ӡ��Ӧ����
	                    System.out.println("Response content length: "
	                            + resEntity.getContentLength());
	                    // ��ӡ��Ӧ����
	                    System.out.println(EntityUtils.toString(resEntity,
	                            Charset.forName("UTF-8")));
	                }
	                // ����
	                EntityUtils.consume(resEntity);
	            }finally{
	                response.close();
	            }
	        }finally{
	            httpClient.close();
	        }
	    }

	    public static void main(String[] args) 
	    {  
	      for(int i=0;i<10;i++)	
	       {
           String url="https://www.xiashutxt.com/148512/read_62"+i+".html";  

	        String filepath = "E:\\С˵\\"+i+".html";  
	        HttpDownLoadFile.download(url, filepath);  
	       }
	    }  
}
