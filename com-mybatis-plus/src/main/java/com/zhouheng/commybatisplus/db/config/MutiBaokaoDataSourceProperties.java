package com.zhouheng.commybatisplus.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *   配置多数据源
 * @author zhouheng
 * @create 2019-05-15 下午 10:00
 */
@Component
@ConfigurationProperties(prefix = "zhouheng.muti-baokao-datasource")
@Data
public class MutiBaokaoDataSourceProperties {

    private String defaultDataSourceName;

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private String validationQuery = "SELECT 'x'";


    public void config(DruidDataSource dataSource) {
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setValidationQuery(validationQuery);
    }
}
