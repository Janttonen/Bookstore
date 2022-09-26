package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.BookstoreApplication;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			//categoria
			Category category1 = new Category("Fantasy");
			crepository.save(category1);
			Category category2 = new Category("Horror");
			crepository.save(category2);
			Category category3 = new Category("Thriller");
			crepository.save(category3);
			
			//kirjaset
			brepository.save(new Book("Ernest Hemingway", "1232323-21", 12.99, "A Farewell to Arms",1929, category1));
			brepository.save(new Book("George Orwell", "2212343-5",  9.99, "Animal Farm",1945, category1));	
			brepository.save(new Book("J. R. R Tolkien", "1324674-32", 15.99, "The Hobbit", 1937, category1));
			brepository.save(new Book("George R. R. Martin", "4325690-1", 19.99, "A Game of Thrones", 1996, category1));
			
			
			log.info("fetch all catagories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
