package com.zhouheng.comspringsource.pc;

import lombok.Data;

import java.util.Objects;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-07 下午 8:18
 */
@Data
public class WebResponse<T> {

    private final String ver="1.0";
    private boolean ret;
    private int errcode;
    private String errmsg;
    private T data;



    private WebResponse() {
    }

    public WebResponse(T data) {
        this.ret = true;
        this.errcode = 0;
        this.data = data;
    }

    private WebResponse(T data, String errmsg) {
        this.ret = false;
        this.errmsg = errmsg;
        this.data = data;
    }

    private WebResponse(int errcode, String errmsg, T data) {
        this.ret = false;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static <T> WebResponse<T> returnsuccess(){
        return new WebResponse(null);
    }

    public static <T> WebResponse<T> returnsuccess(T data){
        return new WebResponse(data);
    }

    public static <T> WebResponse<T> returnfail(String errmsg){
        return new WebResponse(null,errmsg);
    }

    public static <T> WebResponse<T> returnfail(int errcode,String errmsg){
        return new WebResponse(errcode,errmsg,null);
    }

    public static <T> WebResponse<T> returnfail(int errcode,String errmsg,T data){
        return new WebResponse(errcode,errmsg,data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WebResponse<?> that = (WebResponse<?>) o;
        return ret == that.ret &&
                errcode == that.errcode &&
                Objects.equals(ver, that.ver) &&
                Objects.equals(errmsg, that.errmsg) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), ver, ret, errcode, errmsg, data);
    }
}
