package com.project.blueshirt.config.auth;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EmailConfig {
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("#{new Integer('${spring.mail.port}')}")
	private int port;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("#{new Boolean('${spring.mail.properties.mail.smtp.auth}')}")
	private boolean auth;

	@Value("#{new Boolean('${spring.mail.properties.mail.smtp.starttls.enable}')}")
	private boolean starttlsEnable;
	
	@Value("#{new Boolean('${spring.mail.properties.mail.smtp.starttls.required}')}")
	private boolean starttlsRequired;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		mailSender.setDefaultEncoding("UTF-8");
		mailSender.setJavaMailProperties(getMailProperties());
		
		return mailSender;
	}
	
	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.starttls.enable", starttlsEnable);
		properties.put("mail.smtp.starttls.required", starttlsRequired);
//		properties.put("mail.smtps.ssl.trust", host);
//		properties.put("mail.smtps.ssl.enable", true);
//		properties.put("mail.smtp.socketFactory.class", "java.net.ssl.SSLSocketFactory");
		
		return properties;
	}
}
