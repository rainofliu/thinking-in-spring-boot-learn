package com.ajin.thinkinginspringboot.annotationdesign.enable.importselector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @author ajin
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 复用{@link ServerImportSelector} 实现 ，减少重复编码
        ImportSelector importSelector = new ServerImportSelector();
        // 筛选Class名称集合
        String[] selectClassNames = importSelector.selectImports(importingClassMetadata);
        // 创建Bean定义
        Stream.of(selectClassNames)
                // 转化为 BeanDefinitionBuilder对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为 BeanDefinition
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition ->
                        // 注册BeanDefinition 到 BeanDefinitionRegistry
                        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition,registry)

                );

    }
}
