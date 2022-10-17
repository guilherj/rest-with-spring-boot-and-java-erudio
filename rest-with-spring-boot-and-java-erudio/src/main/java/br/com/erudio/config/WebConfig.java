package br.com.erudio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		/*
		 *  Mais informações sobre Content Negociation 
		 *  
		 *  https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
		 */
		
		// Uso via EXTENSION. http://localhost:8080/api/person/v1.xml  foi DEPRECATED a partir do SpringBoot 2.6
				
		// Uma das formar de fazer agora é Via QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml
		
		/*
		 * favorParameter = Se aceita parâmetros.
		 * parameterName = Nome do parâmetro passado na url
		 * ignoreAcceptHeader = Se ignora Parâmetros passados no Header
		 * 
		 */
		configurer.favorParameter(true)
			.parameterName("mediaType")
			.ignoreAcceptHeader(true)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);
	}

}
