package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FlightValidation {
	public static boolean validateFlightId(int flight_Id) {
		if (flight_Id > 0) {
			return true;
		} else {
			System.out.println("Invalid flightId. It should be a positive integer.");
			return false;
		}
	}

	public static boolean validateFlightSourceDestination(String sourceOrDestination) {
		if (sourceOrDestination != null && !sourceOrDestination.trim().isEmpty()
				&& sourceOrDestination.matches("[A-Za-z ]+")) {
			return true;
		} else {
			System.out.println("Invalid source/destination. It should contain only alphabetic characters and spaces.");
			return false;
		}
	}

	public static boolean validateFlightDateTime(String flight_date_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);

		try {
			sdf.parse(flight_date_time);
			return true;
		} catch (ParseException e) {
			System.out.println("Invalid date-time format. The correct format is yyyy-MM-dd HH:mm:ss.");
			return false;
		}
	}

	public static boolean validateFlightFare(float flight_fare) {
		if (flight_fare > 0) {
			return true;
		} else {
			System.out.println("Invalid flight fare. It should be a positive value.");
			return false;
		}
	}

	public static boolean validateFlight(int flight_Id, String flight_source, String flight_destination,
			String flight_start_date_time, String flight_end_date_time, float flight_fare) {
		boolean isFlightIdValid = validateFlightId(flight_Id);
		boolean isSourceValid = validateFlightSourceDestination(flight_source);
		boolean isDestinationValid = validateFlightSourceDestination(flight_destination);
		boolean isStartDateTimeValid = validateFlightDateTime(flight_start_date_time);
		boolean isEndDateTimeValid = validateFlightDateTime(flight_end_date_time);
		boolean isFareValid = validateFlightFare(flight_fare);

		return isFlightIdValid && isSourceValid && isDestinationValid && isStartDateTimeValid && isEndDateTimeValid
				&& isFareValid;
	}
}
