package com.samsung.sds.emarket.marketing.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class OpenAPIDocumentationConfig {
    private ApiKey apiKey() { 
        return new ApiKey("JWT", "Authorization", "header"); 
    }
    
    private SecurityContext securityContext() { 
        return SecurityContext.builder().securityReferences(defaultAuth()).build();  
    }
    
    private List<SecurityReference> defaultAuth() { 
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");  
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];  
        authorizationScopes[0] = authorizationScope; 
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));  
    }
  
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
          .title("Emarket - Marketing HTTP API")
          .description("The Marketing Service HTTP API")
          .license("")
          .licenseUrl("http://unlicense.org")
          .termsOfServiceUrl("")
          .version("v1")
          .contact(new Contact("","", ""))
          .build();
  }

    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .securityContexts(Arrays.asList(securityContext()))
          .securitySchemes(Arrays.asList(apiKey()))
          .select()  
          .apis(RequestHandlerSelectors.basePackage("com.samsung.sds.emarket.marketing.controller"))
          .paths(PathSelectors.ant("/api/v1/**"))                                    
          .build()
          .apiInfo(apiInfo());
    }
    
}