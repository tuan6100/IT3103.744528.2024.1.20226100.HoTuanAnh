package hust.soict.itep.lab01.problem_6_5;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the length of array: ");
        int n = sc.nextInt();
        NumericArray numericArray = new NumericArray(n);
        System.out.print("Input " + n + " elements of array: ");
        numericArray.setArray(n);
        System.out.print("Your Array: ");
        numericArray.display();
        System.out.print("Sorted Array: ");
        numericArray.sort();
        numericArray.display();
        System.out.println("Sum: " + numericArray.getSum());
        System.out.println("Average: " + numericArray.getAverage());
        sc.close();
    }
}
