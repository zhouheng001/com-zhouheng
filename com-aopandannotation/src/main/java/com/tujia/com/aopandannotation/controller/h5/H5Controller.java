package com.tujia.com.aopandannotation.controller.h5;

import com.tujia.com.aopandannotation.annotations.TestAnnotation;
import com.tujia.com.aopandannotation.myenum.TestEnum;
import com.tujia.param.RequestParamterBase;
import com.tujia.com.dubbo.api.po.User;
import com.tujia.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-13 上午 12:27
 */
@Api(description = "用户接口")
@RequestMapping(value = "/h5")
@RestController
public class H5Controller {

    @ApiOperation(value = "pc端获取数量", httpMethod = "GET", notes = "获取数量")
    @RequestMapping("/t1")
    @TestAnnotation(testEnum = TestEnum.PC, name = "获取数量")
    public int getCount() {
        return 10;
    }

    @ApiOperation(value = "新增用户", httpMethod = "POST", notes = "新增注册")
    @RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult createUser(@RequestBody RequestParamterBase<User> user) {
        System.out.println("createUser:::" + user.toString());
        return new ResponseResult(HttpStatus.OK.value(), "新增成功.");
    }

    @ApiOperation(value = "修改用户", httpMethod = "POST", notes = "修改用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult updateUser(@RequestBody RequestParamterBase<User> user) {
        System.out.println("updateUser:::" + user.toString());
        return new ResponseResult(HttpStatus.OK.value(), "修改成功.");
    }

    @ApiOperation(value = "删除用户", httpMethod = "DELETE", notes = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseResult deleteUser(@RequestParam("userId") String userId) {
        System.out.println("deleteUser:::" + userId);
        return new ResponseResult(HttpStatus.OK.value(), "删除成功.");
    }

    @ApiOperation(value = "查询用户", httpMethod = "GET", notes = "查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public ResponseResult queryUser(@RequestParam("userId") String userId) {
        System.out.println("queryUser:::" + userId);
        User user = new User(userId, "张三", "******", "mao2080@sina.com",new Date());
        return new ResponseResult(HttpStatus.OK.value(), user);
    }
}
