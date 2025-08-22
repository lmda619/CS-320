import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	public void testContactCreationSuccess() {
		Contact contact = new Contact("ID123456", "Will", "Johnson", "1234567890", "1234 Hill St");
		assertNotNull(contact);
	}
	
	//test for invalid contact data
	@Test
	public void testContactCreationFailure() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Will", "Johnson", "1234567890", "1234 Hill St");
		});
	}
	
	//test for invalid first name
	@Test
	public void testSetFirstNameFailure() {
		Contact contact = new Contact("ID123456", "Will", "Johnson", "1234567890", "1234 Hill St");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}

}
