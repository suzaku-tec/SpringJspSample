package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import com.example.demo.action.CustomCompositeRequestDataValueProcessor;

import jp.fintan.keel.spring.boot.autoconfigure.web.token.TransactionTokenAutoConfiguration;
import jp.fintan.keel.spring.web.token.transaction.TransactionTokenRequestDataValueProcessor;

@AutoConfiguration
@AutoConfigureAfter(value = {TransactionTokenAutoConfiguration.class, SecurityAutoConfiguration.class})
public class WebConfig {

	@Bean
	public RequestDataValueProcessor requestDataValueProcessor() {
		return new CustomCompositeRequestDataValueProcessor(
				new CsrfRequestDataValueProcessor(),
				new TransactionTokenRequestDataValueProcessor()
		);
	}
}