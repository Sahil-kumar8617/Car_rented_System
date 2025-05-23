                                      // Project based on the all the OOPS concept 
import java.util.*;
import java.util.Scanner;
import java.util.List;

class Car {
    Scanner sc=new Scanner(System.in);
    private String CarID;
    private String CarModel;
    private String CarBrand;
    private double BasePrice;
    private Boolean isAvailable;

    public  Car(String CarID, String CarModel,String CarBrand,Integer BasePrice,Boolean Availability){
       this.CarID=CarID;
       this.CarModel=CarModel;
       this.CarBrand=CarBrand;
       this.BasePrice=BasePrice;
       this.isAvailable=true;

    }
    public void getDetail(){ // to get all the deail by one click 
        System.out.println(CarID);
        System.out.println(CarModel);
        System.out.println(CarBrand);
        System.out.println(BasePrice);
        System.out.println(isAvailable);
    }


    public String getCarID(){
        return CarID;
    }
    
    public String  getCarModel(){
        return CarModel;
    }
    public String  getCarBrand(){
        return CarBrand;
    }
    public double getCBasePrice(){
        return BasePrice;
    }
    public Boolean isAvailabel(){
        return isAvailable;
    }
    public void carRent(){
       isAvailable=false;
    }
    public void returnCar(){
        isAvailable=true;
    }

    public double CalculatePrice(int rentalDays){
        
        return rentalDays*BasePrice; // this will calculate the price of the rent car based on the days a customer wanted to rent 



    }
}

 class Customer{
   private  String CustomerName;
   private  int CustomerID;
   private int CustomerAadharCard;
   private   int CustomerMobileNumber;

   public Customer(String CustomerName,int CustomerID,int CustomerAadharCard,int CustomerMobileNumber){
    this.CustomerName=CustomerName;
    this.CustomerID=CustomerID;
    this.CustomerAadharCard=CustomerAadharCard;
    this.CustomerMobileNumber=CustomerMobileNumber;
   }
    public String getCustomerName(){
        return CustomerName;
    }
    public int CustomerID(){
        return CustomerID;
    }
    public int CustomerAadharCard(){
        return CustomerAadharCard;
    }
    public int CustomerMobileNumber(){
        return CustomerMobileNumber;
    }

    

}

class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car,Customer customer,int days){
     this.car=car;
     this.customer=customer;
     this.days=days;
    }

    

    public Car getCar(){
        return car;

    }
    public Customer getCustomer(){
        return customer;
    }
    public int getdays(){
        return days;
    }

}

class CarRentalSystem{
    private ArrayList<Car> cars;
    private ArrayList<Customer>customers;
    private ArrayList<Rental>rentals; 

    public CarRentalSystem(){ // empty arraylist to store the each objects value
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();


    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer( Customer customer){
        customers.add(customer);
        
    }

    public void rentCar(Car car, Customer customer,int days){
    if(car.isAvailabel()){
        car.carRent();
        rentals.add(new Rental(car,customer,days));
    }
    else{
        System.out.println("car is not available for rent.");
    }
}

    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove=null;
        for(Rental rental : rentals){
            if(rental.getCar()==car){
                rentalToRemove=rental;
                break;
        }
    }


    if(rentalToRemove !=null){
        rentals.remove(rentalToRemove);
        System.out.println("car returned successfully");

    }else{
        System.out.println("car was not rented");
    }
    }

    public void menu(){ // menu which will be the first interface which is being seen by the user to move forward in car rental system.
        Scanner sc=new Scanner(System.in);
        
        while(true){ // this will work in a way that until the user did not choose the 3 means Exit button these option will be there in his screen every time for choosing any of the features.

            System.out.println("******* Car rental System *******");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return  a car");
            System.out.println("3. Exist");
            System.out.println("Enter your choice ");

            int choice =sc.nextInt();
            sc.nextLine();

            if(choice==1){
                System.out.println("*********rent a car*********");
                System.out.println("enter your name:");
                String customerName=sc.nextLine();

                System.out.println("Available cars:"); // this will  show the deatil of the cars which is present in the garage
                for(Car car :cars){
                    if(car.isAvailabel()){
                        System.out.println(car.getCarID()+"  "+ car.getCarBrand()+" "+car.getCarModel());

                    }
                }

                System.out.println("enter the car id you want to rent:");
                String customerId =sc.nextLine();
                System.out.println("enter aadhar number:");
                long aadhar =sc.nextLong();

                System.out.println("enter mobile number:");
                long mobile =sc.nextLong();
                sc.nextLine();

                System.out.println("enter the number of days you need car for rent:");
                int rentalDays=sc.nextInt();
                sc.nextLine();

                Customer newCustomer=new Customer(customerName, rentalDays, choice, rentalDays);
               
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarID().equals(customerId) && car.isAvailabel()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
              
                    double totalPrice = selectedCar.CalculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.CustomerID());
                    System.out.println("Customer Name: " + newCustomer.getCustomerName());
                    System.out.println("Car: " + selectedCar.getCarBrand() + " " + selectedCar.getCarModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Car ==\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = sc.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarID().equals(carId) && !car.isAvailabel()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " );
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car ID or car is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Car Rental System!");
    }

}


public class Main{
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "KiA", "KTM", 15000, true); // Different base price per day for each car
        Car car2 = new Car("C002","i20","Hyundai",12000,true);
        Car car3 = new Car("C003","NExon","TATA",20000,true);
        Car car4 = new Car("C004","Verna","Hyundai",9100,true);
        Car car5 = new Car("C005","maruti suzuki","Suzuki",100,true);
        

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);

        rentalSystem.menu();
        
    }
}




