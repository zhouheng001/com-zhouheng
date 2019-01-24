package com.zhouheng.comspringsource.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.net.URI;

/**
 * @author zhouheng
 * @Description: 自定义注解过滤器
 * @create 2019-01-24 15:06
 */
public class MyFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        ClassMetadata classMetadata = metadataReader.getAnnotationMetadata();

        if(classMetadata.getClassName().contains("com.zhouheng.comspringsource.dao")){
            return true;
        }

        return false;
    }
}
