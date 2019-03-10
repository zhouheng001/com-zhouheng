package com.zhouheng.comspringsource.controller;

import com.zhouheng.comspringsource.pc.WebResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-24 14:54
 */
@RestController
public class TestController {

    @RequestMapping("/async01")
    public Callable<String> async01(){
        System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
                return "Callable<String> async01()";
            }
        };

        System.out.println("主线程结束..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
        return callable;
    }

    @RequestMapping("/test")
    public WebResponse<String> getTest(){
        return WebResponse.returnfail("服务器繁忙!");
    }
}
