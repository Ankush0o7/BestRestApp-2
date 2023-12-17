package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Book;

public class BookDao {

	public Connection setupConnection() {

		// Initialize a Variable of our return type Connection

		Connection con = null;

		// Write the credentials for database

		String url = "jdbc:mysql://localhost:3306/books"; // Connection String

		String user = "root"; // User Name

		String pwd = "";

		// Load the Driver for mysql database

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Successfull Congratulations!!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
	public int insertRec(Book book) {
        
		int status = 0 ;
		
		Connection con = setupConnection();
		
		String sql = "Insert into books (id,name,author,price,genre) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
		
		    // Use Setter Methods to set the values for ? marks
			
			pstmt.setInt(1, book.getId());
			
			pstmt.setString(2, book.getName());
			
			pstmt.setString(3, book.getAuthor());
			
			pstmt.setDouble(4, book.getPrice());
			
			pstmt.setString(5, book.getGenre());
		
		     // After setting values for all ? marks we have to use executeUpdate  method
			
			status = pstmt.executeUpdate();
			
			if(status > 0) {
				
				System.out.println("Book inserted successfully !!!");
			}
			else {
				System.out.println("Insertion failed. Please try again.");
			}
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		}
	
	public List<Book> displayBooks(){
        List<Book> bookList = new ArrayList<>();

        try (Connection con = setupConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getString("genre")
                );
                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
		}
	
	public Book findBookById(int bookId) {
	    Book foundBook = null;		
		//  Get the Connection by calling the method setupConnection()
		
		Connection con = setupConnection();
	    String sql = "SELECT * FROM books WHERE id=?";

	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, bookId);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            foundBook = new Book(
	            		rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getString("genre")
	            );

	            System.out.println("Book found: " + foundBook);
	        } else {
	            System.out.println("Book with ID " + bookId + " not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return foundBook;
	}
	
	public int updateRec(Book updatedBook , int old_id) {
		int status = 0 ;
		
	//  Get the Connection by calling the method setupConnection()
	
	Connection con = setupConnection();
	
    String sql = "UPDATE books SET name=?, author=?, price=?,genre=?,id=? WHERE id=?";

    try {
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, updatedBook.getName());
        pstmt.setString(2, updatedBook.getAuthor());
        pstmt.setDouble(3, updatedBook.getPrice());
        pstmt.setString(4, updatedBook.getGenre());
        pstmt.setInt(5, updatedBook.getId());
        pstmt.setInt(6, old_id);

        status = pstmt.executeUpdate();

        if (status > 0) {
            System.out.println("Book updated successfully !!!");
        } else {
            System.out.println("Update failed. Check the provided ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return status;
	}
	
	public int deleteRec(int bookId) {
	int status = 0 ;
		
		//  Get the Connection by calling the method setupConnection()
		
		Connection con = setupConnection();
	    String sql = "DELETE FROM books WHERE id=?";

	    try {
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, bookId);

	        status = pstmt.executeUpdate();

	        if (status > 0) {
	            System.out.println("Book deleted successfully !!!");
	        } else {
	            System.out.println("Delete failed. Check the provided ID.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return status;
	}
	

}
