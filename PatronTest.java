package JunitTesting;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import bcu.cmp5332.librarysystem.model.Patron;

public class PatronTest {

    private Patron patron;

    @Before
    public void setUp() {
        patron = new Patron(3, "Manveer", "775639242", "manveer@mail.com", true);
    }

    @Test
    public void testGetName() {
        assertEquals("Manveer", patron.getName());
    }

    @Test
    public void testSetName() {
        patron.setName("Updated Patron");
        assertEquals("Updated Patron", patron.getName());
    }

    @Test
    public void testSetNameWithNumbers() {
        patron.setName("12345");
        assertEquals("12345", patron.getName());
    }

    @Test
    public void testSetNameWithSpecialCharacters() {
        patron.setName("John@Doe");
        assertEquals("John@Doe", patron.getName());
    }

    @Test
    public void testSetEmail() {
        patron.setEmail("manveer@mail.com");
        assertEquals("manveer@mail.com", patron.getEmail());
    }

    @Test
    public void testSetInvalidEmail() {
        patron.setEmail("invalid-email");
        assertEquals(null, patron.getEmail());
    }

    @Test
    public void testToString() {
        String expectedToString = "Patron 1 - Test Patron";
        assertEquals(expectedToString, patron.toString());
    }

}