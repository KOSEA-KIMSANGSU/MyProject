package project;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("첫번째 수 입력?");
		num1 = scan.nextInt();
		
		System.out.println("두번째 수 입력?");
		num2 = scan.nextInt();
			
		System.out.println("입력결과");
		System.out.printf("덧셈 %d + %d = %d \n", num1, num2, num1 + num2);
		System.out.printf("뺄셈 %d + %d = %d \n", num1, num2, num1 - num2);
		
	}
}
