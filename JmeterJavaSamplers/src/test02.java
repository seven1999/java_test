import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test02 {
	
	public String getName(){
		
		   String[] a3 = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何",
				"吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜"};
			String[] a1 = {"玉", "明", "龙", "芳", "军", "玲", "英", "雷", "昊", "然", "明", "杰", "诚", "立", "轩", "辉", "峻", "熙", "弘", "文", "泰",
				"宁", "天", "佑", "同", "巍", "奕", "伟", "祺", "温", "文", "虹", "向", "笛","请","问","而","予","以","推","哦","欧","佩","克","京","汉","股","份","都","是","撒","爱","车"};
			String[] a2 = {"", "立", "国", "哲", "彦", "振", "海", "正", "志", "子", "晋", "自", "怡", "德", "赫", "君", "平", "永", "贞", "咏", "德",
				"宇", "寰", "雨", "泽", "玉", "韵", "越", "彬", "蕴", "和","请","问","而","予","以","推","哦","欧","佩","克","京","汉","股","份","都","是","撒","爱","车"};

					String a4 = "";
					int hightPos, lowPos; // 定义高低位
					Random random = new Random();
					hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
					lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
					byte[] b = new byte[2];
					b[0] = (new Integer(hightPos).byteValue());
					b[1] = (new Integer(lowPos).byteValue());
					try {
						a4 = new String(b, "GBk"); // 转成中文
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
