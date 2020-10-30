package com.fish.cloud.common.util.wxPay;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.security.MessageDigest;

@Slf4j
@Component
public class WechatUtil {

    @Autowired
    private PaymentUtil paymentUtil;

    public String getSign(WechatPayRequest payRequest) {
        String signTemp = "appid=" + payRequest.getAppid() + "&attach=" + payRequest.getAttach() + "&body="
                + payRequest.getBody() + "&mch_id=" + payRequest.getMch_id() + "&nonce_str=" + payRequest.getNonce_str()
                + "&notify_url=" + payRequest.getNotify_url() + "&openid=" + payRequest.getOpenid() + "&out_trade_no="
                + payRequest.getOut_trade_no() + "&product_id=" + payRequest.getProduct_id() + "&spbill_create_ip="
                + payRequest.getSpbill_create_ip() + "&total_fee=" + payRequest.getTotal_fee() + "&trade_type="
                + payRequest.getTrade_type() + "&key=" + paymentUtil.getWechatApiKey();
        String sign = encodeMd5(signTemp).toUpperCase();
        return sign;
    }

    public String toXML(Object request) {
        XStream xstreamReq = new XStream(new XppDriver());
        xstreamReq.alias("xml", request.getClass());
        String requestXML = xstreamReq.toXML(request).replace("\n", "").replace("__", "_");
        return requestXML;
    }

    public Object fromXML2WechatResponse(Class responseClass, String responseXML) {
        XStream xstreamRes = new XStream(new XppDriver() {
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // ����CDATA���
                    boolean cdata = true;

                    @SuppressWarnings("rawtypes")
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
        xstreamRes.alias("xml", responseClass);
//		WechatPayResponse payResponse = (WechatPayResponse) xstreamRes.fromXML(responseXML);
        Object response = xstreamRes.fromXML(responseXML);
        return response;
    }

    public Object fromXML2WechatResult(Class resultClass,String responseXML, String root) {
        XStream xstreamRes = new XStream(new XppDriver() {
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // ����CDATA���
                    boolean cdata = true;

                    @SuppressWarnings("rawtypes")
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
        xstreamRes.alias(root, resultClass);
//		WechatPayResult payResponse = (WechatPayResult) xstreamRes.fromXML(responseXML);
        Object response =  xstreamRes.fromXML(responseXML);
        return response;
    }

    public String postWechatUnifiedOrder(String requestXML) throws Exception {
        BufferedReader reader = null;
        InputStream is = null;
        DataOutputStream out = null;
        StringBuffer sbf = new StringBuffer();
        String wechatResponseStr = "";
        try {
            URL url = new URL(WechatConstants.WECHAT_UNIFIED_ORDER_URL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(requestXML);
            out.flush();
            is = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            wechatResponseStr = sbf.toString();
        } finally {
            try {
                reader.close();
                is.close();
                out.close();
            } catch (IOException e) {

            }
        }
        return wechatResponseStr;
    }

    public String encodeMd5(String inStr) {
        StringBuffer hexValue = new StringBuffer();
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");

            byte[] byteArray = inStr.getBytes("UTF-8");
            byte[] md5Bytes = md5.digest(byteArray);

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        return hexValue.toString();
    }
}
