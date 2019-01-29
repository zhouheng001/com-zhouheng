package com.zhouheng.comspringsource.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author zhouheng
 * @Description: Profile根据不同的环境, 动态配置
 * <p>
 * 开发环境,测试环境,生产环境
 * @create 2019-01-28 23:50
 */
@PropertySource(value = "classpath:db.properties")
@Configuration
public class SpringConfigProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;
//    @Value("${db.pwd}")
//    private String pwd;
    @Value("${db.driverClass}")
    private String driverClass;

    private StringValueResolver resolver;

    @Profile("test")
    @Bean("dataSourceTest")
    public DataSource dataSource(@Value("${db.pwd}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw_0515");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("dataSourceProd")
    public DataSource dataSourceProd(@Value("${db.pwd}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw_0515");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        String pwd = resolver.resolveStringValue("${db.pwd}");
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw_0515");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    /**
     * 通过参数解析器注入值
     * @param resolver
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
       this.resolver=resolver;
    }
}
