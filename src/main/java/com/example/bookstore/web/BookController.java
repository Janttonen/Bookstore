package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;



@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	
	//@Autowired
	//private CategoryRepository crepository;

	// localhost:8080/bookstore
	// localhost:8080/h2-console

	@RequestMapping(value = "/bookstore")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookstore";
	}
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	//model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }  
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:bookstore";
	    }    
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../bookstore";
	    }    
	 
	 //heittää kirjan tiedot muokkaussivulle
	 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String getBook(@PathVariable("id") Long bookId, Model model) {
	    	model.addAttribute("book", repository.findById(bookId));
	        return "editbook";
	    } 
	 
	 //nytten vain tallentaa muokatun kirjan uutena kirjana,en tajua miten sen saisi heitettyä vanhan päälle
	 //PUT metodilla??
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	    public String saveChanges(Book book) {
		 repository.save(book);
	        return "redirect:bookstore";
	    } 
	
}
