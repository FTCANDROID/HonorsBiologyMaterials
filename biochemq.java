import java.util.Scanner;

public class BioQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = 5;

        System.out.println("=== 9th Grade H-Bio Midterm Prep Quiz ===");
        System.out.println("Test your knowledge on Macromolecules & Cell Transport!\n");

        // Question 1: Macromolecules
        System.out.println("1. Which macromolecule is made of amino acid monomers and helps with muscle building and enzymes?");
        System.out.println("A) Carbohydrates\nB) Lipids\nC) Proteins\nD) Nucleic Acids");
        if (getAnswer(scanner).equals("C")) {
            System.out.println("Correct! Proteins use peptide bonds to link amino acids.");
            score++;
        } else {
            System.out.println("Not quite. The answer was C (Proteins).");
        }

        // Question 2: Passive Transport
        System.out.println("\n2. Facilitated diffusion requires which of the following?");
        System.out.println("A) Energy (ATP)\nB) A helper transport protein\nC) Moving against the gradient\nD) Endocytosis");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! It's 'facilitated' because it needs a protein channel.");
            score++;
        } else {
            System.out.println("Incorrect. It's passive, so no ATP is needed, but it does need a protein (B).");
        }

        // Question 3: Osmosis/Tonicity
        System.out.println("\n3. If a cell is placed in a HYPERTONIC solution, what will happen to the cell?");
        System.out.println("A) It will swell and burst\nB) It will stay the same size\nC) It will shrivel up (lose water)");
        if (getAnswer(scanner).equals("C")) {
            System.out.println("Correct! Water leaves the cell to follow the higher solute concentration outside.");
            score++;
        } else {
            System.out.println("Actually, hypertonic solutions cause shriveling (C).");
        }

        // Question 4: Active Transport
        System.out.println("\n4. Which process moves molecules FROM low concentration TO high concentration (against the gradient)?");
        System.out.println("A) Simple Diffusion\nB) Osmosis\nC) Active Transport\nD) Facilitated Diffusion");
        if (getAnswer(scanner).equals("C")) {
            System.out.println("Spot on! Active transport requires ATP to pump molecules 'uphill'.");
            score++;
        } else {
            System.out.println("Wrong way! Moving against the gradient is Active Transport (C).");
        }

        // Question 5: Water Properties
        System.out.println("\n5. Which property of water allows it to stick to OTHER surfaces, like a glass tube?");
        System.out.println("A) Adhesion\nB) Cohesion\nC) High Specific Heat\nD) Non-polarity");
        if (getAnswer(scanner).equals("A")) {
            System.out.println("Correct! Adhesion is sticking to others; Cohesion is sticking to itself.");
            score++;
        } else {
            System.out.println("Remember: Adhesion (A) is sticking to different surfaces.");
        }

        // Final Results
        System.out.println("\n--- Quiz Complete! ---");
        System.out.println("Your Final Score: " + score + "/" + totalQuestions);
        
        if (score == totalQuestions) {
            System.out.println("Status: Bio Master! You're ready for the midterm.");
        } else if (score >= 3) {
            System.out.println("Status: Good job! Just review the ones you missed.");
        } else {
            System.out.println("Status: Time to hit the textbook! Focus on the transport definitions.");
        }

        scanner.close();
    }

    public static String getAnswer(Scanner scanner) {
        System.out.print("Your Answer: ");
        return scanner.nextLine().toUpperCase().trim();
    }
}
