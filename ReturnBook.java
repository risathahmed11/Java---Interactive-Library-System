package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class ReturnBook implements Command {

    private final int patronID;
    private final int bookID;

    public ReturnBook(int patronID, int bookID) {
        this.patronID = patronID;
        this.bookID = bookID;
    }
	
    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {    	
    	Book book = library.getBookByID(this.bookID); 
    	Patron patron = library.getPatronByID(this.patronID);
    	
    	if (!book.isOnLoan()) {
    		throw new LibraryException("This book is not on Loan.");
    	}
    	
    	library.removeLoan(book.getLoan());
    	
    	book.returnToLibrary();
    	patron.returnBook(book);
    	
    	library.updateBook(book);
    	library.updatePatron(patron);
        
        System.out.println("Returned Success");
    }
}

