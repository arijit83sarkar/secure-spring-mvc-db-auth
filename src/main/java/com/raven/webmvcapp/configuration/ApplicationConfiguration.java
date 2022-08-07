package com.raven.webmvcapp.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.raven.webmvcapp")
@PropertySource("classpath:app-db.properties")
public class ApplicationConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/view/");
		resourceViewResolver.setSuffix(".jsp");

		return resourceViewResolver;
	}

	@Bean(name = "jdbcDataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		try {
			dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
			dataSource.setUrl(environment.getProperty("jdbc.url"));
			dataSource.setUsername(environment.getProperty("jdbc.user"));
			dataSource.setPassword(environment.getProperty("jdbc.password"));

			dataSource.setInitialSize(Integer.parseInt(environment.getProperty("dbcp2.initial-size")));
			dataSource.setMaxIdle(Integer.parseInt(environment.getProperty("dbcp2.max-idle")));
			dataSource.setDefaultQueryTimeout(Integer.parseInt(environment.getProperty("dbcp2.default-query-timeout")));
			dataSource.setDefaultAutoCommit(Boolean.valueOf(environment.getProperty("dbcp2.default-auto-commit")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataSource;
	}
}
