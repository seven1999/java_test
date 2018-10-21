import java.net.URI;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.cmft.im.message.protobuf.MessageProtocol;

import demo.WebSocketC;

public class WebSocket_Jmeter_Test implements JavaSamplerClient{
	
		private String token;
		private String wsurl;
		private String SendMsg;
		private String setReceiverId;
		private String sessionId;
//		private String setMessageId;
	
	    // ���ô���Ĳ������������ö���������õĲ�������ʾ��Jmeter�Ĳ����б���
	    public Arguments getDefaultParameters() {  	
	        Arguments params = new Arguments();
	        params.addArgument("token", "");//���ò�����������Ĭ��ֵ
	        params.addArgument("wsurl", "ws://10.200.47.36:28080/im-ws-server/v1/websocket/connector?token="+token+"&rcvSeq=10");//���ò�����������Ĭ��ֵ
	        params.addArgument("SendMsg", "С��������������");//���ò�����������Ĭ��ֵ
	        params.addArgument("setReceiverId", "ck");//���ò�����������Ĭ��ֵ
	        params.addArgument("sessionId", "10");//���ò�����������Ĭ��ֵ
//	        params.addArgument("setMessageId", "00001");//���ò�����������Ĭ��ֵ
	        return params;
	    }
	    
	   // ��ʼ��������ʵ������ʱÿ���߳̽�ִ��һ�Σ��ڲ��Է�������ǰִ��
	    public void setupTest(JavaSamplerContext arg0) {
	    	
	    	 SampleResult results = new SampleResult();
	    	 results = new SampleResult();
	     }
	    
	    
	    // ����ִ�е�ѭ���壬�����߳�����ѭ�������Ĳ�ͬ��ִ�ж��
	    public SampleResult runTest(JavaSamplerContext arg0) {
	    	
	    	// ��ȡ��Jmeter�����õĲ���ֵ
	    	token = arg0.getParameter("token"); 
	    	wsurl = arg0.getParameter("wsurl"); 
	    	SendMsg = arg0.getParameter("SendMsg"); 
	    	setReceiverId = arg0.getParameter("setReceiverId"); 
	    	sessionId = arg0.getParameter("sessionId"); 
//	    	setMessageId = arg0.getParameter("setMessageId"); 
//	    	long msgId = Long.parseLong(setMessageId);
	    	long sesionId = Long.parseLong(sessionId);
	    	
	    	SampleResult results = new SampleResult();
	        results.sampleStart();// jmeter ��ʼͳ����Ӧʱ����
	        try {        	

	        	WebSocketC websocket = new WebSocketC(new URI(wsurl));
	    		if(!websocket.connectBlocking()){
	    			System.err.println( "Could not connect to the server." );
	    			results.setSuccessful(false);
	    		}
	    		else {
		    		System.out.println( "websocket:"+websocket+"======"+websocket.isOpen() );
		    		MessageProtocol.Message.Builder builder = MessageProtocol.Message.newBuilder();		
		    		//builder.setMessageType(MessageProtocol.MessageType.P2P_MESSAGE);
		    		builder.setMessageType(MessageProtocol.MessageType.P2G_MESSAGE);
		    		builder.setReceiverId(setReceiverId);
		    		
		    		builder.setSessionId(sesionId);
		    		builder.setMessageId(System.currentTimeMillis());
		    		builder.setContentType(MessageProtocol.ContentType.TEXT_MESSAGE).setTextContent(SendMsg+"--"+System.currentTimeMillis());
		    		MessageProtocol.Message ackMsg = builder.build();
//		    		System.out.println(ackMsg.toByteArray() );
		    		websocket.send(ackMsg.toByteArray());

		    		results.setSuccessful(true);
				}
	    		
//				if(code == 200){
//					results.setSuccessful(true);
//				}else {
//					results.setSuccessful(false);
//				}      
	    		
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
			String token = "9561708c-e9d6-474d-85d5-c9fc431a53ce";		//�����˵�token
	    	Arguments params = new Arguments();
	        params.addArgument("token", "");//���ò�����������Ĭ��ֵ
	        params.addArgument("wsurl", "ws://10.62.14.127:28080/coco-ws-server/v1/websocket/connector?token="+token+"&rcvSeq=10");//���ò�����������Ĭ��ֵ
	        params.addArgument("SendMsg", "������Ϣ--Test");		//���ò�����������Ĭ��ֵ
	        params.addArgument("setReceiverId", "1");			//��Ϣ����- 1�����Է�����-���У��� ��ֵ������û��������Ƿ�����Ӧ�û���sm��������lwc��½��
	        params.addArgument("sessionId", "10");			
//	        params.addArgument("setMessageId", "00001");		//���ò�����������Ĭ��ֵ
//	        System.out.println(params);
	    	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	    	WebSocket_Jmeter_Test test = new WebSocket_Jmeter_Test();

	    	test.setupTest(arg0);
	    	test.runTest(arg0);
	    	test.teardownTest(arg0);

		}
	

}
