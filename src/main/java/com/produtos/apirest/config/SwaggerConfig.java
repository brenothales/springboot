package com.produtos.apirest.config;


import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

/**
 * SwaggerConf
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Processe Seletivo de Estágio API REST",
                "API REST de cadastro de Vagas.",
                "1.0",
                "Todos os direitos reservado ao TCE-SC",
                new Contact("TCE-SC", "https://virtual.qa.tce.sc.gov.br/pwa",
                        "breno.thales@gmail.com"),
                "Processo Seletivo de Estágio ",
                "https://virtual.qa.tce.sc.gov.br/pwa/#/processo-seletivo-estagio", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}