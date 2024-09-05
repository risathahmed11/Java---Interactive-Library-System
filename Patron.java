package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patron {
    
    private int id;
    private String name;
    private String phone;
    private String email;
    private boolean remove;
    private final List<Book> books = new ArrayList<>();
    
    // TODO: implement constructor here
    public Patron(int id, String name, String phone, String email, boolean remove) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.remove = remove;
    }
    
    public void borrowBook(Book book, LocalDate dueDate) throws LibraryException {
        // TODO: implementation here
    	book.setDueDate(dueDate);
    	books.add(book);
    }

    public void renewBook(Book book, LocalDate dueDate) throws LibraryException {
        // TODO: implementation here
    	for(int i = 0; i < books.size(); i++)
    	{
    	    if (books.get(i).getId() == book.getId()) {
    	    	books.get(i).setDueDate(dueDate);
    	    }
    	}
    }

    public void returnBook(Book book) throws LibraryException {
        // TODO: implementation here
    	books.removeIf(e -> e.getId() == book.getId());
    }
    
    public void addBook(Book book) {
        // TODO: implementation here
    	books.add(book);
    }
    
    public int getId() {
        return id;
    } 
    
    public String getName() {
        return name;
    } 
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    } 
    
    public String getDetailsShort() {
        return "Patron #" + id + " - " + name;
    }
    
    public String getDetailsLong() {
    	String id = "ID: " + this.id;
    	String name = "\nName: " + this.name;
    	String phone = "\nPhone: " + this.phone;
    	
    	if (!this.books.isEmpty()) {
    		String books = "\n\nList of Books Borrowed:";
    		
            for (Book book : this.books) {
            	books += "\n Book #" + book.getId() + " - " + book.getTitle();
            }
            
    		return id + name + phone + books;
    	}
    	
        return id + name + phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public List<Book> getListOfBooks() {
        return books;
    }
    
    public void setRemove(boolean remove) {
    	this.remove = remove;
    }
    
    public boolean getRemove() {
    	return this.remove;
    }
}
 