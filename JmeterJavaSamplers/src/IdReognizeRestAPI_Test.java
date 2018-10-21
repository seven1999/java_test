import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class IdReognizeRestAPI_Test implements JavaSamplerClient{
	
		private String ImageSrcFile;
	
	    // ���ô���Ĳ������������ö���������õĲ�������ʾ��Jmeter�Ĳ����б���
	    public Arguments getDefaultParameters() {  	
	        Arguments params = new Arguments();
	        params.addArgument("ImageSrcFile", "C:/pic/003touxiang.jpg");//���ò�����������Ĭ��ֵ0
	        return params;
	    }
	    
	   // ��ʼ��������ʵ������ʱÿ���߳̽�ִ��һ�Σ��ڲ��Է�������ǰִ��
	    public void setupTest(JavaSamplerContext arg0) {
	    	
	    	 SampleResult results = new SampleResult();
	    	 results = new SampleResult();
	     }
	    
	    
	    // ����ִ�е�ѭ���壬�����߳�����ѭ�������Ĳ�ͬ��ִ�ж��
	    public SampleResult runTest(JavaSamplerContext arg0) {
	    	
	    	SampleResult results = new SampleResult();
	    	// ��ȡ��Jmeter�����õĲ���ֵ
	    	ImageSrcFile = arg0.getParameter("ImageSrcFile"); 
	        results.sampleStart();// jmeter ��ʼͳ����Ӧʱ����
	        try {        	
	        	new IdReognizeRestAPIDemo();
				int code = IdReognizeRestAPIDemo.IdRecognize(ImageSrcFile);	
				if(code == 200){
					results.setSuccessful(true);
				}else {
					results.setSuccessful(false);
				}      
	        // ����������
	        } catch (Throwable e) {
	            results.setSuccessful(false);
	            e.printStackTrace();
	        } finally {
	            results.sampleEnd();// jmeter ����ͳ����Ӧʱ����
	        }
	        return results;
	    }


	    // ����������ʵ������ʱÿ���߳̽�ִ��һ�Σ��ڲ��Է������н�����ִ��
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
