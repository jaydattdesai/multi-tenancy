package com.jaydatt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MultitenantConfiguration {
    
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
	
	Map<Object,Object> resolvedDataSources = new HashMap<>();


	DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader());

	dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driverClassName1"))
		.url(env.getProperty("spring.datasource.url1"))
		.username(env.getProperty("spring.datasource.username1"))
		.password(env.getProperty("spring.datasource.password1"));
	
	resolvedDataSources.put("datasource1", dataSourceBuilder.build());
	

	dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driverClassName2"))
		.url(env.getProperty("spring.datasource.url2"))
		.username(env.getProperty("spring.datasource.username2"))
		.password(env.getProperty("spring.datasource.password2"));
	
	resolvedDataSources.put("datasource2", dataSourceBuilder.build());
	
	MultitenantDataSource dataSource = new MultitenantDataSource();
	dataSource.setDefaultTargetDataSource(resolvedDataSources.get("datasource1"));
	dataSource.setTargetDataSources(resolvedDataSources);
	return dataSource;
    }

}
