import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	//method for adding new contacts
	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact already exists or is invalid");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	// Method for deleting contact by id
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact does not exist");
		}
		contacts.remove(contactId);
	}
	
	//Method for updating existing contacts
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null) {
			throw new IllegalArgumentException("Contact does not exist");
		}
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		if (phone != null) {
			contact.setPhone(phone);
		}
		if (address != null) {
			contact.setAddress(address);
		}
	}

}
