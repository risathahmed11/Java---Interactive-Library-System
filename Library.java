package bcu.cmp5332.librarysystem.model;

import bcu.cmp5332.librarysystem.main.LibraryException;

import java.time.LocalDate;
import java.util.*;

public class Library {
    
    private final int loanPeriod = 7;
    private final int loanLimit = 5;
    private final Map<Integer, Patron> patrons = new TreeMap<>();
    private final Map<Integer, Book> books = new TreeMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public int getLoanLimit() {
        return loanLimit;
    }

    public List<Book> getBooks() {
        List<Book> out = new ArrayList<>(books.values());
        return Collections.unmodifiableList(out);
    }

    public Book getBookByID(int id) throws LibraryException {
        if (!books.containsKey(id)) {
            throw new LibraryException("There is no such book with that ID.");
        }
        return books.get(id);
    }

    public Patron getPatronByID(int id) throws LibraryException {
        // TODO: implementation here
        if (!patrons.containsKey(id)) {
            throw new LibraryException("There is no such book with that ID.");
        }
        return patrons.get(id);
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            throw new IllegalArgumentException("Duplicate book ID.");
        }
        books.put(book.getId(), book);
    }

    public void addPatron(Patron patron) {
        // TODO: implementation here
        if (patrons.containsKey(patron.getId())) {
            throw new IllegalArgumentException("Duplicate book ID.");
        }
        patrons.put(patron.getId(), patron);
    }
    
    public List<Patron> getPatron() {
        List<Patron> out = new ArrayList<>(patrons.values());
        return Collections.unmodifiableList(out);
    }
    
    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }

    public void updatePatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }
    
    public void addLoan(Loan loan) {
    	loans.add(loan);
    }
    
    public List<Loan> getLoan() {
    	return this.loans;
    }
    
    public void removeLoan(Loan loan) {
    	loan.setRemove(true);
    }
    
    public void updateLoan(Loan loan, Book book, LocalDate dueDate) {
    	for(int i = 0; i < loans.size(); i++)
    	{
    	    if (loans.get(i).getBookId() == book.getId()) {
    	    	loans.get(i).setDueDate(dueDate);
    	    }
    	}
    }
    
    public void removeBook(Book book) {
    	book.setRemove(true);
    }
    
    
    public void removePatron(Patron patron) {
    	patron.setRemove(true);
    }
}
 