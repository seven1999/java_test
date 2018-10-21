import java.util.ArrayList;
import java.util.List;

public class test11 {
	
	public List<Integer> getNum(){
		
		List<Integer> l=new ArrayList<Integer>();
		int up = 10000;
		for (int i=0;i<=up;i++){
			
			if((i+1)%3==0&(i+2)%5==0&(i+4)%7==0&(i+1)%9==0&(i+9)%13==0){
				
				l.add(i);
				System.out.println(i);	
			}	
		}
		return l;
		
	}
	
	// 十进制转二进制
	public static int getBinary(int a){
		
		int remainder ;		//定义一个变量用于存储余数
		int sum=0;			//定义一个变量用于存放和
		int k=1;			//定义一个变量控制位数
		
		while(a!=0){
			
			//取余
			remainder = a%2;
			//求商
			a /=2;
			sum +=remainder*k;
			k*=10;
		}
		 System.out.println("10进制的"+a+"转换为2进制结果为：" + sum );
		 return sum;
	}
	
	// 方法2
	public static void DecimalTobinary(int n){
	     String str = "";
	     while(n!=0){
	         str = n%2+str;
	         n = n/2;
	         System.out.println(str);
	     }
	     System.out.println(str);
	}
	
	 //二进制转十进制
	 public static int BinaryToDecimal(int binaryNumber){
		  
		    int decimal = 0;
		    int p = 0;
		    while(true){
		      if(binaryNumber == 0){
		        break;
		      } else {
		    	  String s = binaryNumber+"";
		    	  System.out.println(s);
		          int temp = binaryNumber%10;			//二进制对10取余不是0就是1
		          decimal += temp*Math.pow(2, p);		
		          binaryNumber = binaryNumber/10;
		          p++;
		       }
		    }
		    System.out.println(decimal);
		    return decimal;
		  }
	
	public static void main(String[] args) {
		
//		new test11().getNum();
//		getBinary(25);
//		DecimalTobinary(25);
		BinaryToDecimal(110);
//		System.out.println(0000110%10);
		System.out.println(Integer.valueOf("0110",2).toString());
		System.out.println(Integer.toBinaryString(6));
		
		
//		test11 t1 = new test11();
//		test11 t2 = new test11();
		
//		Singleton sl1 = Singleton.getInstance();
//		Singleton sl2 = Singleton.getInstance();
//		
//		System.out.println(sl1+"  "+sl2);
//		System.out.println(t1+"  "+t2);
//		sl1.getName("K:");
//		sl1.getName("O:");

	}
}
