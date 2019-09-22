package com.zhouheng.comspringsource.pojo.dto;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author zhouheng
 * @Description:
 *   通过实现
 *    {@link InitializingBean} 初始化
 *    {@link DisposableBean} 销毁
 * @create 2019-01-28 17:18
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("cat constructor...");
    }

    /**
     * 通过Spring提供的bean进行销毁
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat destory...");
    }

    /**
     * 通过Spring提供的bean实现初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet..");
    }
}
