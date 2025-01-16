package com.prueba.demo.configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Swagger para la documentación de la API REST.
 * Personaliza la información general del proyecto.
 * 
 * @author CCASTILLO
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configura la instancia principal de OpenAPI.
     * 
     * @return OpenAPI con la información personalizada del proyecto.
     */
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Empleados")
                        .version("1.0.0")
                        .description("Documentación de la API para la gestión de empleados.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
