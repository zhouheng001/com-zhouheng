package com.zhouheng.commyspring.beans.io;

import java.io.InputStream;

/**
 * 描述:
 * 配置读取配置文件流入口
 *
 * @author zhouheng
 * @create 2019-01-22 14:45
 */
public interface Resource {
    InputStream getResourceStream(String file);
}
