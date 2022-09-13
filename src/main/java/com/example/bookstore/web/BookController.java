package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookController {
	
	//localhost:8080/index
	
	@RequestMapping("/index")
	public String workingPage() {
		return "Bookstore";
	}
}
