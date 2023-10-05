package com.jsp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.model.Library;
import com.jsp.service.LibraryServiceImpl;

@Controller

@RequestMapping
public class LibraryController {
	
	@Autowired
	LibraryServiceImpl lservice;
	
	@GetMapping({"/","/d"})
	public String home(Model model) {
		model.addAttribute("appName", "Java Training School Library");
		return "index";
	}
	
	@GetMapping({"/listbook"})
	public String listBooks(Model model) {
		List<Library> list = (List<Library>) lservice.listBooks();
		model.addAttribute("listBooks", list);
		if(list.isEmpty())
			model.addAttribute("msg", "Unfortunately, the library is empty now. Let's"
					+ "contribute by adding some books");
		else {
			
				model.addAttribute("msg", "Welcome to Java Traning School Library");
		}
		return "listBooks";
		
	}
	
	
	@GetMapping("/add")
	public String addBookForm(Model model) {
		
		model.addAttribute("book", new Library());
		return "addbook";
		
	}
	
	@PostMapping("/addbook")
	public String addBooks(@ModelAttribute("book") Library book , Model model) {
		book.setStatus("available");
		lservice.addBook(book);
		return listBooks(model);
		
	}
	
	@GetMapping("/borrow/{id}")
	public String borrow(@PathVariable int id , Model model) {
		
		Library lib = lservice.listById(id);
		
		model.addAttribute("lib", lib);
		return "borrowbook";
		
	}
	
	@PostMapping("/borrowbook")
	public String borrowbook(@RequestParam int id, Model model) {

		Library lib = lservice.listById(id);
		lib.setStatus("Borrowed");

		lservice.addBook(lib);

		model.addAttribute("msg", "Book borrowed successfuly. Please return within a month's time");

		return listBooks(model);
	}
	

}
