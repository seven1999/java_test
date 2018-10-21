package cmft2018;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jtest {
	
	
	public static void  getVaule(){
		
		int year=(int)( Math.random()*18+82);
		String birthday="19"+year+"-01-01";

		int amnt=(int)(Math.random()*7+3)*100000;
		long interval=0;
		try {
		interval = new Date().getTime()
		-new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1970-01-01 00:00:00").getTime();
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		String requestId="T"+new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
//		+String.format("%011d",(int)(Math.random()*999999));
//		requestId = requestId + "000000" + (int)(Math.random()*999999);
		requestId = requestId+String.format("%011d",(int)(Math.random()*999999));
		
		System.out.println("birthday:"+birthday+";  amnt:"+amnt+";  requestId:"+requestId);
		
		
	}
	
	public static void main(String[] args) {
		
		
//		getVaule();
		String message = "The wait operation timed out";
		int result = message.indexOf("The wait operation timed out");
		System.out.println(result);
		
	}

}
