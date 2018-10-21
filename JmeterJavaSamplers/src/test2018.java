import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class test2018 {
	
	
	public static void main(String[] args) throws IOException {
		
		final String ImageSrcFile = "C:/pic/1.jpg";
		File file = new File(ImageSrcFile);
		
		String urlString = "https://www.baidu.com/";
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
			System.out.println(len);
		}
		System.out.println("upload size="+sum);
		out.flush();
		inputStream.close();
		out.close();
		
	}

}
