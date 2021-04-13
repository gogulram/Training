package firstpro;
import java.util.*;
public class area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the vlaue");
		int val=sc.nextInt();
		System.out.println(area(val));
		
	}
	
	public static double area(int val)
	{
		double area=Math.PI*val*val;
		return area;
	}
	

}
