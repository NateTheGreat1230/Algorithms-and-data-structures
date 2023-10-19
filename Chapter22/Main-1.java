import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scan.nextLine();
        System.out.println("The maximum consecutive substring is: " + Analyse(input));
    }
    public static String Analyse(String input) {
        LinkedList<Character> finalList = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            LinkedList<Character> tempList = new LinkedList<>();
            tempList.add(input.charAt(i));
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(j) > tempList.getLast()) {
                    tempList.add(input.charAt(j));
                }
            }
            if (finalList.size() < tempList.size()) {
                finalList.clear();
                finalList.addAll(tempList);
                tempList.clear();
            } else {
                tempList.clear();
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < finalList.size(); i++) {
            output.append(finalList.get(i));
        }
        return output.toString();
    }
}