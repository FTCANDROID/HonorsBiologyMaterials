import java.util.Scanner;

public class NeuronQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = 5;

        System.out.println("=== Honors Bio Unit 4:  Neuron & Action Potential Quiz ===");
        System.out.println("Test your understanding of neuron structure and signaling!\n");

        // Q1
        System.out.println("1. Which part of the neuron receives incoming signals from other neurons?");
        System.out.println("A) Axon\nB) Dendrites\nC) Axon Terminals\nD) Myelin Sheath");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! Dendrites receive incoming signals.");
            score++;
        } else {
            System.out.println("Not quite. The answer was B) Dendrites.");
        }

        // Q2
        System.out.println("\n2. What is the main function of the myelin sheath?");
        System.out.println("A) Store neurotransmitters\nB) Make hormones\nC) Insulate the axon and speed signaling\nD) Receive signals");
        if (getAnswer(scanner).equals("C")) {
            System.out.println("Correct! Myelin speeds up electrical signal transmission.");
            score++;
        } else {
            System.out.println("Incorrect. The answer was C) Insulate the axon and speed signaling.");
        }

        // Q3
        System.out.println("\n3. During depolarization of an action potential,  which ion moves and in which direction?");
        System.out.println("A) K+ moves out of the cell\nB) Na+ moves into the cell\nC) Na+ moves out of the cell\nD) Ca2+ moves into the cell");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! Na+ rushes into the neuron during depolarization.");
            score++;
        } else {
            System.out.println("Actually,  it's B) Na+ moves into the cell.");
        }

        // Q4
        System.out.println("\n4. What happens during repolarization?");
        System.out.println("A) Na+ channels open and Na+ enters\nB) K+ channels open and K+ exits\nC) No ion movement\nD) Ca2+ enters the axon terminal");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! K+ leaving the cell helps restore the negative inside.");
            score++;
        } else {
            System.out.println("The correct answer was B) K+ channels open and K+ exits.");
        }

        // Q5
        System.out.println("\n5. What is the role of the Na+/K+ pump after an action potential?");
        System.out.println("A) Release neurotransmitter\nB) Reset resting membrane potential\nC) Open Ca2+ channels\nD) Break down neurotransmitter");
        if (getAnswer(scanner).equals("B")) {
            System.out.println("Correct! The Na+/K+ pump restores the resting state.");
            score++;
        } else {
            System.out.println("Not quite. The answer was B) Reset resting membrane potential.");
        }

        // Results
        System.out.println("\n--- Quiz Complete! ---");
        System.out.println("Your Final Score:  " + score + "/" + totalQuestions);

        if (score == totalQuestions) {
            System.out.println("Status:  Neuron Correct. You've got the signaling down.");
        } else if (score >= 3) {
            System.out.println("Status:  Decent. Review the phases of the action potential.");
        } else {
            System.out.println("Status:  Time to study! Brush up on neuron anatomy and action potentials.");
        }
        
        scanner.close(); // Good practice to close the scanner
    }

    // I noticed you're calling getAnswer() but it's not defined in your code
    // Here's a simple implementation:
    public static String getAnswer(Scanner scanner) {
        System.out.print("Your answer (A/B/C/D): ");
        return scanner.nextLine().toUpperCase().trim();
    }
}
