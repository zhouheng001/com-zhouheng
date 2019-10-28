package com.tujia.com.aopandannotation.controller.test;


import com.tujia.com.aopandannotation.annotations.TestAnnotation;
import com.tujia.com.aopandannotation.myenum.TestEnum;
import com.tujia.com.aopandannotation.presentation.TestPresentation;
import com.tujia.com.aopandannotation.service.TestService;
import com.tujia.comdubboapi.annotation.ApiAspectLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-12 下午 11:25
 */
@Api(description = "测试")
@RequestMapping(value = "/test")
@RestController
public class TestController {

    private static final String[] FILE_HEADER_MAPPING = {"id", "APP","NAME"};

    @Autowired
    private TestService testService;

    @Autowired
    private TestPresentation testPresentation;

    @ApiOperation(value = "pc端获取数量", httpMethod = "GET", notes = "获取数量")
    @RequestMapping("/")
    @TestAnnotation(testEnum = TestEnum.PC, name = "获取数量")
    @ApiAspectLog
    public int getCount(@RequestParam(value = "a", defaultValue = "3") int a) {
        return testService.getCount() + testPresentation.getSeconds();
    }

    @ApiOperation(value = "导入", httpMethod = "GET", notes = "获取数量")
    @RequestMapping(value = "/importFile",method = RequestMethod.POST)
    @TestAnnotation(testEnum = TestEnum.PC, name = "获取数量")
    @ApiAspectLog
    public String importFile(@RequestParam(value = "file") MultipartFile file) throws IOException {

        String name = file.getOriginalFilename();
        System.out.println(name);
        List<String> dataList=new ArrayList<String>();

        BufferedReader br=null;

        InputStream inputStream = file.getInputStream();
        br = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }

        System.out.println(dataList);

        return "success";
    }
}
