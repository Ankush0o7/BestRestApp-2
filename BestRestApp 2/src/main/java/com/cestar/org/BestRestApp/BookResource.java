package com.cestar.org.BestRestApp;

import java.util.List;

import com.cestar.dao.BookDao;
import com.cestar.model.Book;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("books")
public class BookResource {
BookDao bookDao = new BookDao();
	
	@Path("msg")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg() {
		return "Welcome from book resource";
	}
	
	 @Path("add")
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	    public Book addBook(Book bookRequestBody) {
	        bookDao.insertRec(bookRequestBody);
	        return bookRequestBody;
	    }
	
	  @Path("update/{id_old}")
	  @PUT
	    @Produces(MediaType.APPLICATION_JSON)
	    public Book updateBook(Book updatedBookRequestBody, @PathParam("id_old") int oldId) {
	        bookDao.updateRec(updatedBookRequestBody, oldId);
	        return updatedBookRequestBody;
	    }
	  
	  @Path("find/{id}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Book findBook(@PathParam("id") int id) {
	        return bookDao.findBookById(id);
	    }
	  
	    @Path("all")
	    @GET
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Book> showAllBooks() {
	        List<Book> books = bookDao.displayBooks();
	        return books;
	    }
	    
	    @Path("del/{id}")
	    @DELETE
	    @Produces(MediaType.APPLICATION_JSON)
	    public Book deleteBook(@PathParam("id") int id) {
	        Book deletedBook = bookDao.findBookById(id);
	        bookDao.deleteRec(id);
	        return deletedBook;
	    }
	    	  
	
}
