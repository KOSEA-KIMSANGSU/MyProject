package project;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("ù��° �� �Է�?");
		num1 = scan.nextInt();
		
		System.out.println("�ι�° �� �Է�?");
		num2 = scan.nextInt();
			
		System.out.println("�Է°��");
		System.out.printf("���� %d + %d = %d \n", num1, num2, num1 + num2);
		System.out.printf("���� %d + %d = %d \n", num1, num2, num1 - num2);
		
	}
}
