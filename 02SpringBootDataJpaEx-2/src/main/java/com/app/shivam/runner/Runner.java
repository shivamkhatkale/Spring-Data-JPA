package com.app.shivam.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.shivam.entity.Product;
import com.app.shivam.repo.ProductRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(repo.getClass().getName());

		Product p1 = new Product(10, "P2", 15100.0);
		Product p2 = new Product(20, "P3", 89999.0);
		Product p3 = new Product(30, "P4", 99001.0);

//		repo.save(p1);
//		repo.save(p2);
//		repo.save(p3);
		repo.saveAll(Arrays.asList(p1,p2,p3));
		
		Iterable<Product> data = repo.findAll();
		
		// jdk 1.5 forEach loop
		for(Product p: data) {
			System.out.println(p);
		}
		
		System.out.println("--------------------------------------------------");
		// jdk 1.8 Default Method + Lambada Expression
		data.forEach(ob -> System.out.println(ob));
		
		System.out.println("---------------------------------------------------");
		// jdk 1.8 Default Method + Lambada Expression
		data.forEach(System.out::println);
				
		
		System.out.println(repo.existsById(10)); // true
		System.out.println(repo.existsById(32)); // false
		
		
		System.out.println(repo.count()); // number of rows in single table
		
	}

}