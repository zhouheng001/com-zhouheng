package com.tujia.comdubboapi.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2018-12-28 上午 12:17
 */
@Data
public class City implements Serializable {
    private static final long serialVersionUID = 5459002721463008618L;
    private long Id;
    private long proviceId;
    private String qu;
    private String xian;

    public City() {
    }

    public City(long id, long proviceId, String qu, String xian) {
        Id = id;
        this.proviceId = proviceId;
        this.qu = qu;

        this.xian = xian;
    }
}
