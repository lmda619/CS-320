import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}

	@Test
	public void testAddContactSuccess() {
		Contact contact = new Contact("ID123456", "Jonathan", "Lane", "0987654321", "7890 Pine Rd");
		service.addContact(contact);
		assertNotNull(service);
	}
	
	//testing of adding the same contact twice
	@Test
	public void testAddContactFailure() {
		Contact contact1 = new Contact("ID123456", "Jonathan", "Lane", "0987654321", "7890 Pine Rd");
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact1);
		});
	}
	
	@Test
	public void testDeleteContact() {
		Contact contact = new Contact("IDToDelete", "Elena", "Price", "2345678901", "4567 Redwood Ave");
		service.addContact(contact);
		service.deleteContact("IDToDelete");
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("IDToDelete");
		});
	}
	
	@Test
	public void testUpdateContactSuccess() {
		Contact contact = new Contact("IDToUpdate", "David", "Smith", "3456789012", "3456 Sunset Ln");
		service.addContact(contact);
		service.updateContact("IDToUpdate", "Dave", null, null, "3455 Sunset Ln");
		assertEquals("Dave", contact.getFirstName());
		assertEquals("3455 Sunset Ln", contact.getAddress());
	}

}
