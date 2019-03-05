package com.zhouheng.comspringsource.aop;

import com.sun.org.apache.xpath.internal.operations.String;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zhouheng
 * @Description: 前置通知
 * 后置通知
 * 正常返回
 * 异常返回
 * 手动指定方法执行
 * @create 2019-01-29 12:08
 */
@Aspect
public class SpringTestAop {

    private static final Logger logger = Logger.getLogger(SpringTestAop.class.getName());

    //@Pointcut(value = "execution(public int com.zhouheng.comspringsource.manager.JiSuanManager.calculator(int,int))")  切点是指定方法
    //@Pointcut(value = "execution(public int com.zhouheng.comspringsource.manager..*.*(..))")
//      @Pointcut(value = "execution(public int com.zhouheng.comspringsource.manager.JiSuanManager.*(..))")
      @Pointcut(value = "@annotation(com.zhouheng.comspringsource.annotation.MyAnnotation)")
    //切点是该类下的所有返回值是int的方法
    public void pointcut() {

    }


    @Before(value = "pointcut()")
//    @Before("execution(public int com.zhouheng.comspringsource.manager.JiSuanManager.*(..))")
    public void before(JoinPoint joinPoint) {
//        logger.info("日志信息请求方法："+joinPoint.getSignature().getName()+"请求参数："+joinPoint.getArgs());

        //类方法
        logger.info("class_method={}"+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        logger.info("请求方法:"+method);

        //参数
        Object[] args = joinPoint.getArgs();
        List<String> strings = new ArrayList<>();
        for (Object arg : args) {
            strings.add((String) arg);
        }
        logger.info("args={}"+strings);

        System.out.println("前切，执行方法名称：" + joinPoint.getSignature().getName());
    }

    @After(value = "com.zhouheng.comspringsource.aop.SpringTestAop.pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("后切，执行方法名称：" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("目标方法方法执行正常执行，执行方法名称：" + joinPoint.getSignature().getName() + "返回结果是：" + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("目标方法方法执行异常执行，执行方法名称：" + joinPoint.getSignature().getName() + "返回的异常信息是：" + exception);
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("环切方法执行前切");
        Object proceed = null;
        try {
             proceed = proceedingJoinPoint.proceed();
        }catch (Exception e){
            proceed = -1;
            System.out.println("异常信息!");
        }
        return proceed;

    }

}
