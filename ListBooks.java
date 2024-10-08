package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.main.LibraryException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListBooks implements Command {

    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        List<Book> books = new ArrayList<Book>(library.getBooks());
        
        books.removeIf(e -> e.getRemove());
        
        for (Book book : books) {
            System.out.println(book.getDetailsShort());
        }
        System.out.println(books.size() + " book(s)");
    }
}
 