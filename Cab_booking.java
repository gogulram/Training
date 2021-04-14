package ola;

import java.util.*;

public class Cab_booking {
	static Scanner sc = new Scanner(System.in);
    static int cabtype,kiloMeter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		typeOfCar();

	}

public static void typeOfCar()
{
	 System.out.println("Choose type of car");
     System.out.println("Small-> 1");
     System.out.println("Big-> 2");
     
     cabtype=sc.nextInt();
    
     if(cabtype==1)
     {
    	 small();
    }
     else if(cabtype==2)
     {   
    	 Big();
     }
     else
     {
      System.out.println("Not available"); 
     }
	
}
public static void small()
{
	 System.out.println("Enter the Kilometers:");
	 kiloMeter=sc.nextInt();
	int price=kiloMeter*10;
	System.out.println("Total price is " + price);
	
}
public static void Big()
{    System.out.println("Enter the Kilometers:");
	kiloMeter=sc.nextInt();
	int price=kiloMeter*15;
	System.out.println("Total price is " + price);
}
}
