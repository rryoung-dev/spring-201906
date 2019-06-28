package com.example.springsi.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 설정 class 
@Configuration 
@PropertySource("classpath:/application.properties")
public class DataSourceConfiguration {
	
	//private static Logger log =
	//		LoggerFactory.getLogger(DataSourceConfiguration.class);

	// hikari connection pool을 사용한 datasource
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
	return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
	DataSource dataSource = new HikariDataSource(hikariConfig());
	//log.info("datasource : {}", dataSource);
	return dataSource;
	}
	
}
