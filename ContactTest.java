package ContactService;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNullThrows() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLongThrows() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactFirstNameNullThrows() {
        new Contact("12345", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactLastNameNullThrows() {
        new Contact("12345", "John", null, "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactPhoneInvalidLengthThrows() {
        new Contact("12345", "John", "Doe", "12345", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactAddressTooLongThrows() {
        new Contact("12345", "John", "Doe", "1234567890", "This address is way too long to pass validation tests");
    }
}
