package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class RemovePatron implements Command {

    private final Patron patron;

    public RemovePatron(Patron patron) {
        this.patron = patron;
    }
    
    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        library.removePatron(patron);
        System.out.println("Patron " + patron.getId() + " is Successfully Removed.");
    }
}
