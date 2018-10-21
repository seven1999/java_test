import com.mongodb.util.JSON;

public class Singleton {
	
	private Singleton(){
		
	}
	
	private static Singleton sl=null;
	
	public static Singleton getInstance(){
		
		if(sl==null){
			
			sl = new Singleton();
			System.out.println("1");
		}else{
			System.out.println("2");
		}
		return sl;
	}
	
	public void getName(String name){
		
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		
		Singleton sl1 = Singleton.getInstance();
		Singleton sl2 = new Singleton();				//在其他类引用就会报错
		sl1.getName("K:");
		sl2.getName("O:");
		
		String json = "{'a':'b', 'c':1 }";
		System.out.println(json);
	}

}
