import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class Ocr_ShangTang {
	
	// ���֤��Ϣ
	public static final String filepath = "C:/pic/003touxiang.jpg";//ͼƬ·��
    public static final String POST_URL = "http://10.62.0.252:4000/ocr/idcard/stateless";
    
    // ���п���Ϣ
    public static final String filepath01 = "C:/Users/card.jpg";//ͼƬ·��
    public static final String POST_URL01 = "https://v2-auth-api.visioncloudapi.com/ocr/bankcard/stateless";

    @SuppressWarnings({ "resource" })
	public static void HttpClientPost_idcard() throws ClientProtocolException, IOException {
          HttpClient httpclient = new DefaultHttpClient();
          HttpPost post = new HttpPost(POST_URL);
          FileBody fileBody = new FileBody(new File(filepath));
          MultipartEntity entity = new MultipartEntity();
          entity.addPart("image_file", fileBody);
          entity.addPart("side", new StringBody("front"));
          post.setEntity(entity);
          post.setHeader("Authorization", "AUTHORIZATION");//�뽫AUTHORIZATION�滻Ϊ����API_KEY��API_SECRET�õ���ǩ����֤��
          long start_time = System.currentTimeMillis();
          HttpResponse response = httpclient.execute(post);
          long end_time = System.currentTimeMillis();
          if (response.getStatusLine().getStatusCode() == 200) {
              HttpEntity entitys = response.getEntity();
//              BufferedReader reader = new BufferedReader(
//                  new InputStreamReader(entitys.getContent()));
//              String line = reader.readLine();
        	  String responseString = EntityUtils.toString(entitys);
              System.out.println(responseString);
              System.out.println((end_time-start_time)+ "ms");
          }else{
              HttpEntity r_entity = response.getEntity();
              String responseString = EntityUtils.toString(r_entity);
              System.out.println("�������ǣ�"+response.getStatusLine().getStatusCode()+"  "+response.getStatusLine().getReasonPhrase());
              System.out.println("����ԭ���ǣ�"+responseString);
              //����Ҫ���ݳ����ԭ���жϴ�����Ϣ�����޸�
          }

          httpclient.getConnectionManager().shutdown();
    }
    
    @SuppressWarnings({ "resource" })
	public static void HttpClientPost_bankcard() throws ClientProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost(POST_URL01);
        FileBody fileBody = new FileBody(new File(filepath01));
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("image_file", fileBody);
        post.setEntity(entity);
        post.setHeader("Authorization", "AUTHORIZATION");//�뽫AUTHORIZATION�滻Ϊ����API_KEY��API_SECRET�õ���ǩ����֤��
        HttpResponse response = httpclient.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entitys = response.getEntity();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(entitys.getContent()));
            String line = reader.readLine();
            System.out.println(line);
        }else{
            HttpEntity r_entity = response.getEntity();
            String responseString = EntityUtils.toString(r_entity);
            System.out.println("�������ǣ�"+response.getStatusLine().getStatusCode()+"  "+response.getStatusLine().getReasonPhrase());
            System.out.println("����ԭ���ǣ�"+responseString);
            //����Ҫ���ݳ����ԭ���жϴ�����Ϣ�����޸�
        }

        httpclient.getConnectionManager().shutdown();
  }


  public static void main(String[] args) throws ClientProtocolException, IOException {
	  HttpClientPost_idcard();
  }
	

}
