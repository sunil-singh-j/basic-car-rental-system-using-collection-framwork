package car_rantal_system;

public class Car {

	private String CarId;
	
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAailablel;
	public Car(String carId, String brand, String model, double basePricePerDay) {
		super();
		CarId = carId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAailablel = true;
	}
	public String getCarId() {
		return CarId;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public double calculatePrice(int rentalDays) {
		return basePricePerDay*rentalDays;
	}
	public boolean isAailablel() {
		return isAailablel;
	}
	public void rent() {
		isAailablel=false;
	}
	public void returnCar() {
		isAailablel=true;
	}
	
}

