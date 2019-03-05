package com.tujia.com.aopandannotation.controller;


import com.tujia.com.aopandannotation.annotations.TestAnnotation;
import com.tujia.com.aopandannotation.myenum.TestEnum;
import com.tujia.com.aopandannotation.presentation.TestPresentation;
import com.tujia.com.aopandannotation.service.TestService;
import com.tujia.comdubboapi.annotation.ApiAspectLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ApiAspectLog
    public int getCount(@RequestParam(value = "a",defaultValue = "3") int a) {
        return testService.getCount() + testPresentation.getSeconds();
    }

}
