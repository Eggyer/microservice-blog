package com.clsaa.blog.gateway.zuul.config;

import com.clsaa.blog.gateway.zuul.filter.PreZuulFilter;
import com.clsaa.blog.gateway.zuul.filter.TimestampFilter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * Created by eggyer on 2017/3/15.
 */
@SpringBootConfiguration
public class ZuulConfiguration {
    @Bean
    public PreZuulFilter preZuulFilter() {
        return new PreZuulFilter();
    }
    @Bean
    public TimestampFilter timestampFilter(){return new TimestampFilter();}
    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }
}
