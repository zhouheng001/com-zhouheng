package com.tujia.comaopandannotation.controller;


import com.tujia.comaopandannotation.annotations.TestAnnotation;
import com.tujia.comaopandannotation.myenum.TestEnum;
import com.tujia.comaopandannotation.presentation.TestPresentation;
import com.tujia.comaopandannotation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-12 下午 11:25
 */
@RequestMapping(value = "/test")
@RestController
public class TestController {
    
    @Autowired
    private TestService testService;
    
    @Autowired
    private TestPresentation testPresentation;
    
    @RequestMapping("/")
    @TestAnnotation(testEnum = TestEnum.PC, name = "获取数量")
    public int getCount() {
        return testService.getCount() + testPresentation.getSeconds();
    }
    
}
