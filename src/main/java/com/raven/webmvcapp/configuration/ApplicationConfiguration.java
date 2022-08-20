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
	public DataSource getJdbcDataSource() {
		BasicDataSource jdbcDataSource = new BasicDataSource();

		try {
			jdbcDataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
			jdbcDataSource.setUrl(environment.getProperty("jdbc.url"));
			jdbcDataSource.setUsername(environment.getProperty("jdbc.user"));
			jdbcDataSource.setPassword(environment.getProperty("jdbc.password"));

			jdbcDataSource.setInitialSize(Integer.parseInt(environment.getProperty("dbcp2.initial-size")));
			jdbcDataSource.setMaxIdle(Integer.parseInt(environment.getProperty("dbcp2.max-idle")));
			jdbcDataSource
					.setDefaultQueryTimeout(Integer.parseInt(environment.getProperty("dbcp2.default-query-timeout")));
			jdbcDataSource.setDefaultAutoCommit(Boolean.valueOf(environment.getProperty("dbcp2.default-auto-commit")));

//			System.out.println("----->>>>>>> User Name -->> " + jdbcDataSource.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jdbcDataSource;
	}
}
