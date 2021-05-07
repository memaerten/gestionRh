package fr.formation.afpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/css/**").addResourceLocations("/WEB-INF/resources/css/");
		registry.addResourceHandler("/resources/js/**").addResourceLocations("/WEB-INF/resources/js/");
	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/*");
//		LocaleChangeInterceptor localInterceptor = new LocaleChangeInterceptor();
//		localInterceptor.setParamName("lang");
//		
//		registry.addInterceptor(localInterceptor).addPathPatterns("/*");
//	}
}
