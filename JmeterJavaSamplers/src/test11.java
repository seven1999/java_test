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
	
	// ʮ����ת������
	public static int getBinary(int a){
		
		int remainder ;		//����һ���������ڴ洢����
		int sum=0;			//����һ���������ڴ�ź�
		int k=1;			//����һ����������λ��
		
		while(a!=0){
			
			//ȡ��
			remainder = a%2;
			//����
			a /=2;
			sum +=remainder*k;
			k*=10;
		}
		 System.out.println("10���Ƶ�"+a+"ת��Ϊ2���ƽ��Ϊ��" + sum );
		 return sum;
	}
	
	// ����2
	public static void DecimalTobinary(int n){
	     String str = "";
	     while(n!=0){
	         str = n%2+str;
	         n = n/2;
	         System.out.println(str);
	     }
	     System.out.println(str);
	}
	
	 //������תʮ����
	 public static int BinaryToDecimal(int binaryNumber){
		  
		    int decimal = 0;
		    int p = 0;
		    while(true){
		      if(binaryNumber == 0){
		        break;
		      } else {
		    	  String s = binaryNumber+"";
		    	  System.out.println(s);
		          int temp = binaryNumber%10;			//�����ƶ�10ȡ�಻��0����1
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
