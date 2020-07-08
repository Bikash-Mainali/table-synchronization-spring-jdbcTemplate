
package com.datum.mapping.config;

import javax.sql.DataSource;

import com.datum.mapping.dao.CustomerDao;
import com.datum.mapping.dao.CustomerDaoImpl;
import com.datum.mapping.dao.MasterDao;
import com.datum.mapping.dao.MasterDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.datum.mapping")
public class BeanConfiguration{
	@Autowired
	private Environment env;

	@Bean(name = "customerDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.customer")
	public DataSource getCustomerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.customer.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.customer.url"));
		dataSource.setUsername(env.getProperty("spring.customer.username"));
		dataSource.setPassword(env.getProperty("spring.customer.password"));
		return dataSource;
	}


	@Bean(name="masterDataSource")
	@ConfigurationProperties(prefix="spring.master")
	public DataSource getMasterDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.master.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.master.url"));
		dataSource.setUsername(env.getProperty("spring.master.username"));
		dataSource.setPassword(env.getProperty("spring.master.password"));
		return dataSource;
	}


	@Bean
	public CustomerDao getCustomerDao() {
		return new CustomerDaoImpl(getCustomerDataSource());
	}

	@Bean
	public MasterDao getMasterDao() {
		return new MasterDaoImpl(getMasterDataSource());
	}
}
