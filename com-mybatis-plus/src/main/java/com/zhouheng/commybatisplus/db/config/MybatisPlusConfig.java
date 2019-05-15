package com.zhouheng.commybatisplus.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhouheng.commybatisplus.common.DatasourceEnum;
import com.zhouheng.commybatisplus.db.DynamicDataSource.DynamicDataSource;
import com.zhouheng.commybatisplus.db.datasource.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-05-15 下午 9:53
 */
@Configuration
@EnableTransactionManagement(order = 2)//由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@MapperScan(basePackages = {"com.**.dao"})
public class MybatisPlusConfig {

    @Autowired
    private DruidProperties druidProperties;

    @Autowired
    private MutiBaokaoDataSourceProperties mutiBaokaoDataSourceProperties;

    private DruidDataSource zhouhengDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        mutiBaokaoDataSourceProperties.config(dataSource);
        return dataSource;
    }

    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "guns", name = "muti-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource() {
        return dataSource();
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "zhouheng", name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource() {

        DruidDataSource dataSourceGuns = zhouhengDataSource();

        try {
            dataSourceGuns.init();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap();
        hashMap.put(DatasourceEnum.DATA_SOURCE_ZHOUHENG, dataSourceGuns);

        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceGuns);
        return dynamicDataSource;
    }



}
