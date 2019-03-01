//package com.org.configuration;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
//
//import javax.persistence.EntityManagerFactory;
//
//
//@Configuration
//public class BeanConfig {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//	    HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
//	    factory.setEntityManagerFactory(emf);
//	    return factory;
//	}
//
//}