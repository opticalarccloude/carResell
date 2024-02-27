package com.spring.jwt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "CarResell API'S", version = "1.0", description = "Api Documentation"))
public class JwtWithSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtWithSpringSecurityApplication.class, args);

		System.out.println("\n\n");
		System.err.println("PORT : localhost8080");
		System.err.println("documentation : "+"http://localhost:8080/swagger-ui/index.html#/");

		System.err.println("  *****    *******  *******       *****   *******    *****    ******   *******" );
		System.err.println(" *     *   *      *    *         *           *      *     *   *     *     *   " );
		System.err.println("*       *  *      *    *         *           *     *       *  *     *     *   " );
		System.err.println("*       *  *******     *          *****      *     *       *  ******      *   " );
		System.err.println("*********  *           *               *     *     *********  *   *       *   " );
		System.err.println("*       *  *           *               *     *     *       *  *    *      *   " );
		System.err.println("*       *  *        *******       *****      *     *       *  *     *     *   " );
	}

}
