package hust.soict.itep.lab01.problem_6_5;
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

    public void sort() {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] array, int low, int high) {
        if (low < high) {            
            int p = partition(array, low, high);
            quicksort(array, low, p - 1);
            quicksort(array, p + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; 
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public int getSum() {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
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
