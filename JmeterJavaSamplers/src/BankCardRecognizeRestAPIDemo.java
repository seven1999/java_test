

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BankCardRecognizeRestAPIDemo {

	public static void main(String[] args) {
//		BankCardRecognize(false);
		BankCardRecognize();
	}
	private static void BankCardRecognize(){
		try {
			String filepath = "C:/pic/003touxiang.jpg";//Recog file path
			System.out.println(filepath);
			File file = new File(filepath);
			String urlString = "http://10.62.0.252:8088/icr/recognize_id_card?crop_image=1&head_portrait=1&recognize_mode=1";
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			OutputStream out = con.getOutputStream();
			FileInputStream inputStream = new FileInputStream(file);
			byte[] data = new byte[2048];
			int len = 0;
			int sum = 0;
			while ((len = inputStream.read(data))!= -1) {
				out.write(data, 0, len);
				sum = len + sum;
			}
			System.out.println("upload size="+sum);
			out.flush();
			inputStream.close();
			out.close();
			
			int code = con.getResponseCode();
			System.out.println("code="+code+ " url="+url);
			if (code==200) {
				InputStream inputStream2 = con.getInputStream();
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				while ((len = inputStream2.read(data))!= -1) {
					bos.write(data, 0, len);					
				}
				inputStream2.close();
				String content = bos.toString();
				bos.close();
				System.out.println("result ="+content);		
			}
			con.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
