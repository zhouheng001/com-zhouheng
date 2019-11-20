package com.zhouheng.jdk8.lambda.test;

import com.zhouheng.jdk8.lambda.vo.MobileVo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-24 上午 12:49
 */
public class Test3 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MobileVo mobileVo = new MobileVo();

        Class<MobileVo> mobileVoClass = MobileVo.class;
        Method[] methods = mobileVoClass.getMethods();

        for (Method method : methods) {
          if(method.getName().equalsIgnoreCase("setChangShang")){
              method.invoke(mobileVo,"zhouheng");
          }
        }

        System.out.println(mobileVo);
    }
}
