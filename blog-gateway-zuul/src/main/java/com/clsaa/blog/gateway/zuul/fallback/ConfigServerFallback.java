package com.clsaa.blog.gateway.zuul.fallback;

import com.clsaa.blog.gateway.zuul.response.ResultObj;
import com.clsaa.blog.gateway.zuul.util.jackson.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Component
public class ConfigServerFallback implements ZuulFallbackProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServerFallback.class);

    @Override
    public String getRoute() {
        return "attendance-config-server";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                LOGGER.error("zuul fallback " + ConfigServerFallback.this.getRoute().toString());
                ResultObj resultObj = ResultObj.errorWithLog(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "服务请求失败",ConfigServerFallback.this.getRoute().toString());
                return new ByteArrayInputStream(JsonUtil.ObjToString(resultObj).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}