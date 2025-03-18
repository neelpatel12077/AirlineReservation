package entity;

public class Flight {
	private int flight_Id;
	private String flight_source;
	private String flight_destination;
	private String flight_start_date_time;
	private String flight_end_date_time;
	private float flight_fare;

	public Flight(int flight_Id, String flight_source, String flight_destination, String flight_start_date_time,
			String flight_end_date_time, float flight_fare) {
		super();
		this.flight_Id = flight_Id;
		this.flight_source = flight_source;
		this.flight_destination = flight_destination;
		this.flight_start_date_time = flight_start_date_time;
		this.flight_end_date_time = flight_end_date_time;
		this.flight_fare = flight_fare;
	}

	public int getFlight_Id() {
		return flight_Id;
	}

	public void setFlight_Id(int flight_Id) {
		this.flight_Id = flight_Id;
	}

	public String getFlight_source() {
		return flight_source;
	}

	public void setFlight_source(String flight_source) {
		this.flight_source = flight_source;
	}

	public String getFlight_destination() {
		return flight_destination;
	}

	public void setFlight_destination(String flight_destination) {
		this.flight_destination = flight_destination;
	}

	public String getFlight_start_date_time() {
		return flight_start_date_time;
	}

	public void setFlight_start_date_time(String flight_start_date_time) {
		this.flight_start_date_time = flight_start_date_time;
	}

	public String getFlight_end_date_time() {
		return flight_end_date_time;
	}

	public void setFlight_end_date_time(String flight_end_date_time) {
		this.flight_end_date_time = flight_end_date_time;
	}

	public float getFlight_fare() {
		return flight_fare;
	}

	public void setFlight_fare(float flight_fare) {
		this.flight_fare = flight_fare;
	}

}
