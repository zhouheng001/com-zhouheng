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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        if (!super.equals(o)) return false;

        City city = (City) o;

        if (Id != city.Id) return false;
        if (proviceId != city.proviceId) return false;
        if (!qu.equals(city.qu)) return false;
        return xian.equals(city.xian);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (Id ^ (Id >>> 32));
        result = 31 * result + (int) (proviceId ^ (proviceId >>> 32));
        result = 31 * result + qu.hashCode();
        result = 31 * result + xian.hashCode();
        return result;
    }
}
