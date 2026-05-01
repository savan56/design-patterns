package org.example.designPattern.creational.builder;

import java.util.Map;

public class HTTPRequest {
    // All fields are FINAL — object is immutable after building
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;

    // private constructor only builder can access
    private HTTPRequest(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    // ---- The Builder (inner class) ----
    public static class Builder{
        // Required fields
        private final String url;
        private final String method;

        // Optional fields — with defaults
        private  Map<String, String> headers;
        private  String body;
        private  int timeout;

        // Builder constructor takes REQUIRED fields only
        public Builder(String url, String method){
            this.url = url;
            this.method = method;
        }

        public Builder setHeaders(Map<String,String> headers){
            this.headers = headers;
            return this;
        }

        public Builder setBody (String body){
            this.body = body;
            return this;
        }

        public Builder setTimeout(int timeout){
            this.timeout = timeout;
            return this;
        }

        // build() creates the actual object of class
        public HTTPRequest build(){
            if (url == null || url.isBlank() || method == null || method.isBlank()) {
                throw new IllegalStateException("url and method is required");
            }
            return new HTTPRequest(this);
        }
    }

    @Override
    public String toString() {
        return "HTTPRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                '}';
    }
}
