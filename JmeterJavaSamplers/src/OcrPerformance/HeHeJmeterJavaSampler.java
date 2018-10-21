package OcrPerformance;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class HeHeJmeterJavaSampler implements JavaSamplerClient{
	
		private String ImageSrcFile;
		private String http_url;
	
	    // ���ô���Ĳ������������ö���������õĲ�������ʾ��Jmeter�Ĳ����б���
	    public Arguments getDefaultParameters() {  	
	        Arguments params = new Arguments();
	        params.addArgument("ImageSrcFile", "C:/pic/02.jpg");//���ò�����������Ĭ��ֵ
	        params.addArgument("http_url", "http://100.69.216.49:3308/icr/recognize_hukoubu?owner=1");//���ò�����������Ĭ��ֵ
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
	    	http_url = arg0.getParameter("http_url"); 
	        results.sampleStart();// jmeter ��ʼͳ����Ӧʱ����
	        try {        	
	        	new HeHeOrcAPI();
				int code = HeHeOrcAPI.IdRecognize(ImageSrcFile, http_url);	
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
	    	params.addArgument("ImageSrcFile","C:/pic/02.jpg");
	    	params.addArgument("http_url","http://100.69.216.49:3308/icr/recognize_hukoubu?owner=1");
	    	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	    	HeHeJmeterJavaSampler test = new HeHeJmeterJavaSampler();
	    	for(int i=0;i<=10;i++){
		    	test.setupTest(arg0);
		    	test.runTest(arg0);
		    	test.teardownTest(arg0);
	    	}

		}
	

}
