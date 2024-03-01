package com.borja.springboot.app;

import com.borja.springboot.app.Models.Pais;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	List<Pais> paises = new ArrayList<>();
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner initData() {
		return args -> {
			List<String> lineas;

			try {
				// Lee el archivo desde la carpeta src/main/resources
				lineas = Files.readAllLines(Paths.get(getClass().getResource("/paises2019.csv").toURI()), StandardCharsets.UTF_8);
				for (String linea : lineas) {
					String[] datos = linea.split(";");
					paises.add(new Pais(datos[0], datos[1], Integer.parseInt(datos[2])));
				}
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		};
	}
}
