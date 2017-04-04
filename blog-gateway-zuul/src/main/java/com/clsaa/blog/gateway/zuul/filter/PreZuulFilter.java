package com.clsaa.blog.gateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {
  private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    String host = request.getRemoteHost();
    PreZuulFilter.LOGGER.info("1 请求的host:{}", host);
    return null;
  }

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

}
