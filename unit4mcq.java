import java.util.Scanner;

public class BrainStructureQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = 5;

        System.out.println("=== Honors Bio Unit 4: Brain Structures Quiz ===");
        System.out.println("Test your knowledge of major brain regions!\n");

        // Q1
        System.out.println("1. Which part of the brain is mainly responsible for balance, coordination, and movement?");
        System.out.println("A) Cerebrum\nB) Cerebellum\nC) Brainstem\nD) Temporal Lobe");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! The cerebellum handles movement, coordination, and balance.");
            score++;
        } else {
            System.out.println("Not quite. The answer was B) Cerebellum.");
        }

        // Q2
        System.out.println("\n2. Which lobe is primarily responsible for visual processing?");
        System.out.println("A) Frontal Lobe\nB) Temporal Lobe\nC) Parietal Lobe\nD) Occipital Lobe");
        if (getAnswer(scanner).equals("D")) {
            System.out.println("Correct! The occipital lobe processes visual information.");
            score++;
        } else {
            System.out.println("Incorrect. The answer was D) Occipital Lobe.");
        }

        // Q3
        System.out.println("\n3. The prefrontal cortex is most closely associated with:");
        System.out.println("A) Balance and posture\nB) Executive function and judgment\nC) Visual processing\nD) Heart rate and breathing");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! The prefrontal cortex handles executive function and judgment.");
            score++;
        } else {
            System.out.println("Not quite. The answer was B) Executive function and judgment.");
        }

        // Q4
        System.out.println("\n4. Which structure connects the two hemispheres of the brain and allows them to communicate?");
        System.out.println("A) Thalamus\nB) Hippocampus\nC) Corpus Callosum\nD) Pituitary Gland");
        if (getAnswer(scanner).equals("C")) {
            System.out.println("Correct! The corpus callosum links the left and right hemispheres.");
            score++;
        } else {
            System.out.println("Actually, it's C) Corpus Callosum.");
        }

        // Q5
        System.out.println("\n5. Which part of the brain filters and routes sensory information, like a 'Grand Central Station'?");
        System.out.println("A) Thalamus\nB) Amygdala\nC) Substantia Nigra\nD) Ventral Tegmental Area");
        if (getAnswer(scanner).equals("A")) {
            System.out.println("Correct! The thalamus routes sensory information to the right areas.");
            score++;
        } else {
            System.out.println("The correct answer was A) Thalamus.");
        }

        // Results
        System.out.println("\n--- Quiz Complete! ---");
        System.out.println("Your Final Score: " + score + "/" + totalQuestions);

        if (score == totalQuestions) {
            System.out.println("Status: Brain Anatomy Beast. Nice work.");
        } else if (score >= 3) {
            System.out.println("Status: Solid. Review the structures you missed.");
        } else {
            System.out.println("Status: Revisit your Unit 4 brain structure notes.");
        }

        scanner.close();
    }

    public static String getAnswer(Scanner scanner) {
        System.out.print("Your Answer: ");
        return scanner.nextLine().toUpperCase().trim();
    }
}
