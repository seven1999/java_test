import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test01 {

	
	public StringBuilder getCardId(){
		
		StringBuilder generater = new StringBuilder();
        Map areaCode = new HashMap();
 
  
        areaCode.put("北京市", 110000);
        areaCode.put("市辖区", 110100);
        areaCode.put("东城区", 110101);
        areaCode.put("西城区", 110102);
        areaCode.put("崇文区", 110103);
        areaCode.put("宣武区", 110104);
        areaCode.put("朝阳区", 110105);
        areaCode.put("丰台区", 110106);
        areaCode.put("石景山区", 110107);
        areaCode.put("清河门区", 210905);
        areaCode.put("细河区", 210911);
        areaCode.put("彰武县", 210922);
        areaCode.put("辽阳市", 211000);
        areaCode.put("市辖区", 211001);
        areaCode.put("白塔区", 211002);
        areaCode.put("文圣区", 211003);
        areaCode.put("宏伟区", 211004);
        areaCode.put("新北区", 320411);
        areaCode.put("武进区", 320412);
        areaCode.put("溧阳市", 320481);
        areaCode.put("金坛市", 320482);
        areaCode.put("苏州市", 320500);
        areaCode.put("市辖区", 320501);
        areaCode.put("鹤壁市", 410600);
        areaCode.put("市辖区", 410601);
        areaCode.put("鹤山区", 410602);
        areaCode.put("山城区", 410603);
        areaCode.put("淇滨区", 410611);
        areaCode.put("浚　县", 410621);
        areaCode.put("淇　县", 410622);
        areaCode.put("新乡市", 410700);
        areaCode.put("青白江区", 510113);
        areaCode.put("新都区", 510114);
        areaCode.put("温江区", 510115);
        areaCode.put("金堂县", 510121);
        areaCode.put("双流县", 510122);
        areaCode.put("郫　县", 510124);
        areaCode.put("大邑县", 510129);
        areaCode.put("蒲江县", 510131);
        areaCode.put("新津县", 510132);
        areaCode.put("乾　县", 610424);
        areaCode.put("礼泉县", 610425);
        areaCode.put("永寿县", 610426);
        areaCode.put("彬　县", 610427);
        areaCode.put("长武县", 610428);
        areaCode.put("旬邑县", 610429);
        areaCode.put("淳化县", 610430);
        areaCode.put("武功县", 610431);
        areaCode.put("兴平市", 610481);
        areaCode.put("渭南市", 610500);
        
        //地区号
        String  randomAreaCode="";
        int index = (int) (Math.random() * areaCode.size()+1);
         Collection values = areaCode.values();
         Iterator it = values.iterator();
        int i = 0;
        int code = 0;
        while (i < index && it.hasNext()) {
            i++;
            randomAreaCode = it.next().toString();
        }
        generater.append(randomAreaCode);
        //生日
        String randomBirthday="";
        Calendar birthday = Calendar.getInstance();

        birthday.set(Calendar.YEAR, (int) (Math.random() * 35) + 1960);		//保证大于18岁，小于60岁
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));
        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        builder.append(date);
        randomBirthday= builder.toString();
//         String randomBirthday = "19780729";
        
        builder.insert(4, "-");
        builder.insert(7, "-");
        String Birthday = builder.toString();
        System.out.println(Birthday);
         generater.append(randomBirthday);

      //随机码
      String randomCode="";
       code = (int) (Math.random() * 1000);
//	   int code = (int) (Math.random() * 1000);
        if (code < 10) {
            randomCode= "00" + code;
        } else if (code < 100) {
            randomCode= "0" + code;
        } else {
            randomCode= "" + code;
        }
        
        //性别	男-1；女-2
        int sex=0;
        if (Integer.valueOf(randomCode) % 2==0){
        	sex = 2;
        }else{
        	sex = 1;
        }
//        System.out.println(sex);
        
        generater.append(randomCode);
        //验证码
        char[]  chars= generater.toString().toCharArray();
        int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        // 不分男女
        char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        
        int[] n = new int[17];
        int result = 0;
//        System.out.println(generater.toString());
        for (int k = 0; k < n.length; k++) {
            n[k] = Integer.parseInt(chars[k] + "");
//            System.out.print(n[k]);  
        }
//        System.out.println();
        for (int j = 0; j < n.length; j++) {
            result += c[j] * n[j];
        }
        char validateCode = r[result % 11];

        generater.append(validateCode);  
        

        return generater;
        
	}
	public static void main(String[] args) {
		
//			String mspNo ="A000000009";
//
//			System.out.println((int)((Math.random()*9+1)*100000));
////			//返回 [1,10)随机数
////			System.out.println(Math.random()*9+1);
//			mspNo = mspNo+	(int)((Math.random()*9+1)*100000);
//			System.out.println(mspNo);
			
		List<StringBuilder> list = new ArrayList<>();
		
		for (int i=0;i<10000;i++){
//			StringBuilder cardID = new test01().getCardId();
			System.out.println(new test01().getCardId());
			list.add(new test01().getCardId());
			
		}
		
		for(int j=0;j<list.size()-1;j++){
			
			if(list.get(j).equals(list.get(j+1))){
				System.out.println("存在相同的身份证："+list.get(j));
			}
		}
		
		int x=1;
		int y=2;
		int z=3;
		
		y += --z/x++;
//		System.out.println(--z);
//		System.out.println(x++);
		System.out.println(y);
			
	}

}
