package problem_6_3;
import java.util.*; 
class Triangle { 
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in); 
		System.out.print("Input the number of rows to be printed: "); 
		int n = sc.nextInt(); 

		for (int i = 1; i <= n; i++) { 
			for (int j = n; j >= i; j--) { 
				System.out.print(" "); 
			} 
			for (int j = 1; j <= i; j++) { 
				System.out.print("* "); 
			} 
			System.out.println(); 
		} 
        sc.close();
	} 
} 
