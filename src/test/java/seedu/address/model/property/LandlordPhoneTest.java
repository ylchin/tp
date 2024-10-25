package seedu.address.model.property;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class LandlordPhoneTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new LandlordPhone(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "";
        assertThrows(IllegalArgumentException.class, () -> new LandlordPhone(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> seedu.address.model.property.LandlordPhone.isValidPhone(null));

        // invalid phone numbers
        assertFalse(seedu.address.model.property.LandlordPhone.isValidPhone("")); // empty string
        assertFalse(seedu.address.model.property.LandlordPhone.isValidPhone(" ")); // spaces only
        assertFalse(seedu.address.model.property.LandlordPhone.isValidPhone("91")); // less than 3 numbers
        assertFalse(seedu.address.model.property.LandlordPhone.isValidPhone("phone")); // non-numeric
        assertFalse(seedu.address.model.property.LandlordPhone.isValidPhone("9011p041")); // alphabets within digits
        assertFalse(seedu.address.model.property.LandlordPhone.isValidPhone("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(seedu.address.model.property.LandlordPhone.isValidPhone("911")); // exactly 3 numbers
        assertTrue(seedu.address.model.property.LandlordPhone.isValidPhone("93121534"));
        assertTrue(seedu.address.model.property.LandlordPhone.isValidPhone("124293842033123")); // long phone numbers
    }

    @Test
    public void equals() {
        LandlordPhone landlordPhone = new LandlordPhone("999");

        // same values -> returns true
        assertTrue(landlordPhone.equals(new LandlordPhone("999")));

        // same object -> returns true
        assertTrue(landlordPhone.equals(landlordPhone));

        // null -> returns false
        assertFalse(landlordPhone.equals(null));

        // different types -> returns false
        assertFalse(landlordPhone.equals(5.0f));

        // different values -> returns false
        assertFalse(landlordPhone.equals(new LandlordPhone("995")));
    }
}
