package entity;

public class Customer {
	private int passengerId;
	private String passenger_name;
	private long passenger_mobile;
	private String passenger_address;

	public Customer(int passengerId, String passenger_name, long passenger_mobile, String passenger_address) {
		super();
		this.passengerId = passengerId;
		this.passenger_name = passenger_name;
		this.passenger_mobile = passenger_mobile;
		this.passenger_address = passenger_address;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public long getPassenger_mobile() {
		return passenger_mobile;
	}

	public void setPassenger_mobile(long passenger_mobile) {
		this.passenger_mobile = passenger_mobile;
	}

	public String getPassenger_address() {
		return passenger_address;
	}

	public void setPassenger_address(String passenger_address) {
		this.passenger_address = passenger_address;
	}

}
