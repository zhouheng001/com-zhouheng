package com.tujia.com.aopandannotation.controller.h5;

import com.tujia.com.aopandannotation.annotations.TestAnnotation;
import com.tujia.com.aopandannotation.myenum.TestEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-13 上午 12:27
 */
@RequestMapping(value = "/h5")
@RestController
public class H5Controller {

    @RequestMapping("/")
    @TestAnnotation(testEnum = TestEnum.PC, name = "获取数量")
    public int getCount() {
        return 10;
    }
}
