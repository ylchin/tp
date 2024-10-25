package seedu.address.model.property;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Property's landlord's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class LandlordPhone {


    public static final String MESSAGE_CONSTRAINTS =
            "LandlordPhone numbers should only contain numbers, and it should be at least 3 digits long";
    public static final String VALIDATION_REGEX = "\\d{3,}";
    public final String value;

    /**
     * Constructs a {@code LandlordPhone}.
     *
     * @param phone A valid phone number.
     */
    public LandlordPhone(String phone) {
        requireNonNull(phone);
        checkArgument(isValidPhone(phone), MESSAGE_CONSTRAINTS);
        value = phone;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LandlordPhone)) {
            return false;
        }

        LandlordPhone otherLandlordPhone = (LandlordPhone) other;
        return value.equals(otherLandlordPhone.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
