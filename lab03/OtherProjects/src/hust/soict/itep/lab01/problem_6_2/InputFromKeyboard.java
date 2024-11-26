package hust.soict.itep.lab01.problem_6_2;

import java.util.*;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your name?");
        String strName = sc.nextLine();
        System.out.println("How old are you?");
        int age = sc.nextInt();
        System.out.println("How tall are you?");
        double height = sc.nextDouble();

        System.out.println("Mrs/Ms" + strName + ", " + age + " year old. " + "Your height is " + height + ".");
    }
}
