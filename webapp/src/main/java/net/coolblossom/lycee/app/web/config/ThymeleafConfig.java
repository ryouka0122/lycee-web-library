package net.coolblossom.lycee.app.web.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("net.coolblossom.lycee.app.web.controller")
public class ThymeleafConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());

		return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();

		engine.setTemplateResolver(templateResolver());
		engine.setEnableSpringELCompiler(true);

		return engine;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

		viewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
		viewResolver.setTemplateEngine(templateEngine());

		registry.viewResolver(viewResolver);
	}



}
