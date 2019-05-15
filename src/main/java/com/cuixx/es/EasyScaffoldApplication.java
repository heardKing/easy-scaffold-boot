package com.cuixx.es;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class EasyScaffoldApplication extends SpringBootServletInitializer {

    private final static Logger logger = LoggerFactory.getLogger(EasyScaffoldApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EasyScaffoldApplication.class);
    }

    public static void main(String[] args) {
//        SpringApplication.run(EasyScaffoldBootApplication.class, args);
        SpringApplication newRun = new SpringApplication(EasyScaffoldApplication.class);
        newRun.setBannerMode(Banner.Mode.OFF);
        newRun.run(args);
        logger.info("(♥◠‿◠)ﾉﾞ  应用程序启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
