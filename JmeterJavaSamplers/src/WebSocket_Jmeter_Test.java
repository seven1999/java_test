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
	
	    // 设置传入的参数，可以设置多个，已设置的参数会显示到Jmeter的参数列表中
	    public Arguments getDefaultParameters() {  	
	        Arguments params = new Arguments();
	        params.addArgument("token", "");//设置参数，并赋予默认值
	        params.addArgument("wsurl", "ws://10.200.47.36:28080/im-ws-server/v1/websocket/connector?token="+token+"&rcvSeq=10");//设置参数，并赋予默认值
	        params.addArgument("SendMsg", "小哈哈哈哈哈哈哈");//设置参数，并赋予默认值
	        params.addArgument("setReceiverId", "ck");//设置参数，并赋予默认值
	        params.addArgument("sessionId", "10");//设置参数，并赋予默认值
//	        params.addArgument("setMessageId", "00001");//设置参数，并赋予默认值
	        return params;
	    }
	    
	   // 初始化方法，实际运行时每个线程仅执行一次，在测试方法运行前执行
	    public void setupTest(JavaSamplerContext arg0) {
	    	
	    	 SampleResult results = new SampleResult();
	    	 results = new SampleResult();
	     }
	    
	    
	    // 测试执行的循环体，根据线程数和循环次数的不同可执行多次
	    public SampleResult runTest(JavaSamplerContext arg0) {
	    	
	    	// 获取在Jmeter中设置的参数值
	    	token = arg0.getParameter("token"); 
	    	wsurl = arg0.getParameter("wsurl"); 
	    	SendMsg = arg0.getParameter("SendMsg"); 
	    	setReceiverId = arg0.getParameter("setReceiverId"); 
	    	sessionId = arg0.getParameter("sessionId"); 
//	    	setMessageId = arg0.getParameter("setMessageId"); 
//	    	long msgId = Long.parseLong(setMessageId);
	    	long sesionId = Long.parseLong(sessionId);
	    	
	    	SampleResult results = new SampleResult();
	        results.sampleStart();// jmeter 开始统计响应时间标记
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
			String token = "9561708c-e9d6-474d-85d5-c9fc431a53ce";		//发送人的token
	    	Arguments params = new Arguments();
	        params.addArgument("token", "");//设置参数，并赋予默认值
	        params.addArgument("wsurl", "ws://10.62.14.127:28080/coco-ws-server/v1/websocket/connector?token="+token+"&rcvSeq=10");//设置参数，并赋予默认值
	        params.addArgument("SendMsg", "测试消息--Test");		//设置参数，并赋予默认值
	        params.addArgument("setReceiverId", "1");			//消息接收- 1：测试服务器-所有；（ 赋值具体的用户名称则是发给对应用户）sm：苏敏；lwc：陆万春
	        params.addArgument("sessionId", "10");			
//	        params.addArgument("setMessageId", "00001");		//设置参数，并赋予默认值
//	        System.out.println(params);
	    	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	    	WebSocket_Jmeter_Test test = new WebSocket_Jmeter_Test();

	    	test.setupTest(arg0);
	    	test.runTest(arg0);
	    	test.teardownTest(arg0);

		}
	

}
