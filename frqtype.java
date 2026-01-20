import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class StudyBuddy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Topic Data: Topic Name -> Required Keywords
        Map<String, String[]> topics = new HashMap<>();
        topics.put("Facilitated Diffusion", new String[]{"protein", "passive", "high to low"});
        topics.put("Active Transport", new String[]{"ATP", "energy", "against", "gradient"});
        topics.put("Osmosis", new String[]{"water", "membrane", "semi-permeable"});
        topics.put("Hypotonic Solution", new String[]{"swell", "into", "lower solute"});

        System.out.println("--- STRICT BIO STUDY BUDDY ---");
        System.out.println("Explain the following topics in 1-2 sentences. I will be grading harshly.\n");

        for (String topic : topics.keySet()) {
            System.out.println("TOPIC: " + topic);
            System.out.print("> ");
            String studentResponse = scanner.nextLine().toLowerCase();
            
            checkResponse(topic, studentResponse, topics.get(topic));
            System.out.println("------------------------------------------------");
        }
        
        System.out.println("Review complete. Don't let your guard down.");
        scanner.close();
    }

    public static void checkResponse(String topic, String response, String[] keywords) {
        int foundCount = 0;
        String missed = "";

        for (String word : keywords) {
            if (response.contains(word.toLowerCase())) {
                foundCount++;
            } else {
                missed += " [" + word + "]";
            }
        }

        if (foundCount == keywords.length) {
            System.out.println("STATUS: ACCEPTABLE. You included all necessary technical terms.");
        } else if (foundCount > 0) {
            System.out.println("STATUS: FAIL. Your answer is too vague.");
            System.out.println("ADVICE: You missed key concepts:" + missed + ". Be more precise next time.");
        } else {
            System.out.println("STATUS: TOTAL FAILURE.");
            System.out.println("ADVICE: You don't seem to understand " + topic + " at all. Start from the beginning.");
        }
    }
}
