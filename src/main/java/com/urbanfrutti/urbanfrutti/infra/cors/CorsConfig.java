package com.urbanfrutti.urbanfrutti.infra.cors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
	
	@Value("${allowed.origins}")
	private String allowedOrigins;
	@Value("${allowed.headers}")
	private String allowedHeaders;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**") //Aplica a configuração CORS a todos os endpoints do aplicativo
        .allowedOrigins("http://localhost", "http://localhost:4200") //especifica as origens que têm permissão para fazer solicitações de origem cruzada
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", 
        "Access-Control-Request-Headers", "Authorization")
        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials") // Expor o cabeçalho Access-Control-Allow-Origin
        .allowCredentials(true) //(Cookies, cabeçalhos de autorização, etc.)
        .maxAge(3600);
    }
}*/
