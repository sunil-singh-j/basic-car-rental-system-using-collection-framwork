package car_rantal_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystems {
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental>rentals;
	public CarRentalSystems() {
		super();
		this.cars = new ArrayList<Car>() ;
		this.customers = new ArrayList<Customer>();
		this.rentals = new ArrayList<Rental>();
	}
	public void addCar(Car car) {
		cars.add(car);
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	public void rentCar(Car car,Customer customer,int days) {
		if(car.isAailablel()) {
			car.rent();
			rentals.add(new Rental(car,customer,days));
		}else {
			System.out.println("Car is not availabe for rent.");
		}
		
	}
	
	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove=null;
		for(Rental rental:rentals) {
			if(rental.getCar()==car) {
			rentalToRemove=rental;
			break;
			}
			
		}
		if(rentalToRemove!=null) {
			rentals.remove(rentalToRemove);
			System.out.println("car returned sucessfully. ");
		}
		else {
			System.out.println("car was not rented");
		}
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== Car Rental System====");
			System.out.println("1 . Rent a Car");
			System.out.println("2 . Return a Car");
			System.out.println("3 . Exit");
			System.out.println("Enter your choice: ");
			
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==1) {
				System.out.println("\n == Rent a Car==\n");
				System.out.print("Enter your name: ");
				String customerName=sc.nextLine();
				
				System.out.println("\n== Availabe Cars:");
				for(Car car:cars) {
					if(car.isAailablel()) {
						System.out.println(car.getCarId() + " - "+car.getBrand()+ " "+car.getModel());
					}
				}
				System.out.print("\n Enter the car Id you want to rent : ");
				String carId=sc.nextLine();
				
				System.out.print(" Enter the number of days you for rent : ");
				int rentalDays=sc.nextInt();
				sc.nextLine();
				Customer newCustomer=new Customer("cus"+ (customers.size()+1),customerName);
				addCustomer(newCustomer);
				
				Car selectedCar=null;
				for(Car car:cars) {
					if(car.getCarId().equals(carId)&&car.isAailablel()) {
						selectedCar =car;
						break;
					}
				}
				if(selectedCar!=null) {
					double totalPrice=selectedCar.calculatePrice(rentalDays);
					System.out.println("\n== Rental Information ==\n");
					System.out.println("Customer Id: "+newCustomer.getCustomerId());
					System.out.println("Customer Name: "+newCustomer.getName());
					System.out.println("Car: "+ selectedCar.getBrand()+"  "+selectedCar.getModel());
					System.out.println("Rental Days: "+rentalDays);
					System.out.print("Total Price: $"+totalPrice);
					System.out.print("\n confirm rental (Y/N): ");
					
					
					String confirm=sc.nextLine();
					System.out.println("yes or no");
					if(confirm.equalsIgnoreCase("Y")) {
						rentCar(selectedCar, newCustomer,rentalDays);    
						System.out.println("\n Car rented successfully. ");
						
					}else {
						System.out.println("\n Car rented canceled. ");
					}
					
					 
				}else {
					System.out.println("\n Invalid car selection or car not avialable for rent.");
				}
			}	else if(choice==2) {
				System.out.println("\n == Return a car==\n");
				System.out.println("Enter the car Id you want to return: ");
				String carid=sc.nextLine();
				
				Car carToReturn=null;
				for(Car car:cars) {
					if(car.getCarId().equals(carid) && !car.isAailablel()) {
						carToReturn=car;
						break;
					}
				}
				if(carToReturn!=null) {
					Customer customer=null;
					for(Rental retal:rentals) {
						if(retal.getCar()==carToReturn) {
							customer=retal.getCustomer();
							break;
						}
					}
					if(customer!=null) {
					returnCar(carToReturn);
					System.out.println("car returned successfully by "+customer.getName());
					}else {
						System.out.println("car was not rented or rental information is missing.");
					}
			} else {
				System.out.println("Invalid car Id or car is not rented");
			}
		}else if(choice==3) {
			break;
		}else {
			System.out.println("Invalid choice. Please enter a valid option");
		}	
	}
		System.out.println("\n Thank you for using the car Rental System!");
	}
}
