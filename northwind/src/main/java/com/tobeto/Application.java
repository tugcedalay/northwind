package com.tobeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

//docket uzerinden bizim controllerimizi tarıyor ve yayınlanabilir, dokumante edecek noktaya tasir.
//springimşz beani görünce belleğe atar, docket isimli nesneyle controllerimizi request handleri bulup onu dokümantasyon hailne geitrir.


@SpringBootApplication
//@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	 @Bean
	    public OpenAPI usersMicroserviceOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("com.tobeto")   
	                                 .description("Your API Description")
	                                 .version("1.0"));
	    }
}
