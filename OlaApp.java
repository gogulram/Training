package com.gokul;

import java.time.*;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

public class OlaApp {
static int fare=0;
static int senior_age;
static  double peakval=0;
static String cabtype;
static String picTime,jdate;
static double amtaftrgst;
static double discount=0;
	public static void main(String[] args) {
	login();
	}
// login page ------>level-1
	public static void login()
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("----------Login Page Ola ----------");
	System.out.println("Enter your mobile number:");
	long Mobnum=sc.nextLong();
	String mobstr=String.valueOf(Mobnum);
	if(mobstr.length()!=10)
	{
		System.out.println("----Invalid number-----");
	}
	System.out.println("Enter your password:");
    String password=sc.next();
    
    if(password.length()<8)
    {
    	System.out.println("-----Password must contain 8 letters---");
    }
    else
    {
    	System.out.println("*******Sucessfully Logged in********");
    }
     cab_types();
	}
    //cab_types ------->level2
    public static void cab_types(){

		String[] cabTypes=new String[3];
		cabTypes[0]="1:micro-(10rupees km/hr)";
		cabTypes[1]="2:mini-(15rupees km/hr)";
		cabTypes[2]="3:prime-(20rupees km/hr)";
		System.out.println("Number of cars available are: ");
	    System.out.println("-----> "+ cabTypes.length);
		System.out.println("Types of car available are: ");
		for(String car:cabTypes)
		{
			System.out.println("  "+car);
		}
      price_Estimation();
    }
    //price_estimation ------>level3
    public static void price_Estimation()
    {
    	 Scanner sc=new Scanner(System.in);
 		System.out.println("Enter your preferred car type:  ");
 		  cabtype=sc.next();
 		System.out.println("Enter the number of kilometers:  ");
 	     int km=sc.nextInt();
 	    
 	     if(cabtype.equalsIgnoreCase("micro"))
 	     {
 	    	 fare=km*10;
 	    	 System.out.println("Total amount before tax is"+fare);
 	     }
 	     else if(cabtype.equalsIgnoreCase("mini"))
 	     {
 	    	 fare=km*15;
 	    	System.out.println("Total amount before tax is"+fare); 
 	     }
 	     else if(cabtype.equalsIgnoreCase("prime"))
 	     {
 	    	 fare=km*20;
 	    	 System.out.println("Total amount before tax is "+fare);
 	    	 
 	     }
 	     gst();
    }
    //gst calculation----->level4
    public static void gst()
    {
    	double gst_val=(fare*7)/100.0;
        System.out.println("Gst for this ride is "+gst_val);
         System.out.println("Total amount after gst is "+(gst_val+fare));
         booking();
    }
    // booking------>level5
    public static void booking()
    {
    	Scanner sc=new Scanner(System.in);
	/*	System.out.println("Enter the cab type: ");
		String cabType=sc.next();*/
		System.out.println("Enter the journeydate in this format(yyyy-mm-dd):");
		 jdate=sc.next();
		LocalDate journeydate=LocalDate.parse(jdate);
		LocalDate currDate=LocalDate.now();
		if(journeydate.isBefore(currDate))
		{
			System.out.println("------Please Enter valid date------ ");
		}
		else {
			System.out.println("Valid Date");
		}
	    System.out.println("Enter the pickupTime in format(hh:mm:ss): ");
	    picTime=sc.next();
	    LocalTime cabPickupTime=LocalTime.parse(picTime);
	    LocalTime currTime=LocalTime.now();
	    if(cabPickupTime.isBefore(currTime))
	    {
	    	System.out.println("-----Please Enter a valid time------");
	    }
	    else
	    {
	    	System.out.println("------Valid Time------");
	    }
	    peakhours();
	    
		}
    //peakhours-------->level6
    public static void peakhours()
    {
    
        LocalTime peak=LocalTime.parse(picTime);
        int peakhr=peak.getHour();
       
        if(peakhr>=17&&peakhr<=19)
        {
        	peakval=(fare*1.25)/100;
        	
        }
        System.out.println("price during peakhours is "+peakval);
       System.out.println("Total amount after peak hours added is "+(fare+peakval));
       senior_citizen();
    }
    //senior_citizen------>level7
    public static void senior_citizen()
    {
    	Scanner sc=new Scanner(System.in);
		System.out.println("Enter date of birth in this format(yyyy-mm-dd):");
	    String dob=sc.nextLine();
		LocalDate birthday=LocalDate.parse(dob);
		LocalDate today= LocalDate.now();
		System.out.println((today));
		Period p= Period.between(birthday,today);
		System.out.println("Your age is: ");
		System.out.print(p.getYears()+"years"+"  ");
		System.out.print(p.getMonths()+"months"+"  ");
		System.out.println(p.getDays()+"days"+"  ");
		senior_age=p.getYears();
	   
	   // int fare=0;
		if(senior_age>=60)
		{
			
		     discount=(fare*50)/100.0;
		System.out.println("50% discount for people above 60");
		System.out.println("----discount for senior citizens is----"+discount);
		}
	
        LocalTime peak=LocalTime.parse(picTime);
        int peakhr=peak.getHour();
        double peakval=0;
        if(peakhr>=17&&peakhr<=19)
        {
        	peakval=(discount*1.25)/100.0;
        	
        }
      double amtaftrpk=peakval+discount;
      System.out.println("-----Amount after peakhour value added is----- "+amtaftrpk);
       amtaftrgst=(amtaftrpk*7)/100.0;
      System.out.println("-----Amount after gst added is----"+amtaftrgst+discount);
       System.out.println("---Total amount after peak hours,senior citizen discount,gst,added is "+(amtaftrgst+discount));
       payment();
	
    }
    //payment card expiry date verification---------level8
    
    public static void payment()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter card Expiry date in format(yyyy-mm-dd):");
		String card=sc.next();
		LocalDate expiry=LocalDate.parse(card);
		LocalDate today=LocalDate.now();
		if(expiry.isBefore(today))
		{
			System.out.println("--------card expired--------");
		}
		else
		{
			billing();
		}
			
    }
    public static void billing()
    {
    	System.out.println("----car type---->"+cabtype);
    	System.out.println( "*****");
    	System.out.println("----JourneyDate----"+jdate);
    	System.out.println( "*****");
    	System.out.println("----PickupTime----"+ picTime);
    	System.out.println( "*****");
    	if(senior_age>=60)
    		System.out.println("----Total Amount Payable is ----"+(amtaftrgst+discount));
    	else
    		System.out.println("----Total Amount Payable is ----"+peakval);
    	
    	
    }
    
    }
    
	

