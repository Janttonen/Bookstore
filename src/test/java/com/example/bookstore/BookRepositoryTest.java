package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepo;

    @Test 
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = brepo.findByTitle("The Hobbit");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J. R. R Tolkien");
    }
    
    @Test 
    public void createNewBook() {
    	Book book = new Book("Frank Herbert", "1562783-78", 23.99, "Dune", 1965, null);
    	brepo.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    //@Test
    //public void deleteBook() {
    //	brepo.deleteById(bookId)
    //} --> en tajunnut miten tehtdä

}
