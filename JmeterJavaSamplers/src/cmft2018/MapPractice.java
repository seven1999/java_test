package cmft2018;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map��������
 * @author songq001
 *
 */

public class MapPractice {
	
	//����Ĳ����ڴ���������Ҳ�����ȡ�ı�����ʽ���ڼ�ֵ����Ҫʱʹ��
	public static void MapTest(){
		
		// ����һ��map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "ϵͳ����Ա");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		//����map
		for(Map.Entry<String, String> entry : paramMap.entrySet()){
			
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("key:" + key + "\t" + "value:" + value);
		}
		
	}
	
	//ͨ������ֵ������Ч�ʵͣ�
	public static void MapTest02(){
		
		// ����һ��map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "ϵͳ����Ա");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		//����map
		for(String key:paramMap.keySet()){
			
			String value = paramMap.get(key);
			System.out.println("key:" + key + "\t" + "value:" + value);
		}
	}
	
	//��for-eachѭ���б���keys��values��
	public static void MapTest03(){
		// ����һ��map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "ϵͳ����Ա");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		//����key
		for(String key:paramMap.keySet()){
			System.out.println("key:" + key);
		}
		//����values
		for(String value:paramMap.values()){
			System.out.println("value:" + value);
		}
		
	}
	
	//ʹ��Iterator����
	public static void MapTest04(){
		// ����һ��map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "ϵͳ����Ա");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:" + key + "\t" + "value:" + value);		
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("======MapTest()=====");
		MapTest();
		System.out.println("======MapTest02()=====");
		MapTest02();
		System.out.println("======MapTest03()=====");
		MapTest03();
		System.out.println("======MapTest04()=====");
		MapTest04();
	}

}
