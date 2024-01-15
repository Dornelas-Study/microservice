package br.com.coddefy.apigateway.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zipkin2.Span;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.brave.ZipkinSpanHandler;

@Configuration(proxyBeanMethods= false)
@ConditionalOnClass(ZipkinSpanHandler.class)
public class BraveConfiguration {
	 @Bean
	 @ConditionalOnMissingBean
	 @ConditionalOnBean(Reporter.class)
	 ZipkinSpanHandler zipkinSpanHandler (Reporter<Span> spanReporter) {
		 return (ZipkinSpanHandler) ZipkinSpanHandler.newBuilder(spanReporter).build();
	 }
}