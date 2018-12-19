package com.tujia.comjdk.lambda;

import com.tujia.comjdk.lambda.vo.MobileVo;
import com.tujia.comjdk.lambda.vo.MobileYuanVo;
import org.junit.Test;

import java.util.Date;
import java.util.Random;
import java.util.function.Function;

/**
 * 描述:
 *
 * @create 2018-11-13 上午 12:27
 */
public class MobileInfoPresentation {

    @Test
    public void test() {

        MobileVo loadBriedMobile = getLoadBriedMobile(3, m -> toLoadBriefMobile(m));
        System.out.println(loadBriedMobile);

    }

    private MobileVo getLoadBriedMobile(int a, Function<MobileYuanVo, MobileVo> function) {

        int i = new Random().nextInt(a);
        MobileYuanVo mobileYuanVo = new MobileYuanVo();
        mobileYuanVo.setMobileNumber("15222895906");
        mobileYuanVo.setChangShang("黑龙江");
        MobileVo apply = function.apply(mobileYuanVo);
        return apply;
    }

    private MobileVo toLoadBriefMobile(MobileYuanVo mobileVo) {
        MobileVo mobileVo1 = new MobileVo();
        mobileVo1.setMobileNumber(mobileVo.getMobileNumber());
        mobileVo1.setChangShang(mobileVo.getChangShang());
        mobileVo1.setDate(new Date());
        return mobileVo1;
    }
}
