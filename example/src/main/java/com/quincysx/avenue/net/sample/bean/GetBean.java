package com.quincysx.avenue.net.sample.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by quincysx on 2017/9/3.
 */

public class GetBean {

    /**
     * headers : {"host":["172.16.133.60:8080"],"connection":["Keep-Alive"],"accept-encoding":["gzip"],"user-agent":["okhttp/3.8.0"]}
     * code : 200
     * data : {"test1":"1","test2":"2","test3":"3"}
     * param : {"name":"getname"}
     * message : GET请求成功
     */

    private HeadersBean headers;
    private int code;
    private DataBean data;
    private ParamBean param;
    private String message;

    public HeadersBean getHeaders() {
        return headers;
    }

    public void setHeaders(HeadersBean headers) {
        this.headers = headers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class HeadersBean {
        private List<String> host;
        private List<String> connection;
        @JSONField(name = "accept-encoding")
        private List<String> acceptencoding;
        @JSONField(name = "user-agent")
        private List<String> useragent;

        public List<String> getHost() {
            return host;
        }

        public void setHost(List<String> host) {
            this.host = host;
        }

        public List<String> getConnection() {
            return connection;
        }

        public void setConnection(List<String> connection) {
            this.connection = connection;
        }

        public List<String> getAcceptencoding() {
            return acceptencoding;
        }

        public void setAcceptencoding(List<String> acceptencoding) {
            this.acceptencoding = acceptencoding;
        }

        public List<String> getUseragent() {
            return useragent;
        }

        public void setUseragent(List<String> useragent) {
            this.useragent = useragent;
        }
    }

    public static class DataBean {
        /**
         * test1 : 1
         * test2 : 2
         * test3 : 3
         */

        private String test1;
        private String test2;
        private String test3;

        public String getTest1() {
            return test1;
        }

        public void setTest1(String test1) {
            this.test1 = test1;
        }

        public String getTest2() {
            return test2;
        }

        public void setTest2(String test2) {
            this.test2 = test2;
        }

        public String getTest3() {
            return test3;
        }

        public void setTest3(String test3) {
            this.test3 = test3;
        }
    }

    public static class ParamBean {
        /**
         * name : getname
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
