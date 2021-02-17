package com.thinkinginspringboot.automaticalasembly.event;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author ajin
 */
//@EnableAutoConfiguration(exclude = SpringApplicationAdminJmxAutoConfiguration.class)
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args).close();
    }
}
