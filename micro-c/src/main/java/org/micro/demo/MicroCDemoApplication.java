package org.micro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.jaegertracing.Configuration;
import io.jaegertracing.samplers.ProbabilisticSampler;


@SpringBootApplication
public class MicroCDemoApplication extends WebMvcConfigurerAdapter {
	  
    public static void main(String[] args) {
        SpringApplication.run(MicroCDemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
    
    @Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration("micro-c-demo")
				.withSampler(new Configuration.SamplerConfiguration()
						.withType(ProbabilisticSampler.TYPE)
						.withParam(1))
				.getTracer();
	}
    
}
