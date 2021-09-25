package com.AshokIT.group;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.AshokIT.group.bean.CSVReader;
import com.AshokIT.group.model.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext contx=SpringApplication.run(Application.class, args);
		CSVReader csvreader=contx.getBean(CSVReader.class);	
		List<Product> filterdedproduct=csvreader.readAndFilterProductData();
		
		
		filterdedproduct.forEach(System.out::println);
		
		
	
	}

}
