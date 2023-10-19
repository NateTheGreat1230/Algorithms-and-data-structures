import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String first = scan.nextLine();
        System.out.print("Enter the second string: ");
        String second = scan.nextLine();
        System.out.println("Matched at index: " + Analyse(first, second));
    }
    public static String Analyse(String first, String second) {
        int place = 0;
        int numCorrect = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == second.charAt(0) && numCorrect == 0) {
                numCorrect++;
                place = i;
            } else if (first.charAt(i) == second.charAt(numCorrect)) {
                numCorrect++;
            } else {
                numCorrect = 0;
                place = 0;
            }
            if (numCorrect == second.length()) {
                break;
            }
        }
        if (place != 0 || numCorrect != 0) {
            return String.valueOf(place);
        } else {
            return "Not a substring";
        }
    }
}