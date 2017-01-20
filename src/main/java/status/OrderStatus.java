package status;

public enum OrderStatus {

	CREATED("Created"),
	CONFIRMED("Confirmed"),
	FAILED("Failed"),
	PENDING("Pending");
	
	private String status;

	public String getStatus() {
		return status;
	}

	private  OrderStatus(final String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		return this.status;
	}
	
	public String getName(){
		return this.name();
	}
	
	
}
