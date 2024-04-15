package simplejava;

import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.println("Enter any number");
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		if(n%2==0)
			System.out.println("enter number is prime number");
		else
			System.out.println("your enter number is not a prime number");
		

	}

}
