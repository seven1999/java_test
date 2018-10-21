package cmft2018;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map遍历方法
 * @author songq001
 *
 */

public class MapPractice {
	
	//最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用
	public static void MapTest(){
		
		// 创建一个map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "系统管理员");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		//遍历map
		for(Map.Entry<String, String> entry : paramMap.entrySet()){
			
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("key:" + key + "\t" + "value:" + value);
		}
		
	}
	
	//通过键找值遍历（效率低）
	public static void MapTest02(){
		
		// 创建一个map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "系统管理员");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		//遍历map
		for(String key:paramMap.keySet()){
			
			String value = paramMap.get(key);
			System.out.println("key:" + key + "\t" + "value:" + value);
		}
	}
	
	//在for-each循环中遍历keys或values。
	public static void MapTest03(){
		// 创建一个map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "系统管理员");
		paramMap.put("id", "01");
		paramMap.put("name", "admin");
		paramMap.put("password", "123456");
		
		//遍历key
		for(String key:paramMap.keySet()){
			System.out.println("key:" + key);
		}
		//遍历values
		for(String value:paramMap.values()){
			System.out.println("value:" + value);
		}
		
	}
	
	//使用Iterator遍历
	public static void MapTest04(){
		// 创建一个map
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("role", "系统管理员");
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
