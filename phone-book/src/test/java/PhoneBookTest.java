import org.example.ContactAlreadyExistsException;
import org.example.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void setUP() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddContactSuccessfully() throws ContactAlreadyExistsException {
        int result = phoneBook.add("Petya", 1234567890);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    void testAddDuplicateContactThrowsException() {
        assertThrows(ContactAlreadyExistsException.class, () -> {
            phoneBook.add("Petya", 12345678);
            phoneBook.add("Petya", 87654321); // This should throw an exception
        });
    }

    @Test
    void testFindByNumber() throws ContactAlreadyExistsException{
        phoneBook.add("Masha", 12345679);
        String result = phoneBook.findByNumber(12345679);
        String expected = "Masha".toUpperCase();
        assertEquals(expected, result);
    }

    @Test
    void testFindByName() throws ContactAlreadyExistsException{
        phoneBook.add("Masha", 12345679);
        Integer result = phoneBook.findByName("Masha".toUpperCase());
        Integer expected = 12345679;
        assertEquals(expected, result);
    }

    @Test
    void testPrintAllNames() throws ContactAlreadyExistsException{
        phoneBook.add("Petya", 12345678);
        phoneBook.add("Masha", 23456789);
        phoneBook.add("Anya", 34567890);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        System.setOut(printStream);

        phoneBook.printAllNames();

        System.setOut(originalOut);
        String expectedOutput = "Anya\nMasha\nPetya\n".toUpperCase();
        assertEquals(expectedOutput, outputStream.toString());
    }
}
