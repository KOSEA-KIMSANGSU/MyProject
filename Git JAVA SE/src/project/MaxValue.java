package project;

public class MaxValue {
	public static void main(String[] args) {
		int[] a = {55, 31, 88, 66, 18, 6, 10};
		int max = a[0], min=a[0];

		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		for(int i=1; i<a.length; i++) {
			if(a[i] > max)
				max = a[i];
		}
		
		for(int i=1; i<a.length; i++) {
			if(a[i] < min)
				min = a[i];
		}
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}

}
