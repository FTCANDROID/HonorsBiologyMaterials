import java.util.*;

public class BioExam {
    static class Question {
        String text;
        String[] options;
        char correctLetter;
        String correctText;

        public Question(String text, String[] options, char correctLetter, String correctText) {
            this.text = text;
            this.options = options;
            this.correctLetter = correctLetter;
            this.correctText = correctText;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> pool = new ArrayList<>();

        // --- QUESTION POOL (Sample of the 45 logic) ---
        pool.add(new Question("Which bond connects amino acids in a protein?", 
            new String[]{"Peptide", "Ionic", "Hydrogen", "Glycosidic"}, 'A', "Peptide"));
        pool.add(new Question("The movement of water across a membrane is:", 
            new String[]{"Active Transport", "Osmosis", "Endocytosis", "Pumping"}, 'B', "Osmosis"));
        pool.add(new Question("A solution with a HIGHER solute concentration than the cell is:", 
            new String[]{"Isotonic", "Hypotonic", "Hypertonic", "Equilibrium"}, 'C', "Hypertonic"));
        pool.add(new Question("Which macromolecule stores genetic information?", 
            new String[]{"Lipids", "Proteins", "Carbohydrates", "Nucleic Acids"}, 'D', "Nucleic Acids"));
        pool.add(new Question("What is required for active transport to occur?", 
            new String[]{"Gravity", "ATP Energy", "Glucose", "Nothing"}, 'B', "ATP Energy"));
        // ... (Add the remaining 40 questions to this list following the same format)

        // 1. SHUFFLE QUESTIONS
        Collections.shuffle(pool);

        List<Character> userAnswers = new ArrayList<>();
        int mcqCount = Math.min(pool.size(), 45); // Adjust based on your final list size

        System.out.println("=== H-BIO COMPREHENSIVE EXAM (45 MCQ + 2 SA) ===");
        System.out.println("No feedback will be given until submission.\n");

        // 2. MCQ SECTION
        for (int i = 0; i < mcqCount; i++) {
            Question q = pool.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.text);
            
            // Shuffle Options logic
            List<String> opts = Arrays.asList(q.options);
            // (In a full version, track the index of the correct text after shuffling)
            for (int j = 0; j < opts.size(); j++) {
                System.out.println("  " + (char)('A' + j) + ") " + opts.get(j));
            }
            System.out.print("Choice: ");
            userAnswers.add(scanner.nextLine().toUpperCase().trim().charAt(0));
            System.out.println();
        }

        // 3. SHORT ANSWER SECTION (Randomized)
        String[] saTopics = {"Active Transport", "Macromolecules", "Cell Membrane", "Osmosis"};
        Collections.shuffle(Arrays.asList(saTopics));
        
        System.out.println("--- SHORT ANSWER SECTION ---");
        System.out.println("Topic 1: " + saTopics[0]);
        System.out.print("> ");
        String sa1 = scanner.nextLine();
        System.out.println("Topic 2: " + saTopics[1]);
        System.out.print("> ");
        String sa2 = scanner.nextLine();

        // 4. SUBMISSION
        System.out.print("\nDo you wish to submit? (Y/N): ");
        if (!scanner.nextLine().equalsIgnoreCase("Y")) {
            System.out.println("Exam discarded.");
            return;
        }

        // 5. HARSH GRADING
        System.out.println("\n" + "=".repeat(30));
        System.out.println("FINAL EXAM REPORT (STRICT MODE)");
        System.out.println("=".repeat(30));

        int score = 0;
        for (int i = 0; i < mcqCount; i++) {
            Question q = pool.get(i);
            char userAns = userAnswers.get(i);
            if (userAns == q.correctLetter) {
                score++;
                System.out.println("Q" + (i + 1) + ": [CORRECT]");
            } else {
                System.out.println("Q" + (i + 1) + ": [X] WRONG. Your answer: " + userAns + " | Correct: " + q.correctLetter + " (" + q.correctText + ")");
            }
        }

        // 6. SHORT ANSWER GRADING (Using Keyword Logic)
        System.out.println("\n[Short Answer Grading]");
        gradeSA(saTopics[0], sa1);
        gradeSA(saTopics[1], sa2);

        double percent = (double)score / mcqCount * 100;
        System.out.printf("\nFINAL MCQ SCORE: %.2f%%\n", percent);
        if (percent < 90) System.out.println("CRITIQUE: Inadequate. Your understanding of cell dynamics is lacking. Re-read the study guide.");
        
        scanner.close();
    }

    public static void gradeSA(String topic, String response) {
        String[] keywords = getKeywords(topic);
        int hits = 0;
        for (String k : keywords) {
            if (response.toLowerCase().contains(k.toLowerCase())) hits++;
        }

        if (hits < keywords.length) {
            System.out.println("Topic: " + topic + " -> [FAIL]. Missing scientific precision.");
        } else {
            System.out.println("Topic: " + topic + " -> [PASS]. Sufficient detail.");
        }
    }

    public static String[] getKeywords(String topic) {
        if (topic.equals("Active Transport")) return new String[]{"ATP", "energy", "against"};
        if (topic.equals("Osmosis")) return new String[]{"water", "membrane"};
        return new String[]{"carbon", "monomer"}; // Default
    }
}
