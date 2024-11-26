package hust.soict.itep.lab01.problem_6_4;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Calendar;


public class DaysOfMonth {

    private List<String[]> monthsList = Arrays.asList(
        new String[]{"January", "Jan.", "Jan", "1"},
        new String[]{"February", "Feb.", "Feb", "2"},
        new String[]{"March", "Mar.", "Mar", "3"},
        new String[]{"April", "Apr.", "Apr", "4"},
        new String[]{"May", "May.", "May", "5"},
        new String[]{"June", "Jun.", "Jun", "6"},
        new String[]{"July", "Jul.", "Jul", "7"},
        new String[]{"August", "Aug.", "Aug", "8"},
        new String[]{"September", "sept.", "sept", "9"},
        new String[]{"October", "Oct.", "Oct", "10"},
        new String[]{"November", "Nov.", "Nov", "11"},
        new String[]{"December", "Dec.", "Dec", "12"}
    );
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        System.out.print("Enter year: ");
        int year = sc.nextInt(); 
        calendar.set(Calendar.YEAR, year);
        System.out.print("Enter month: ");
        String month = sc.next();
        month = month.trim();

        int monthNumber = -1;
        for (String[] monthNames : new DaysOfMonth().monthsList) {
            for (String name : monthNames) {
            if (name.equalsIgnoreCase(month)) {
                monthNumber = Integer.parseInt(monthNames[3]) - 1;
                break;
            }
            }
            if (monthNumber != -1) break;
        }

        if (monthNumber == -1) {
            System.out.println("Invalid month input.");
        } else {
            calendar.set(Calendar.MONTH, monthNumber);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            String monthName = "";
            for (String[] monthNames : new DaysOfMonth().monthsList) {
                if (Integer.parseInt(monthNames[3]) - 1 == monthNumber) {
                    monthName = monthNames[0];
                    break;
                }
            }
            System.out.println("Month: " + monthName + " - Number of days: " + daysInMonth + "\n");
        }
        sc.close();
    }
   
}

