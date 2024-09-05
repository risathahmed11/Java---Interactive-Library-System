package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;
import java.time.LocalDate;

public class Book {
    
    private int id;
    private String title;
    private String author;
    private String publicationYear;
    private String publisher;
    private boolean remove;

    private Loan loan;

    public Book(int id, String title, String author, String publicationYear, String publisher, boolean remove) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.remove = remove;
    }

    public int getId() {
        return id;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
	
    public String getDetailsShort() {
        return "Book #" + id + " - " + title;
    }

    public String getDetailsLong() {
        // TODO: implementation here
    	String id = "ID: " + this.id;
    	String title = "\nTitle: " + this.title;
    	String author = "\nAuthor: " + this.author;
    	String publicationYear = "\nPublication Year: " + this.publicationYear;
    	
    	if (this.isOnLoan()) {
    		String loan = "\nLoaned By: " + this.loan.getPatron().getName() + " \nLoan Due Date: " + this.loan.getDueDate();
    		return id + title + author + publicationYear + loan;
    	}
    	
        return id + title + author + publicationYear;
    }
    
    public boolean isOnLoan() {
        return (loan != null && loan.getRemove() == false);
    }
    
    public String getStatus() {
        // TODO: implementation here
    	if (isOnLoan()) {
    		return "Book Borrowed";
		} else {
			return "Book Available";
		}
        
    }

    public LocalDate getDueDate() {
        // TODO: implementation here
        return loan.getDueDate();
    }
    
    public void setDueDate(LocalDate dueDate) throws LibraryException {
        // TODO: implementation here
    	this.loan.setDueDate(dueDate);
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public void returnToLibrary() {
        loan = null;
    }
    
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setRemove(boolean remove) {
    	this.remove = remove;
    }
    
    public boolean getRemove() {
    	return this.remove;
    }
}
