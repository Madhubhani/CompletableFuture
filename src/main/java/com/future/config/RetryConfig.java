package com.future.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryConfig {

	@Bean
	  public RetryTemplate retryTemplate() {
	    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
	    retryPolicy.setMaxAttempts(5);
	 
	    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
	    backOffPolicy.setBackOffPeriod(10); // 1.5 seconds
	 
	    RetryTemplate template = new RetryTemplate();
	    template.setRetryPolicy(retryPolicy);
	    template.setBackOffPolicy(backOffPolicy);
	 
	    return template;
		  
	}
	
}
