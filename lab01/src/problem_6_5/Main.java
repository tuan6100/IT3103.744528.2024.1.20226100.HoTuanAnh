package problem_6_5;

public class Main {
    public static void main(String[] args) {
        NumericArray numericArray = new NumericArray(new int[]{1789, 2035, 1899, 1456, 2013});
        System.out.print("Your Array: ");
        numericArray.display();
        System.out.print("Sorted Array: ");
        numericArray.sort();
        numericArray.display();
        System.out.println("Sum: " + numericArray.getSum());
        System.out.println("Average: " + numericArray.getAverage());
    }
}
