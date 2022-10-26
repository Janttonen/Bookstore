package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository crepo;

    @Test 
    public void findByNameShouldReturnName() {
        List<Category> categories = crepo.findByName("Fantasy");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }
    
    @Test 
    public void createNewBook() {
    	Category category = new Category("SciFi");
    	crepo.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }    

}

