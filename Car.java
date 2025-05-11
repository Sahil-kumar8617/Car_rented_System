// Project based on the all the OOPS concept 
import java.util.*;

class Car {
    private int CarID;
    private String CarModel;
    private String CarBrand;
    private int BasePrice;
    private Boolean Availability;

    public void setDetail(int CarID, String CarModel,String CarBrand,Integer BasePrice,Boolean Availability){
       this.CarID=CarID;
       this.CarModel=CarModel;
       this.CarBrand=CarBrand;
       this.BasePrice=BasePrice;
       this.Availability=true;

    }
    public void getDetail(){ // to get all the deail by one click 
        System.out.println(CarID);
        System.out.println(CarModel);
        System.out.println(CarBrand);
        System.out.println(BasePrice);
        System.out.println(Availability);
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
    public Boolean getAvailability(){
        return Availability;
    }
    



}




