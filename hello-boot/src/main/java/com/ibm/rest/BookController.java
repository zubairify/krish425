package com.ibm.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.pojo.Book;

@RestController
@RequestMapping("/book")
public class BookController {

	// http://localhost:9000/book/get?title=Java&author=Patrick&price=300
	@GetMapping(value = "/get", produces = "application/json")
	public Book getBook(@RequestParam String title, @RequestParam String author, @RequestParam double price) {
		Book bk = new Book();
		bk.setTitle(title);
		bk.setAuthor(author);
		bk.setPrice(price);
		
		return bk;
	}
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String addBook(@RequestBody Book bk) {
		return "Book added with title " + bk.getTitle();
	}
}

