package com.pc.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Info;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2		//打开swagger
@Configuration	//声明配置类
public class SwaggerConfiguration {
	@Value("${swagger.basePackage}")
	private String basePackage; 	//controller接口所在的包

	@Value("${swagger.title}")
	private String title;	//当前文档的标题

	@Value("${swagger.description}")
	private String description;

	@Value("${swagger.version}")
	private String version;
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.version(version)
				.build();
	}
}
