package com.quincysx.avenue.net.sample.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by quincysx on 2017/9/3.
 */

public class GetBean {
    /**
     * headers : {"host":["192.168.0.104:8080"],"connection":["Keep-Alive"],"accept-encoding":["gzip"],"user-agent":["okhttp/3.8.1"]}
     * code : 200
     * param : {"name":"getname"}
     * message : GET请求成功
     */

    private HeadersBean headers;
    private int code;
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
        @SerializedName("accept-encoding")
        private List<String> acceptencoding;
        @SerializedName("user-agent")
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

        @Override
        public String toString() {
            return "HeadersBean{" +
                    "host=" + host +
                    ", connection=" + connection +
                    ", acceptencoding=" + acceptencoding +
                    ", useragent=" + useragent +
                    '}';
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

        @Override
        public String toString() {
            return "ParamBean{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetBean{" +
                "headers=" + headers +
                ", code=" + code +
                ", param=" + param +
                ", message='" + message + '\'' +
                '}';
    }
}
