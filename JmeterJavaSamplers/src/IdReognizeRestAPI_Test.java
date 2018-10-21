import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class IdReognizeRestAPI_Test implements JavaSamplerClient{
	
		private String ImageSrcFile;
	
	    // 设置传入的参数，可以设置多个，已设置的参数会显示到Jmeter的参数列表中
	    public Arguments getDefaultParameters() {  	
	        Arguments params = new Arguments();
	        params.addArgument("ImageSrcFile", "C:/pic/003touxiang.jpg");//设置参数，并赋予默认值0
	        return params;
	    }
	    
	   // 初始化方法，实际运行时每个线程仅执行一次，在测试方法运行前执行
	    public void setupTest(JavaSamplerContext arg0) {
	    	
	    	 SampleResult results = new SampleResult();
	    	 results = new SampleResult();
	     }
	    
	    
	    // 测试执行的循环体，根据线程数和循环次数的不同可执行多次
	    public SampleResult runTest(JavaSamplerContext arg0) {
	    	
	    	SampleResult results = new SampleResult();
	    	// 获取在Jmeter中设置的参数值
	    	ImageSrcFile = arg0.getParameter("ImageSrcFile"); 
	        results.sampleStart();// jmeter 开始统计响应时间标记
	        try {        	
	        	new IdReognizeRestAPIDemo();
				int code = IdReognizeRestAPIDemo.IdRecognize(ImageSrcFile);	
				if(code == 200){
					results.setSuccessful(true);
				}else {
					results.setSuccessful(false);
				}      
	        // 被测对象调用
	        } catch (Throwable e) {
	            results.setSuccessful(false);
	            e.printStackTrace();
	        } finally {
	            results.sampleEnd();// jmeter 结束统计响应时间标记
	        }
	        return results;
	    }


	    // 结束方法，实际运行时每个线程仅执行一次，在测试方法运行结束后执行
	    public void teardownTest(JavaSamplerContext arg0) {
	    }
	    
	    public static void main(String[] args) {
			
	    	Arguments params = new Arguments();
	    	params.addArgument("ImageSrcFile","C:/pic/003touxiang.jpg");
	    	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	    	IdReognizeRestAPI_Test test = new IdReognizeRestAPI_Test();
	    	for(int i=0;i<=10;i++){
		    	test.setupTest(arg0);
		    	test.runTest(arg0);
		    	test.teardownTest(arg0);
	    	}

		}
	

}
