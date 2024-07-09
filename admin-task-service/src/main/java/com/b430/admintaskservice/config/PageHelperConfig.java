package com.b430.admintaskservice.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Properties;

@Configuration
public class PageHelperConfig {

    @Resource
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @PostConstruct
    public void initConfig(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        // 设置数据源方言，使用mysql
        properties.setProperty("helperDialect","mysql");

        pageInterceptor.setProperties(properties);
        sqlSessionFactoryList.forEach(factory ->factory.getConfiguration().addInterceptor(pageInterceptor));
    }

}
