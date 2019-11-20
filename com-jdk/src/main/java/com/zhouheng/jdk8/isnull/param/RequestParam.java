package com.zhouheng.jdk8.isnull.param;

import lombok.Data;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-14 上午 12:20
 */
@Data
public class RequestParam<t, r> {
    private t t1;
    private r r1;
}
