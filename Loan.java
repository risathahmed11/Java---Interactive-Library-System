package bcu.cmp5332.librarysystem.model;

import java.time.LocalDate;

public class Loan {
    
    private Patron patron;
    private Book book;
    private LocalDate startDate;
    private LocalDate dueDate;
    private boolean remove;
    private LocalDate returnDate;
    
    public Loan(Patron patron, Book book, LocalDate startDate, LocalDate dueDate, boolean remove, LocalDate returnDate) {
        // TODO: implementation here
    	this.patron = patron;
    	this.book = book;
    	this.startDate = startDate;
    	this.dueDate = dueDate;
    	this.remove = remove;
    	this.returnDate = returnDate;
    }
    
    // TODO: implementation of Getter and Setter methods
    public Patron getPatron() {
        return patron;
    }
    
    public Book getBook() {
        return book;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    public int getBookId() {
        return book.getId();
    }
    
    public int getatronId() {
        return patron.getId();
    }
    
    public void setRemove(Boolean remove) {
        this.remove = remove;
        this.returnDate = LocalDate.now();
    }
    
    public boolean getRemove() {
        return remove;
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
}
 