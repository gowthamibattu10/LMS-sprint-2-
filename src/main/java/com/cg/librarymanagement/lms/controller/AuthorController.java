package com.cg.librarymanagement.lms.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.librarymanagement.lms.dtos.Author;
import com.cg.librarymanagement.lms.service.AuthorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//Helps to map user request URL to the specific controller class/method it can be placed at both class level and method level
@Validated
@RequestMapping("/author")
public class AuthorController 
{
	 //Logger log = LoggerFactory.getLogger(AuthorController.class);
	 
		@Autowired
		private AuthorService authorService;

		@GetMapping(value = {"/" })
		public @ResponseBody List<Author> getAllAuthors() 
		{ 
			List<Author> author = authorService.getAllAuthors();
			return author;
		}
		
		@GetMapping("/{authorid}")
		public @ResponseBody  Author getAuthorById(@PathVariable int authorid) 
		{
			return authorService.getAuthorById(authorid);
		}
		
		@PostMapping("/")
		public @ResponseBody Author addAuthor(@RequestBody Author author) 
		{
			System.out.println(author);
			return authorService.addAuthor(author);
		}
		
		@PutMapping("/{authorid}")
		public @ResponseBody Author updateAuthor(@PathVariable int authorid,@RequestBody Author author) 
		{
			
			System.out.println("hiii");
			return authorService.updateAuthor(authorid, author);
		}

		@DeleteMapping("/{authorid}")
		public @ResponseBody String removeAuthor(@PathVariable int authorid) 
		{
			return authorService.removeAuthor(authorid);
		}
}
