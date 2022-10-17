package br.com.erudio.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.erudio.seralization.converter.YamlJacksonToHttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		converters.add(new YamlJacksonToHttpMessageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		/*
		 *  Mais informações sobre Content Negociation 
		 *  
		 *  https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
		 */
		
		/*
		 *  Uso via EXTENSION. http://localhost:8080/api/person/v1.xml  foi DEPRECATED a partir do SpringBoot 2.6
		 *  
		 *  Uma das formar de fazer agora é Via QUERY PARAM.
		 */
				
		// Via QUERY PARAM: http://localhost:8080/api/person/v1?mediaType=xml
		
		/*
		 * favorParameter = Se aceita parâmetros.
		 * parameterName = Nome do parâmetro passado na url
		 * ignoreAcceptHeader = Se ignora Parâmetros passados no Header
		 * 
		 *
		configurer.favorParameter(true)
			.parameterName("mediaType")
			.ignoreAcceptHeader(true)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);
				
				*/
		
		
		/*
		 *  Via HEADER PARAM: http://localhost:8080/api/person/v1
		 *  
		 *  No Header necessário colocar Accept: application/NOME-DA-EXTENSÃO
		 */
		
				configurer.favorParameter(false)
					.ignoreAcceptHeader(false)
					.useRegisteredExtensionsOnly(false)
					.defaultContentType(MediaType.APPLICATION_JSON)
						.mediaType("json", MediaType.APPLICATION_JSON)
						.mediaType("xml", MediaType.APPLICATION_XML)
						.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
	}

}
