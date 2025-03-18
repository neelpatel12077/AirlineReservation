package validation;

public class CustomerValidation {
	public static boolean validatePassengerId(int passengerId) {
		if (passengerId > 0) {
			return true;
		} else {
			System.out.println("Invalid passengerId. It should be a positive integer.");
			return false;
		}
	}

	public static boolean validatePassengerName(String passenger_name) {
		if (passenger_name != null && !passenger_name.trim().isEmpty() && passenger_name.matches("[A-Za-z ]+")) {
			return true;
		} else {
			System.out.println("Invalid passenger name. Name should only contain alphabets and spaces.");
			return false;
		}
	}

	public static boolean validatePassengerMobile(long passenger_mobile) {
		String mobileString = String.valueOf(passenger_mobile);
		if (mobileString.length() == 10 && mobileString.matches("[0-9]+")) {
			return true;
		} else {
			System.out.println("Invalid passenger mobile. It should be a 10-digit number.");
			return false;
		}
	}

	public static boolean validatePassengerAddress(String passenger_address) {
		if (passenger_address != null && !passenger_address.trim().isEmpty()) {
			return true;
		} else {
			System.out.println("Invalid passenger address. Address should not be empty.");
			return false;
		}
	}

	public static boolean validatePassenger(int passengerId, String passenger_name, long passenger_mobile,
			String passenger_address) {
		boolean isIdValid = validatePassengerId(passengerId);
		boolean isNameValid = validatePassengerName(passenger_name);
		boolean isMobileValid = validatePassengerMobile(passenger_mobile);
		boolean isAddressValid = validatePassengerAddress(passenger_address);

		return isIdValid && isNameValid && isMobileValid && isAddressValid;
	}
}
