package com.jmail.demo.configs;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jmail.demo.configs.properties.DataSoucesProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 数据库配置类
 * Created by zhangxs7 on 2019/6/26.
 */
@Configuration
@MapperScan(basePackages = {"com.jmail.demo.dao"},
        sqlSessionFactoryRef = "demoSqlSessionFactory")
public class DataBaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseConfig.class);

    @Resource
    private DataSoucesProperties dataSoucesProperties;

    @Primary
    @Bean(name = "demoDataSource")
    public DataSource dataSource() {
        try {
            return DruidDataSourceFactory.createDataSource(dataSoucesProperties);
        } catch (Exception e) {
            logger.error("dataSource create error:{}",e.getMessage(),e);
        }
        return null;
    }

    @Primary
    @Bean(name = "demoSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("demoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/sqlmaps/*.xml"));

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCallSettersOnNulls(true);
        factoryBean.setConfiguration(configuration);

        return factoryBean.getObject();
    }

    @Bean(name = "demoSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("demoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean(name = "demoTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("demoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
