import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String,String> stateCapital = new HashMap<String, String>() {{
            put("Alabama", "Montgomery");
            put("Alaska", "Juneau");
            put("Arizona", "Phoenix");
            put("Arkansas", "Little Rock");
            put("California", "Sacramento");
            put("Colorado", "Denver");
            put("Connecticut", "Hartford");
            put("Delaware", "Dover");
            put("Florida", "Tallahassee");
            put("Georgia", "Atlanta");
            put("Hawaii", "Honolulu");
            put("Idaho", "Boise");
            put("Illinois", "Springfield");
            put("Indiana", "Indianapolis");
            put("Iowa", "Des Moines");
            put("Kansas", "Topeka");
            put("Kentucky", "Frankfort");
            put("Louisiana", "Baton Rouge");
            put("Maine", "Augusta");
            put("Maryland", "Annapolis");
            put("Massachusettes", "Boston");
            put("Michigan", "Lansing");
            put("Minnesota", "Saint Paul");
            put("Mississippi", "Jackson");
            put("Missouri", "Jefferson City");
            put("Montana", "Helena");
            put("Nebraska", "Lincoln");
            put("Nevada", "Carson City");
            put("New Hampshire", "Concord");
            put("New Jersey", "Trenton");
            put("New York", "Albany");
            put("New Mexico", "Santa Fe");
            put("North Carolina", "Raleigh");
            put("North Dakota", "Bismarck");
            put("Ohio", "Columbus");
            put("Oklahoma", "Oklahoma City");
            put("Oregon", "Salem");
            put("Pennsylvania", "Harrisburg");
            put("Rhode Island", "Providence");
            put("South Carolina", "Columbia");
            put("South Dakota", "Pierre");
            put("Tennessee", "Nashville");
            put("Texas", "Austin");
            put("Utah", "Salt Lake City");
            put("Vermont", "Montpelier");
            put("Virginia", "Richmond");
            put("Washington", "Olympia");
            put("West Virginia", "Charleston");
            put("Wisconsin", "Madison");
            put("Wyoming", "Cheyenne");
        }};


        Scanner input = new Scanner(System.in);

        int correctCount = 0;

        for (Map.Entry<String, String> list : stateCapital.entrySet()) {
            // Prompt the user with a question
            System.out.print("What is the capital of " + list.getKey() + "? ");
            String capital = input.nextLine().trim().toLowerCase();

            if (capital.toLowerCase().equals(list.getValue().toLowerCase())) {
                System.out.println("Your answer is correct");
                correctCount++;
            }
            else
                System.out.println("The correct answer should be " + list.getValue());
        }

        System.out.println("The correct count is " + correctCount);
    }
}