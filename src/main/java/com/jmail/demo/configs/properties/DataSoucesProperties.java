package com.jmail.demo.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 商品数据库配置类
 * <p>Create Time: 2019年07月01日 10:59  </p>
 * <p>@author zhangxs7  </p>
 **/

@Configuration
@ConfigurationProperties(prefix = "datasource.localdb")
public class DataSoucesProperties extends Properties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String connectionProperties;
    private String defaultCatalog;
    private String defaultReadOnly;
    private String defaultTransactionIsolation;
    private String exceptionSorter;
    private String filters;
    private String init;
    private String initConnectionSqls;
    private Integer initialSize;
    private String logAbandoned;
    private String maxActive;
    private Integer maxIdle;
    private Integer maxWait;
    private String minEvictableIdleTimeMillis;
    private String minIdle;
    private String numTestsPerEvictionRun;
    private String phyTimeoutMillis;
    private String poolPreparedStatements;
    private String removeAbandoned;
    private String removeAbandonedTimeout;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean testWhileIdle;
    private Integer timeBetweenEvictionRunsMillis;
    private String validationQuery;
    private Integer validationQueryTimeout;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public void setDefaultCatalog(String defaultCatalog) {
        this.defaultCatalog = defaultCatalog;
    }

    public void setDefaultReadOnly(String defaultReadOnly) {
        this.defaultReadOnly = defaultReadOnly;
    }

    public void setDefaultTransactionIsolation(String defaultTransactionIsolation) {
        this.defaultTransactionIsolation = defaultTransactionIsolation;
    }

    public void setExceptionSorter(String exceptionSorter) {
        this.exceptionSorter = exceptionSorter;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public void setInitConnectionSqls(String initConnectionSqls) {
        this.initConnectionSqls = initConnectionSqls;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public void setLogAbandoned(String logAbandoned) {
        this.logAbandoned = logAbandoned;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public void setMinIdle(String minIdle) {
        this.minIdle = minIdle;
    }

    public void setNumTestsPerEvictionRun(String numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public void setPhyTimeoutMillis(String phyTimeoutMillis) {
        this.phyTimeoutMillis = phyTimeoutMillis;
    }

    public void setPoolPreparedStatements(String poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public void setRemoveAbandoned(String removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }

    public void setRemoveAbandonedTimeout(String removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public void setValidationQueryTimeout(Integer validationQueryTimeout) {
        this.validationQueryTimeout = validationQueryTimeout;
    }

    @Override
    public String toString() {
        return "DataSoucesProperties{" +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", connectionProperties='" + connectionProperties + '\'' +
                ", defaultCatalog='" + defaultCatalog + '\'' +
                ", defaultReadOnly='" + defaultReadOnly + '\'' +
                ", defaultTransactionIsolation='" + defaultTransactionIsolation + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", exceptionSorter='" + exceptionSorter + '\'' +
                ", filters='" + filters + '\'' +
                ", init='" + init + '\'' +
                ", initConnectionSqls='" + initConnectionSqls + '\'' +
                ", initialSize='" + initialSize + '\'' +
                ", logAbandoned='" + logAbandoned + '\'' +
                ", maxActive='" + maxActive + '\'' +
                ", maxIdle='" + maxIdle + '\'' +
                ", maxWait='" + maxWait + '\'' +
                ", minEvictableIdleTimeMillis='" + minEvictableIdleTimeMillis + '\'' +
                ", minIdle='" + minIdle + '\'' +
                ", numTestsPerEvictionRun='" + numTestsPerEvictionRun + '\'' +
                ", phyTimeoutMillis='" + phyTimeoutMillis + '\'' +
                ", poolPreparedStatements='" + poolPreparedStatements + '\'' +
                ", removeAbandoned='" + removeAbandoned + '\'' +
                ", removeAbandonedTimeout='" + removeAbandonedTimeout + '\'' +
                ", testOnBorrow='" + testOnBorrow + '\'' +
                ", testOnReturn='" + testOnReturn + '\'' +
                ", testWhileIdle='" + testWhileIdle + '\'' +
                ", timeBetweenEvictionRunsMillis='" + timeBetweenEvictionRunsMillis + '\'' +
                ", validationQuery='" + validationQuery + '\'' +
                ", validationQueryTimeout='" + validationQueryTimeout + '\'' +
                '}';
    }
}
