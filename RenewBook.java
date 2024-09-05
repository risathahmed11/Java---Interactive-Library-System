package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

public class RenewBook implements Command {

    private final int patronID;
    private final int bookID;

    public RenewBook(int patronID, int bookID) {
        this.patronID = patronID;
        this.bookID = bookID;
    }
	
    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {    	
    	Book book = library.getBookByID(this.bookID); 
    	Patron patron = library.getPatronByID(this.patronID);
    	
    	if (!book.isOnLoan()) {
    		throw new LibraryException("This Book is not on Loan.");
    	}
    	
    	LocalDate dueDate = currentDate.plusDays(library.getLoanPeriod());
    	
    	Loan loan = book.getLoan();

    	patron.renewBook(book, dueDate);
    	
    	library.updateBook(book);
    	library.updatePatron(patron);
        library.updateLoan(loan, book, dueDate);
        
        System.out.println("Renewed Success.");
    }
}
