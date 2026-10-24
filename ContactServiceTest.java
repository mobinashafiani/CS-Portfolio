package ContactService;

import static org.junit.Assert.*; 
import org.junit.Test;

public class ContactServiceTest {

    @Test
    public void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
        assertEquals(1, service.getContacts().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactDuplicateIdThrowsException() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        service.addContact(contact2); 
    }

    @Test
    public void testAddNullContactReturnsFalse() {
        ContactService service = new ContactService();
        assertFalse(service.addContact(null));
    }

    @Test
    public void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
        assertEquals(0, service.getContacts().size());
    }

    @Test
    public void testDeleteContactNotFoundReturnsFalse() {
        ContactService service = new ContactService();
        assertFalse(service.deleteContact("99999")); 
    }

    @Test
    public void testUpdateContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        assertTrue(service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Elm St"));
        Contact updated = service.getContacts().get(0);
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Elm St", updated.getAddress());
    }

    @Test
    public void testUpdateContactNotFoundReturnsFalse() {
        ContactService service = new ContactService();
        assertFalse(service.updateContact("99999", "Jane", "Smith", "0987654321", "456 Elm St"));
    }
}
