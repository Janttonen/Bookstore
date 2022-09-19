package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	// localhost:8080/index
	// localhost:8080/h2-console

	@RequestMapping("/index")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookstore";
	}
}
