import org.example.ContactAlreadyExistsException;
import org.example.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
