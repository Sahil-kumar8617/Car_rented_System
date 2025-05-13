// Project based on the all the OOPS concept 
import java.util.*;
import java.util.Scanner;

class Car {
    Scanner sc=new Scanner(System.in);
    private int CarID;
    private String CarModel;
    private String CarBrand;
    private int BasePrice;
    private Boolean isAvaialbale;

    public void setDetail(int CarID, String CarModel,String CarBrand,Integer BasePrice,Boolean Availability){
       this.CarID=CarID;
       this.CarModel=CarModel;
       this.CarBrand=CarBrand;
       this.BasePrice=BasePrice;
       this.isAvaialbale=true;

    }
    public void getDetail(){ // to get all the deail by one click 
        System.out.println(CarID);
        System.out.println(CarModel);
        System.out.println(CarBrand);
        System.out.println(BasePrice);
        System.out.println(isAvaialbale);
    }


    public int getCarID(){
        return CarID;
    }
    
    public String  getCarModel(){
        return CarModel;
    }
    public String  getCarBrand(){
        return CarBrand;
    }
    public int getCBasePrice(){
        return BasePrice;
    }
    public Boolean isAvailabel(){
        return isAvaialbale;
    }
    public void carRent(){
       isAvaialbale=false;
    }
    public void returnCar(){
        isAvaialbale=true;
    }

    public double CalculatePrice(){
        System.out.println("enter Number of days you need car for rent:");
        int days=sc.nextInt();
        return days*BasePrice; // this will calculate the price of the rent car based on the days a customer wanted to rent 



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
    public String CustomerName(){
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

class carRentalSystem{
    private ArrayList<Car> cars;
    private ArrayList<Customer>customers;
    private ArrayList<Rental>rentals; 

    public carRentalSystem(){ // empty arraylist to store the each objects value
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

    public void menu(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("******* Car rental System *******");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return  a car");
            System.out.println("3. Exist");
            System.out.println("Enter your choice ");

            int choice =sc.nextInt();
            sc.nextLine();

            if(choice==1){
                System.out.println("rent a car");
                System.out.println("enter your name;");
                String cutomerName=sc.nextLine();

                System.out.println("Available cars:");
                for(Car car :cars){
                    if(car.isAvailabel()){
                        System.out.println(car.getCarID()+"  "+ car.getCarBrand()+" "+car.getCarModel());

                    }
                }
                System.out.println("enter the car id you want to rent:");
                String carID=sc.nextLine();

                System.out.println("enter the number of days fro rent:");
                int rentalDays=sc.nextInt();
                sc.nextLine();

                
                

            }

            
            }
    }
    
}


public class Main{
    public static void main(String[] args) {
        
    }
}




