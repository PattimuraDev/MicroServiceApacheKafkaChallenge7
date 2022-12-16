package org.example.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * kelas untuk representasi konfigurasi swagger ui
 * @author Dwi Satria Patra
 */
@Configuration
public class SwaggerConfiguration {

    /**
     * Method untuk mengatur konfigurasi swagger dengan OpenAPI versi 3
     * @param appDescription Deskripsi dari dokumentasi swagger
     * @param appVersion Keterangan versi dari dokumentasi dengan swagger
     * @return OpenAPI yang mengatur detail dari dokumentasi swagger
     */
    @Bean
    public OpenAPI demoApi(@Value("REST API kafka microservice for challenge chapter 7 backend java Binar Academy") String appDescription,
                           @Value("v1.0.0") String appVersion
    ){
        return new OpenAPI()
                .info(new Info()
                        .title("Kafka Microservice Endpoints")
                        .version(appVersion)
                        .description(appDescription)
                        .termsOfService("http://swagger.io/terms")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

}
