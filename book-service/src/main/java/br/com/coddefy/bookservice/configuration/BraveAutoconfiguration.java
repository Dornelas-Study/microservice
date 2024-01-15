package br.com.coddefy.bookservice.configuration;

import org.springframework.boot.actuate.autoconfigure.tracing.ConditionalOnEnabledTracing;
import org.springframework.boot.actuate.autoconfigure.tracing.MicrometerTracingAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.tracing.TracingProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.micrometer.tracing.brave.bridge.BraveTracer;
import zipkin2.internal.Trace;
/*
@AutoConfiguration(before = MicrometerTracingAutoConfiguration.class)
@ConditionalOnClass({Trace.class, BraveTracer.class})
@EnableConfigurationProperties(TracingProperties.class)
@ConditionalOnEnabledTracing
public class BraveAutoconfiguration {

}
*/