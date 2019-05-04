package com.zhouheng.comspringsource.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author zhouheng
 * @Description:
 *   {@link EnableTransactionManagement } 给容器注入  {@link AutoProxyRegistrar } 和 {@link ProxyTransactionManagementConfiguration }  这两个组件
 *
 *   {@link AutoProxyRegistrar } ： 给容器注入组件 {@link InfrastructureAdvisorAutoProxyCreator }
 * @create 2019-01-29 18:08
 *
 */
@EnableTransactionManagement
@Configuration
public class SpringConfigTransional {



    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("zhouheng");
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw_0515");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws PropertyVetoException {
//        return new JdbcTemplate(dataSource());
        return new JdbcTemplate(dataSource);
    }

    /**
     * 注册事务管理器在容器中
     * @param dataSource
     * @return
     * @throws Exception
     * @see javax.sql.DataSource
     *
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }

}
