package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

public class BorrowBook implements Command {

    private final int patronID;
    private final int bookID;

    public BorrowBook(int patronID, int bookID) {
        this.patronID = patronID;
        this.bookID = bookID;
    }
	
    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {    	
    	Book book = library.getBookByID(this.bookID); 
    	Patron patron = library.getPatronByID(this.patronID);
    	
    	if (patron.getListOfBooks().size() >= library.getLoanLimit()) {
    		throw new LibraryException("Maximum Book Already Loaned.");
    	}
    	
    	if (book.isOnLoan()) {
    		throw new LibraryException("This Book is currently on Loan.");
    	}
    	
    	LocalDate dueDate = currentDate.plusDays(library.getLoanPeriod());
    	
    	Loan loan = new Loan(patron, book, currentDate, dueDate, false, currentDate);
    	
    	book.setLoan(loan);
    	patron.borrowBook(book, dueDate);
    	
    	library.updateBook(book);
    	library.updatePatron(patron);
        library.addLoan(loan);
        
        System.out.println("Loan " + " Successfull.");
    }
}
