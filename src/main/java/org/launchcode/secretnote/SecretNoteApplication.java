package org.launchcode.secretnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SecretNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretNoteApplication.class, args);
	}

}
