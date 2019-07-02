package com.edison.restful.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @CLassName ServletConfig
 * @Description TODO
 * @Author goodman
 * @Date 2019-04-30 11:01
 * @Version 1.0
 **/
@Configuration
public class ServletConfig {

    @Value("${jetty.port}")
    private int jettyPort;

    /**
     * 项目容器的配置,此处是Jetty
     *
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory servletContainer() {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(jettyPort);
        return factory;
    }
}
