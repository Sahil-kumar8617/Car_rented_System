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

class rental {
    private Car car;
    private Customer customer;
    private int days;

    public rental(Car car,Customer customer,int days){
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
    private ArrayList<rental>rentals; 

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
        rentals.add(new rental(car,customer,days));
    }
    else{
        System.out.println("car is not available for rent.");
    }

    public void returnCar(Car car){
        


    }





    }



}

 // main class from where all the constructer and method is being initialized
class Main{
    public static void main(String args[]){
        
    }
}




