package JunitTesting;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

import java.time.LocalDate;

class BookTest {

    @Test
    final void testBook() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertNotNull(book);
    }

    @Test
    final void testGetId() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals(1, book.getId());
    }

    @Test
    final void testSetId() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        book.setId(2);
        assertEquals(2, book.getId());
    }

    @Test
    final void testGetTitle() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("Test Book", book.getTitle());
    }

    @Test
    final void testSetTitle() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        book.setTitle("Updated Title");
        assertEquals("Updated Title", book.getTitle());
    }

    @Test
    final void testGetAuthor() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    final void testSetAuthor() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        book.setAuthor("Updated Author");
        assertEquals("Updated Author", book.getAuthor());
    }

    @Test
    final void testGetPublicationYear() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("2022", book.getPublicationYear());
    }

    @Test
    final void testSetPublicationYear() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        book.setPublicationYear("2023");
        assertEquals("2023", book.getPublicationYear());
    }

    @Test
    final void testGetDetailsShort() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("Book #1 - Test Book", book.getDetailsShort());
    }

    @Test
    final void testGetDetailsLong() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("ID: 1\nTitle: Test Book\nAuthor: Test Author\nPublication Year: 2022", book.getDetailsLong());
    }

    @Test
    final void testIsOnLoan() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertFalse(book.isOnLoan());
    }

    @Test
    final void testGetStatus() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("Book Available", book.getStatus());
    }
    
    
    @Test
    final void testGetDueDate() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        Loan loan = new Loan(new Patron(1, "Test Patron", "123-456-7890", "test@example.com", false), book, LocalDate.now(), LocalDate.now().plusDays(7), false, null);
        book.setLoan(loan);

        assertNotNull(book.getDueDate());
    }


    @Test
    final void testSetDueDate() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        LocalDate dueDate = LocalDate.now().plusDays(7);
        assertThrows(Exception.class, () -> book.setDueDate(dueDate));
    }

    @Test
    final void testGetLoan() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertNull(book.getLoan());
    }

    @Test
    final void testSetLoan() {
        Patron patron = new Patron(1, "Test Patron", "123-456-7890", "test@example.com", false);
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        Loan loan = new Loan(patron, book, LocalDate.now(), LocalDate.now().plusDays(7), false, null);

        book.setLoan(loan);
        assertEquals(loan, book.getLoan());
    }


    @Test
    final void testReturnToLibrary() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        book.returnToLibrary();
        assertFalse(book.isOnLoan());
    }

    @Test
    final void testGetPublisher() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertEquals("Test Publisher", book.getPublisher());
    }

    @Test
    final void testSetRemove() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        book.setRemove(true);
        assertTrue(book.getRemove());
    }

    @Test
    final void testGetRemove() {
        Book book = new Book(1, "Test Book", "Test Author", "2022", "Test Publisher", false);
        assertFalse(book.getRemove());
    }
}
