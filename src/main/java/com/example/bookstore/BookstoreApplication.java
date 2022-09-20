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

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Ernest Hemingway", "1232323-21", 12.99, "A Farewell to Arms",1929));
			repository.save(new Book("George Orwell", "2212343-5",  9.99, "Animal Farm",1945));	
			repository.save(new Book("J. R. R Tolkien", "1324674-32", 15.99, "The Hobbit", 1937));
			repository.save(new Book("George R. R. Martin", "4325690-1", 19.99, "A Game of Thrones", 1996));
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
