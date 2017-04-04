package com.clsaa.blog.gateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by eggyer on 2017/3/19.
 * URL时间戳检查
 * 查看有没有URL有没有过期,防止被截获后长时间调用
 */
public class TimestampFilter extends ZuulFilter{
    private static final Logger LOGGER = LoggerFactory.getLogger(TimestampFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
 /*       RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
*//*        Timestamp paramTime = Timestamp.valueOf(request.getParameter("timestamp"));
        LOGGER.info(paramTime+" param timestamp 2");
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        LOGGER.info(String.valueOf((nowTime.getTime() - paramTime.getTime()) >100000));*//*
        ResultObj resultObj = ResultObj.errorWithMsg(HttpStatus.UNAUTHORIZED.value(),"URL已过期");
        HttpServletResponse response = requestContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        requestContext.setResponseBody(JsonUtil.ObjToString(resultObj));
        requestContext.setResponse(response);
        requestContext.setSendZuulResponse(false);*/
        LOGGER.info("2222222222222222222222");
        return null;
    }
}
