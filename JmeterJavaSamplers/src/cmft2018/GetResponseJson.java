package cmft2018;

import java.util.List;

import javax.management.relation.Role;

import com.alibaba.fastjson.JSONObject;
import org.json.*;

public class GetResponseJson {
	
	/***
	 * 	fastjson 获取对应key的value
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void getResponseJson() throws Exception {
		
		
//		String response_data = prev.getResponseDataAsString();
		String response_data = "{\"code\":200,\"msg\":\"请求成功\",\"data\":{\"fhrsPbUserDto\":{\"id\":\"1\",\"name\":\"admin\"},\"privilegeList\":[{\"id\":\"10001\",\"privName\":\"首页\",\"areaCode\":\"\",\"privDesc\":\"首页\",\"privValue\":\"/index\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10007\",\"privName\":\"机构预览\",\"areaCode\":\"\",\"privDesc\":\"机构预览\",\"privValue\":\"/organPreview\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10002\",\"privName\":\"报表报告\",\"areaCode\":\"\",\"privDesc\":\"报表报告\",\"privValue\":\"/report\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10008\",\"privName\":\"关联交易\",\"areaCode\":\"\",\"privDesc\":\"关联交易\",\"privValue\":\"/connect\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10009\",\"privName\":\"重大事项\",\"areaCode\":\"\",\"privDesc\":\"重大事项\",\"privValue\":\"/important\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10003\",\"privName\":\"风险预警\",\"areaCode\":\"\",\"privDesc\":\"风险预警\",\"privValue\":\"/hints\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10005\",\"privName\":\"权限管理\",\"areaCode\":\"\",\"privDesc\":\"权限管理\",\"privValue\":\"/manage\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]}],\"roleList\":[{\"id\":\"486580540946776064\",\"roleName\":\"系统管理员\"}],\"privilegeLevelArea\":{\"privilegeLevel\":0,\"areaCode\":null},\"organization\":{\"id\":\"1\",\"orgName\":\"央行\",\"orgDesc\":null,\"orgType\":null,\"parentId\":null,\"province\":null,\"city\":null,\"region\":null,\"addressDetail\":null,\"createBy\":null,\"createTime\":null,\"updateBy\":null,\"updateTime\":null},\"department\":null}}";
		
		// 嵌套json处理
		JSONObject jsonObject = JSONObject.parseObject(response_data);
		JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.get("data").toString());
		
		Object roles = jsonObject1.getJSONArray("roleList");
		// 将jsonArray字符串转换成List集合
		List rolelist = JSONObject.parseArray(roles.toString());
		
		// 方法等价   得到rolelist
//		String roles = jsonObject1.get("roleList").toString();
//		List rolelist = JSONObject.parseArray(roles);	
		
		System.out.println(rolelist.get(0));

//		String id = (String) ((JSONObject) rolelist.get(0)).get("id");
		JSONObject jsonId = JSONObject.parseObject(rolelist.get(0).toString());
		String id = jsonId.get("id").toString();
		System.out.println(id);
		
	}
	
	/***	org.json取对应key的value
	 * 	fastjson 获取对应key的value
	 * @throws JSONException 
	 */
	public static void getValue() throws JSONException{
		
//		String response_data = prev.getResponseDataAsString();
		String response_data = "{\"code\":200,\"msg\":\"请求成功\",\"data\":{\"fhrsPbUserDto\":{\"id\":\"1\",\"name\":\"admin\"},\"privilegeList\":[{\"id\":\"10001\",\"privName\":\"首页\",\"areaCode\":\"\",\"privDesc\":\"首页\",\"privValue\":\"/index\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10007\",\"privName\":\"机构预览\",\"areaCode\":\"\",\"privDesc\":\"机构预览\",\"privValue\":\"/organPreview\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10002\",\"privName\":\"报表报告\",\"areaCode\":\"\",\"privDesc\":\"报表报告\",\"privValue\":\"/report\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10008\",\"privName\":\"关联交易\",\"areaCode\":\"\",\"privDesc\":\"关联交易\",\"privValue\":\"/connect\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10009\",\"privName\":\"重大事项\",\"areaCode\":\"\",\"privDesc\":\"重大事项\",\"privValue\":\"/important\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10003\",\"privName\":\"风险预警\",\"areaCode\":\"\",\"privDesc\":\"风险预警\",\"privValue\":\"/hints\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]},{\"id\":\"10005\",\"privName\":\"权限管理\",\"areaCode\":\"\",\"privDesc\":\"权限管理\",\"privValue\":\"/manage\",\"parentId\":\"0\",\"specialAreaFlag\":0,\"childList\":[]}],\"roleList\":[{\"id\":\"486580540946776064\",\"roleName\":\"系统管理员\"}],\"privilegeLevelArea\":{\"privilegeLevel\":0,\"areaCode\":null},\"organization\":{\"id\":\"1\",\"orgName\":\"央行\",\"orgDesc\":null,\"orgType\":null,\"parentId\":null,\"province\":null,\"city\":null,\"region\":null,\"addressDetail\":null,\"createBy\":null,\"createTime\":null,\"updateBy\":null,\"updateTime\":null},\"department\":null}}";
		
		// 嵌套json处理
		org.json.JSONObject data_obj = new org.json.JSONObject(response_data);
		org.json.JSONObject jsonObject1 = new org.json.JSONObject(data_obj.get("data").toString());
		org.json.JSONArray rolelist = jsonObject1.getJSONArray("roleList");
		
		System.out.println(rolelist);
		
		for(int i=0;i<rolelist.length();i++){
			org.json.JSONObject role_obj = new org.json.JSONObject(rolelist.get(i).toString());
		    String roleName = role_obj.get("roleName").toString();
		    String id = role_obj.get("id").toString();
		    System.out.println(roleName+"\n"+id);
		}
		
	}

	public static String getType(Object o) {
		return o.getClass().toString();
	}

	
	public static void getCode() {
        //验证码
        int Code=0;
        String result_code = "Y";

		if("Y".equals(result_code.toString())){
			Code = 111111;
		}else{
			Code = 888888;
		}
    
//        vars.put("Code",Code) ;
		System.out.println(Code);
	}


	public static void main(String[] args) throws Exception {
		
//		getResponseJson();
		getValue();
		
	}
		

}
