package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.bookstore.web.BookController;
import com.example.bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bc;
	
	@Autowired
	private CategoryController cc;
	
	@Test
	public void contextLoads() {
		assertThat(bc).isNotNull();
		assertThat(cc).isNotNull();
	}

}
