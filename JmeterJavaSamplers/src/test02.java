import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test02 {
	
	public String getName(){
		
		   String[] a3 = {"��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��"};
			String[] a1 = {"��", "��", "��", "��", "��", "��", "Ӣ", "��", "�", "Ȼ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "̩",
				"��", "��", "��", "ͬ", "Ρ", "��", "ΰ", "��", "��", "��", "��", "��", "��","��","��","��","��","��","��","Ŷ","ŷ","��","��","��","��","��","��","��","��","��","��","��"};
			String[] a2 = {"", "��", "��", "��", "��", "��", "��", "��", "־", "��", "��", "��", "��", "��", "��", "��", "ƽ", "��", "��", "ӽ", "��",
				"��", "�", "��", "��", "��", "��", "Խ", "��", "��", "��","��","��","��","��","��","��","Ŷ","ŷ","��","��","��","��","��","��","��","��","��","��","��"};

					String a4 = "";
					int hightPos, lowPos; // ����ߵ�λ
					Random random = new Random();
					hightPos = (176 + Math.abs(random.nextInt(39))); // ��ȡ��λֵ
					lowPos = (161 + Math.abs(random.nextInt(93))); // ��ȡ��λֵ
					byte[] b = new byte[2];
					b[0] = (new Integer(hightPos).byteValue());
					b[1] = (new Integer(lowPos).byteValue());
					try {
						a4 = new String(b, "GBk"); // ת������
					} catch (UnsupportedEncodingException ex) {
						ex.printStackTrace();
					}

					int lenght1 = a1.length;
					int lenght2 = a2.length;
					int lenght3 = a3.length;
					String clientName = a4+a1[(int) (Math.random()*lenght1) ]+a2[(int) (Math.random()*lenght2) ]+a3[(int) (Math.random()*lenght3) ];
					
//					char a1 =(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
//					char a2 =(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
//					char a3 =(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
//					char a4 =(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
					
//					String clientName = String.valueOf(a1)+String.valueOf(a2)+String.valueOf(a3)+String.valueOf(a4);
					
//					System.out.println(clientName);
					return clientName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			List<String> list = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			
			for (int i=0;i<20000;i++){
				list.add(new test02().getName());
			}
			
			for(int j=0 ;j<list.size()-1;j++){
				
				if(list.get(j).equals(list.get(j+1))){
					System.out.println(list.get(j)+ "==============");
				}
			}

			System.out.println((char) (0x4e00 + (int) (Math.random() * (0x9fff - 0x4e00 + 1))));
//			System.out.println(0x9fff);
			
	        String mspNo ="A0000000001";
//	        mspNo = mspNo+	(int)((Math.random()*9+1)*10000); 
	        
			for (int i=0;i<50000;i++){
				
				list2.add(mspNo+(int)((Math.random()*9+1)*10000));
//				System.out.println(mspNo+(int)((Math.random()*9+1)*10000));
			}
			
			for(int j=0 ;j<list.size()-1;j++){
				
				if(list2.get(j).equals(list2.get(j+1))){
					System.out.println(list2.get(j)+ "==============");
				}
			}


	}


}
