package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class ListPatron  implements Command {

    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        List<Patron> patrons = new ArrayList<Patron>(library.getPatron());
        
        patrons.removeIf(e -> e.getRemove());
        
        for (Patron patron : patrons) {
            System.out.println(patron.getDetailsShort());
        }
        System.out.println(patrons.size() + " book(s)");
    }
}
