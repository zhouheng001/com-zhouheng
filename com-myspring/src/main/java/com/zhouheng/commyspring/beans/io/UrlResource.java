package com.zhouheng.commyspring.beans.io;

import java.io.InputStream;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-01-22 14:47
 */
public class UrlResource implements Resource {

    @Override
    public InputStream getResourceStream(String file) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        return inputStream;
    }
}
