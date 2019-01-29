package com.zhouheng.comspringsource.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author zhouheng
 * @Description:
 *    前置通知
 *    后置通知
 *    正常返回
 *    异常返回
 *    手动指定方法执行
 *
 * @create 2019-01-29 12:08
 */
@Aspect
public class SpringTestAop {


   //@Pointcut(value = "execution(public int com.zhouheng.comspringsource.manager.JiSuanManager.calculator(int,int))")  切点是指定方法
    @Pointcut(value = "execution(public int com.zhouheng.comspringsource.manager.JiSuanManager.*(..))")  //切点是该类下的所有返回值是int的方法
    public void pointcut(){

    }


    @Before(value = "pointcut()")
//    @Before("execution(public int com.zhouheng.comspringsource.manager.JiSuanManager.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("前切，执行方法名称："+joinPoint.getSignature().getName());
    }

    @After(value = "com.zhouheng.comspringsource.aop.SpringTestAop.pointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("后切，执行方法名称："+joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("目标方法方法执行正常执行，执行方法名称："+joinPoint.getSignature().getName()+"返回结果是："+result);
    }

    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Exception exception){
        System.out.println("目标方法方法执行异常执行，执行方法名称："+joinPoint.getSignature().getName()+"返回的异常信息是："+exception);
    }

}
