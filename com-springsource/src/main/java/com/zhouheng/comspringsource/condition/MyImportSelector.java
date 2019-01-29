package com.zhouheng.comspringsource.condition;

import com.zhouheng.comspringsource.pojo.dto.Blue;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 16:21
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Blue.class.getName()};
    }
}
