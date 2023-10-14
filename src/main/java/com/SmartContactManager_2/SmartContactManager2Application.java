package com.SmartContactManager_2;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class SmartContactManager2Application implements CommandLineRunner{
    
	public static void main(String[] args) {
		SpringApplication.run(SmartContactManager2Application.class, args);
		
	}
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(encoder.encode("ABC"));
		
	}

}
