package bcu.cmp5332.librarysystem.data;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class LoanDataManager implements DataManager {
    
    public final String RESOURCE = "./resources/data/loans.txt";

    @Override
    public void loadData(Library library) throws IOException, LibraryException {
        // TODO: implementation here

        try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                try {
                	
                    int bookId = Integer.parseInt(properties[0]);
                    int patronId = Integer.parseInt(properties[1]);
                    LocalDate startDate = LocalDate.parse(properties[2]);
                    LocalDate dueDate = LocalDate.parse(properties[3]);
                    boolean remove = Boolean.parseBoolean(properties[4]);
                    LocalDate returnDate = LocalDate.parse(properties[5]);

                    Book book = library.getBookByID(bookId);
                    Patron patron = library.getPatronByID(patronId);
                    
                    Loan loan = new Loan(patron, book, startDate, dueDate, remove, returnDate);
                    
                	book.setLoan(loan);
                	
                	if (!remove) {
                		patron.borrowBook(book, dueDate);
                	}
                    
                	library.updateBook(book);
                	library.updatePatron(patron);
                    library.addLoan(loan);
                } catch (NumberFormatException ex) {
                    throw new LibraryException("Unable to parse book id " + properties[0] + " on line " + line_idx
                        + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(Library library) throws IOException {
        // TODO: implementation here
        try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Loan loan : library.getLoan()) {
                out.print(loan.getBookId()+ SEPARATOR);
                out.print(loan.getatronId() + SEPARATOR);
                out.print(loan.getStartDate() + SEPARATOR);
                out.print(loan.getDueDate() + SEPARATOR);
                out.print(loan.getRemove() + SEPARATOR);
                out.print(loan.getReturnDate() + SEPARATOR);
                out.println();
            }
        }
    }
    
}
 