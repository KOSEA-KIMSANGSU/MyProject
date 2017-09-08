package project;

public class SwitchExam {

	public static void main(String[] args) {
		
		int sw=0, result=0;
		
		for(int i=1; i<=49; i++) {
			
			if(sw ==0) {
				System.out.print(i+" ");
				result += i;
				sw = 1;
			}
			else {
				System.out.print(i+" ");
				result -= i;
				sw = 0;
			}	
		}
			System.out.println(result);
	}
}
