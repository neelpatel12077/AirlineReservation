package entity;

public class Booking {
	private int bookingId;
	private int flightId;
	private int passengerId;
	private String dateBooking;

	public Booking(int bookingId, int flightId, int passengerId, String dateBooking) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.passengerId = passengerId;
		this.dateBooking = dateBooking;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(String dateBooking) {
		this.dateBooking = dateBooking;
	}

}
