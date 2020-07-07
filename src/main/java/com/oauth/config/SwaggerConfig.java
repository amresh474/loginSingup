package com.oauth.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo())
				.pathMapping("").globalOperationParameters(operationParameters());
	}
	
	private List<Parameter> operationParameters() {
	    List<Parameter> headers = new ArrayList<>();
	    headers.add(new ParameterBuilder().name("HEADER_1")
	        .description("HEADER_1 DESC")
	        .modelRef(new ModelRef("string")).parameterType("header")
	        .required(true).build());

	    headers.add(new ParameterBuilder().name("HEADER_2")
	        .description("HEADER_2 DESC")
	        .modelRef(new ModelRef("string")).parameterType("header")
	        .required(false).defaultValue("0").build());
	    return headers;
	    }

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/user.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JavaInUse API").description("JavaInUse API reference for developers")
				.termsOfServiceUrl("https://github.com/amresh474").contact("https://github.com/amresh474")
				.license("JavaInUse License").licenseUrl("amreshkumar474@gmail.com").version("1.0").build();
	}

}
