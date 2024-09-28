package problem_6_5;
import java.util.*;

public class NumericArray {
    private int[] arr;

    public NumericArray(int n) {
        this.arr = new int[n];
    }

    public void setArray(int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            this.arr[i] = sc.nextInt();
        }
    }

    public int[] sort() {
        Arrays.sort(arr);
        return arr;
    }

    public int getSum() {
        return Arrays.stream(arr).sum();
    }

    public double getAverage() {
        return (double) getSum() / arr.length;
    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
