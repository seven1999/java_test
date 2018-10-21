
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.activation.MimetypesFileTypeMap;

/**
 * java通过模拟post方式提交表单实现图片上传功能实例
 * 其他文件类型可以传入 contentType 实现
 * @author zdz8207
 * {@link http://www.cnblogs.com/zdz8207/}
 * @version 1.0
 */
public class HttpUploadFile {

    public static void main(String[] args) {
        testUploadImage();
    }
    
    /**
     * 测试上传png图片
     * 
     */
    public static void testUploadImage(){
        String url = "https://perf.dev.cmrh.com/RH_MSPSERVER/sales/apply/imageUploding.do?applyBarCode=&mspNo=A000000000178116";
        String fileName = "C:/Users/songq001/Pictures/Saved Pictures/timg.jpg";
        Map<String, String> textMap = new HashMap<String, String>();
        //可以设置多个input的name，value
        textMap.put("name", "testname");
        textMap.put("type", "2");
        //设置file的name，路径
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("upfile", fileName);
        String contentType = "";//image/png
        String ret = formUpload(url, textMap, fileMap,contentType);
        System.out.println(ret);
        //{"status":"0","message":"add succeed","baking_url":"group1\/M00\/00\/A8\/CgACJ1Zo-LuAN207AAQA3nlGY5k151.png"}
    }

    /**
     * 上传图片
     * @param urlStr
     * @param textMap
     * @param fileMap
     * @param contentType 没有传入文件类型默认采用application/octet-stream
     * contentType非空采用filename匹配默认的图片类型
     * @return 返回response数据
     */
    @SuppressWarnings("rawtypes")
    public static String formUpload(String urlStr, Map<String, String> textMap,
            Map<String, String> fileMap,String contentType) {
        String res = "";
        HttpURLConnection conn = null;
        // boundary就是request头和上传文件内容的分隔符
        String BOUNDARY = "---------------------------123821742118716"; 
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cookie", "JSESSIONID=714f77f7b20f9ab698ef1951ea0fabb1ccf57b5f~4064070C3EA009A9BF828B40871BFD8B; _rf_profile=\"63757272656e74556964:6c30303030303030303140636d72686167656e742e636f6d@70726f66696c65496e6974466c6167:37@70726f66696c65436667466c6167:30\"; RF_LOGIN_TIME=\"2017/11/20 16-51-41@2017/11/20 16-51-41\"; Hm_lvt_7c0e9c96a74719fdef5910598c47bac8=1510794009; Hm_lpvt_7c0e9c96a74719fdef5910598c47bac8=1510796980; sino=\"63757272656e7455736572:6c30303030303030303140636d72686167656e742e636f6d@726f6f7453657373696f6e4964:30326335393534652d363235352d346366372d623134312d646263393566623365393531@6c6f67696e54696d65:31353131313637393031393031@6c6f67696e41637469766554696d65:31353131313637393031393333@636c69656e744970:31302e3230302e31372e3938@6c6f67696e496e666f536967:30306532626566323538373062633637353436343563366330383530383165623561393361353932333232613632373664323231663662343433373735303737376130643661306537316333613730386433373331323533393361333734386535616130373736643564373338626536353337373262633232353837326264363031353132363463333238653832623436363264303665613463393864393435613038643261666539373362633734376332643862646366333334643162346165373136393433313464663566373266383834343335623933353430383039353763616531373230393930333936383636336432333039326561636565326531\"");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY)
                            .append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\""
                            + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }
            // file
            if (fileMap != null) {
                Iterator iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    
                    //没有传入文件类型，同时根据文件获取不到类型，默认采用application/octet-stream
                    contentType = new MimetypesFileTypeMap().getContentType(file);
                    //contentType非空采用filename匹配默认的图片类型
                    if(!"".equals(contentType)){
                        if (filename.endsWith(".png")) {
                            contentType = "image/png"; 
                        }else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".jpe")) {
                            contentType = "image/jpeg";
                        }else if (filename.endsWith(".gif")) {
                            contentType = "image/gif";
                        }else if (filename.endsWith(".ico")) {
                            contentType = "image/image/x-icon";
                        }
                    }
                    if (contentType == null || "".equals(contentType)) {
                        contentType = "application/octet-stream";
                    }
                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY)
                            .append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\""
                            + inputName + "\"; filename=\"" + filename
                            + "\"\r\n");
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = new DataInputStream(
                            new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }
}