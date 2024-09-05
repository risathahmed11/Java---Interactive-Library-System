package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;

public class RemoveBook implements Command {

    private final Book book;

    public RemoveBook(Book book) {
        this.book = book;
    }
    
    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        library.removeBook(book);
        System.out.println("Book " + book.getId() + " is Successfully Removed.");
    }
}