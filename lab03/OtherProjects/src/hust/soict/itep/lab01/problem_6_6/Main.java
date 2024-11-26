package hust.soict.itep.lab01.problem_6_6;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Matrix mat1 = new Matrix();
        Matrix mat2 = new Matrix();
        int r1, c1, r2, c2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the first matrix: ");
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        System.out.println("Enter the first matrix:");
        mat1.setMatrix(r1, c1);

        System.out.print("Enter the number of rows and columns of the second matrix: ");
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        System.out.println("Enter the second matrix:");
        mat2.setMatrix(r2, c2);

        try {
            Matrix result = mat1.add(mat2);
            System.out.println("The result of matrix addition is:");
            result.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        sc.close();  
    }
}
