package firstpro;

import java.util.Scanner;

public class percent {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = input();
		print(sum);
		System.out.println(Math.sqrt(sum));

	}

	static int mark1, mark2, result;
/**
 * this method performs addition function
 * @return
 */
	public static int input() {

		mark1 = sc.nextInt();
		mark2 = sc.nextInt();
		result = mark1 + mark2;
		return result;

	}
	public static void print(int sum)
	{
		System.out.println(sum);
		System.out.println(area.);
	}

}
