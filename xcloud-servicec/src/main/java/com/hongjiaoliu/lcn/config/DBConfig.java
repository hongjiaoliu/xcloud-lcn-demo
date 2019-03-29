package com.hongjiaoliu.lcn.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    private static final Logger logger = LoggerFactory
            .getLogger(DBConfig.class);

    /**
     * 
     * 注入git配置文件信息
     * 
     * @return ConfigProperties
     */
    @Bean
    @Autowired
    public ConfigProperties configProperties() {
        return new ConfigProperties();
    }

    /**
     * 数据源
     * @return
     */
    @Bean(value = "dataSource")
    public DataSource dataSource(ConfigProperties configProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(configProperties.driver);
        dataSource.setUrl(configProperties.url);
        dataSource.setUsername(configProperties.username);
        dataSource.setPassword(configProperties.password);
        logger.info("init data source : {}, driver:{}, url : {}", dataSource,
                configProperties.driver, configProperties.url);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(
            DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);

        logger.info(
                "init DataSourceTransactionManager : {}, using dataSource : {}",
                dataSourceTransactionManager, dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        logger.info("init SqlSessionFactoryBean : {}, using dataSource : {}",
                sessionFactory, dataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // 通过当前的包名称，依照规则计算出mapper的包名
        String scanPackage = DBConfig.class.getPackage().getName()
                .replace(".conf", ".mapper");
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage(scanPackage);
        logger.info("init MapperScannerConfigurer : {}", mapperScanner);
        return mapperScanner;
    }

}
