package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value = "/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcategory")
    public String addCategory(Model model){
    	model.addAttribute("category", new Category());
        return "addcategory";
    }  
	
	 @RequestMapping(value = "/savec", method = RequestMethod.POST)
	    public String save(Category category){
	        crepository.save(category);
	        return "redirect:categorylist";
	    }

}
