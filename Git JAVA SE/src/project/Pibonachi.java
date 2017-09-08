package project;

public class Pibonachi {

	public static void main(String[] args) {

		int a = 1, b = 1;
		int c = a + b;   // 1 1 2 - a b c
		
		System.out.print(a + " ");
		System.out.print(b + " ");
		while(c < 100 ) {
			System.out.print(c + " ");
			a = b;
			b = c;
			c = a + b;
		}

	}

}
