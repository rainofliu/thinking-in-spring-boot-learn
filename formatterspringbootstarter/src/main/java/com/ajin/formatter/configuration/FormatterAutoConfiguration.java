package com.ajin.formatter.configuration;

import com.ajin.formatter.Formatter;
import com.ajin.formatter.impl.DefaultFormatter;
import com.ajin.formatter.impl.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ajin
 */
@AutoConfigureAfter(JacksonAutoConfiguration.class)
@Configuration
@ConditionalOnProperty(prefix = "formatter",name = "enabled",havingValue="true",matchIfMissing = true)
@ConditionalOnResource(resources = "META-INF/spring.factories")
public class FormatterAutoConfiguration {
    /**
     * 构建{@link DefaultFormatter} Bean
     */
    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }
    /**
     * 构建{@link com.ajin.formatter.impl.JsonFormatter} Bean
     */
    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public Formatter objectMapperFormatter(ObjectMapper objectMapper) {
        return new JsonFormatter(objectMapper);
    }

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter jsonFormatter() {
        return new JsonFormatter();
    }

}
