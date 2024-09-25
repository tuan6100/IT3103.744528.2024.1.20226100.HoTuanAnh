package problem2_2_6;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String listOptions = "List avaible options:\n"+
                        "0. exit \n" +
                        "1. Solve first degree equation \n" +
                        "2. Solve second degree equation \n" +
                        "3. Solve system of first-degree equation\n" +
                        "Please enter your choice: ";
        
        while (true) {
                System.out.print(listOptions);             
                option = sc.nextInt();
                
                if (option == 0) {
                    System.out.println("Thanks!\n");
                    break;
                } else if (option == 1) {
                    System.out.println("ax + b = 0");
                    try {                       
                        FirstDegreeEquation firstDegreeEquation = new FirstDegreeEquation();
                        firstDegreeEquation.setA();
                        firstDegreeEquation.setB();
                        firstDegreeEquation.solve();
                        // firstDegreeEquation.done();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("\n");
                } else if (option == 2) {
                    System.out.println("ax^2 + bx + c = 0");
                    try {
                        SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation();
                        secondDegreeEquation.setA();
                        secondDegreeEquation.setB();
                        secondDegreeEquation.setC();
                        secondDegreeEquation.solve();
                        // secondDegreeEquation.done();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("\n");
                } else if (option == 3) {
                    System.out.println("a11.x + a12.y = b1");
                    System.out.println("a21.x + a22.y = b2");
                    SystemOfFirstDegreeEquations systemOfFirstDegreeEquations = new SystemOfFirstDegreeEquations();
                    systemOfFirstDegreeEquations.setA11();
                    systemOfFirstDegreeEquations.setA12();
                    systemOfFirstDegreeEquations.setB1();
                    systemOfFirstDegreeEquations.setA21();
                    systemOfFirstDegreeEquations.setA22();
                    systemOfFirstDegreeEquations.setB2();
                    systemOfFirstDegreeEquations.solve();
                    // systemOfFirstDegreeEquations.done();
                    System.out.println("\n");
                }
                else System.out.println("Invalid Option!\n");
            }
        sc.close();
    }
}
