package car_rantal_system;

public class Main {
	public static void main(String[] args) {
		CarRentalSystems rentalSystem=new CarRentalSystems();
		Car car1 =new Car("C001","Toyota","Carry",60.0);
		Car car2 =new Car("C002","Honda","Accord",67.0);
		Car car3 =new Car("C003","Mahindra","Thar",80.0);
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);
		rentalSystem.menu();
	}

}
