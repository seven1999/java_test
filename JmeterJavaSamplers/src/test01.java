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
 
  
        areaCode.put("������", 110000);
        areaCode.put("��Ͻ��", 110100);
        areaCode.put("������", 110101);
        areaCode.put("������", 110102);
        areaCode.put("������", 110103);
        areaCode.put("������", 110104);
        areaCode.put("������", 110105);
        areaCode.put("��̨��", 110106);
        areaCode.put("ʯ��ɽ��", 110107);
        areaCode.put("�������", 210905);
        areaCode.put("ϸ����", 210911);
        areaCode.put("������", 210922);
        areaCode.put("������", 211000);
        areaCode.put("��Ͻ��", 211001);
        areaCode.put("������", 211002);
        areaCode.put("��ʥ��", 211003);
        areaCode.put("��ΰ��", 211004);
        areaCode.put("�±���", 320411);
        areaCode.put("�����", 320412);
        areaCode.put("������", 320481);
        areaCode.put("��̳��", 320482);
        areaCode.put("������", 320500);
        areaCode.put("��Ͻ��", 320501);
        areaCode.put("�ױ���", 410600);
        areaCode.put("��Ͻ��", 410601);
        areaCode.put("��ɽ��", 410602);
        areaCode.put("ɽ����", 410603);
        areaCode.put("俱���", 410611);
        areaCode.put("������", 410621);
        areaCode.put("信���", 410622);
        areaCode.put("������", 410700);
        areaCode.put("��׽���", 510113);
        areaCode.put("�¶���", 510114);
        areaCode.put("�½���", 510115);
        areaCode.put("������", 510121);
        areaCode.put("˫����", 510122);
        areaCode.put("ۯ����", 510124);
        areaCode.put("������", 510129);
        areaCode.put("�ѽ���", 510131);
        areaCode.put("�½���", 510132);
        areaCode.put("Ǭ����", 610424);
        areaCode.put("��Ȫ��", 610425);
        areaCode.put("������", 610426);
        areaCode.put("����", 610427);
        areaCode.put("������", 610428);
        areaCode.put("Ѯ����", 610429);
        areaCode.put("������", 610430);
        areaCode.put("�书��", 610431);
        areaCode.put("��ƽ��", 610481);
        areaCode.put("μ����", 610500);
        
        //������
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
        //����
        String randomBirthday="";
        Calendar birthday = Calendar.getInstance();

        birthday.set(Calendar.YEAR, (int) (Math.random() * 35) + 1960);		//��֤����18�꣬С��60��
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

      //�����
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
        
        //�Ա�	��-1��Ů-2
        int sex=0;
        if (Integer.valueOf(randomCode) % 2==0){
        	sex = 2;
        }else{
        	sex = 1;
        }
//        System.out.println(sex);
        
        generater.append(randomCode);
        //��֤��
        char[]  chars= generater.toString().toCharArray();
        int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        // ������Ů
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
////			//���� [1,10)�����
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
				System.out.println("������ͬ�����֤��"+list.get(j));
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
