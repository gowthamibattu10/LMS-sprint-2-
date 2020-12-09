package com.cg.librarymanagement.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.librarymanagement.lms.dao.AuthorDao;
import com.cg.librarymanagement.lms.dtos.Author;
import com.cg.librarymanagement.lms.dtos.Book;
import com.cg.librarymanagement.lms.exception.AuthorNotFoundException;
import com.cg.librarymanagement.lms.exception.BookNotFoundException;



@Service
public class AuthorService 
{
	// wiring one bean into another bean
	@Autowired
	private AuthorDao authorDao;
	
	public List<Author> getAllAuthors() 
	{
		System.out.println("Authors...");
		return authorDao.findAll();
	}
	
	public Author getAuthorById(int id)  
	{
		System.out.println("Author");
			Optional<Author>optional = authorDao.findById(id);
       if(!optional.isPresent()) 
       {
    	   throw new AuthorNotFoundException("Author not found for id "+id);
       }
       else
    	   return optional.get();
	}
	
	public Author addAuthor(Author author) 
	{
		
		return authorDao.save(author);
	}
	
	public Author updateAuthor(int authorid,Author author) 
	{
		System.out.println("Author updated.");
	
   
		Optional<Author> repAuth =authorDao.findById(authorid);
		
     System.out.println(author);
     
     if (!repAuth.isPresent()) 
		{
			throw new AuthorNotFoundException("Book Not Found With the given id"+authorid);
		}

     else {
    	 Author authorToBeUpdated=repAuth.get();
     
           
     authorToBeUpdated.setFirstName(author.getFirstName());
     authorToBeUpdated.setLastName(author.getLastName());
     authorToBeUpdated.setEmail(author.getEmail());
     authorToBeUpdated.setContactno(author.getContactno());
		
		     return   authorDao.save(authorToBeUpdated);
        }
	
	}
	
	
	
	
	
	
	
	
	public String removeAuthor(int id) 
	{
		System.out.println("Author removed.");
			Optional<Author> optional = authorDao.findById(id);
			if(!optional.isPresent())
	        {
	        	throw new AuthorNotFoundException("Author not found for with given id "+id);
	        }
			else
		       authorDao.deleteById(id);
		       return "Author deleted Sucessfully";
	}
	
}
