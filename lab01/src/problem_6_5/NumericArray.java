package problem_6_5;
import java.util.*;

public class NumericArray {
    private int[] arr;
    private int length;

    public NumericArray() {
        this.arr = new int[100];
        this.length = 0;
    }
    public NumericArray(int[] arr) {
        this.arr = arr;
        this.length = arr.length;
    }
    public NumericArray(int n) {
        this.arr[length++] = n;
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
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
