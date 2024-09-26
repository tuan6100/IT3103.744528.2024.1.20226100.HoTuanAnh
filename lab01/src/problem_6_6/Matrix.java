package problem_6_6;
import java.util.*;

public class Matrix {
    private int[][] matrix;

    public Matrix() {
        this.matrix = new int[0][0];
    }
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setMatrix(int r, int c) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public void display() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix other) throws IllegalArgumentException {
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            throw new IllegalArgumentException("Matrices are not the same size.");
        }

        int r = matrix.length;
        int c = matrix[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

}
