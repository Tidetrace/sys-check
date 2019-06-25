package com.ck.syscheck;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类，该类继承SpringBootServletInitializer，并且重写configure方法
 *
 * @author ck
 * @date 2019/6/25
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        //  这里sources的类就是启动类
        return builder.sources(SysCheckApplication.class);
    }
}
