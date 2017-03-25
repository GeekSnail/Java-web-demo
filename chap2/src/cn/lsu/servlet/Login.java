package cn.lsu.servlet;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

class Login {
    public static String loginurl = "http://ca.lsu.edu.cn/zfca/login?yhlx=user&login=0122579031373493728&url=#";
    static Cookie[] cookies = {};

    static HttpClient httpClient = new HttpClient();
    
    static String email = "15103450122";//���email
    static String psw = "LMZ63487071cai";//�������
    // ��Ϣ���͵�action
    String url = "http://my.lib.lsu.edu.cn/reader/redr_info.php#";

    public void getUrlContent()
            throws Exception {

        HttpClientParams httparams = new HttpClientParams();
        httparams.setSoTimeout(30000);
        httpClient.setParams(httparams);

        httpClient.getHostConfiguration().setHost("my.lib.lsu.edu.cn", 80);

        httpClient.getParams().setParameter(
                HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

        PostMethod login = new PostMethod(loginurl);
        login.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");

        NameValuePair Email = new NameValuePair("loginemail", email);// ����
        NameValuePair password = new NameValuePair("password", psw);// ����
        // NameValuePair code = new NameValuePair( "code"
        // ,"????");//��ʱ����Ҫ��֤�룬��ʱδ���

        NameValuePair[] data = { Email, password };
        login.setRequestBody(data);

        httpClient.executeMethod(login);
        int statuscode = login.getStatusCode();
        System.out.println(statuscode + "-----------");
        String result = login.getResponseBodyAsString();
        System.out.println(result+"++++++++++++");

        cookies = httpClient.getState().getCookies();
        System.out.println("==========Cookies============");
        int i = 0;
        for (Cookie c : cookies) {
            System.out.println(++i + ":   " + c);
        }
        httpClient.getState().addCookies(cookies);

        // ��stateΪ301����302˵����½ҳ����ת�ˣ���½�ɹ���
        if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY)
                || (statuscode == HttpStatus.SC_MOVED_PERMANENTLY)
                || (statuscode == HttpStatus.SC_SEE_OTHER)
                || (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
            // ��ȡ�µ� URL ��ַ
            Header header = login.getResponseHeader("location");
            // �ͷ�����
            login.releaseConnection();
            System.out.println("��ȡ����תheader>>>" + header);
            if (header != null) {
                String newuri = header.getValue();
                if ((newuri == null) || (newuri.equals("")))
                    newuri = "/";
                GetMethod redirect = new GetMethod(newuri);
                // ////////////
                redirect.setRequestHeader("Cookie", cookies.toString());
                httpClient.executeMethod(redirect);
                System.out.println("Redirect:"
                        + redirect.getStatusLine().toString());
                redirect.releaseConnection();

            } else
                System.out.println("Invalid redirect");
        } else {
            // �û���������û�б��ύ������½��κ���Ҫ��֤���ʱ����������δ�ύ���
            System.out.println("�û�û��½");
            System.exit(1);
        }

    }

}
