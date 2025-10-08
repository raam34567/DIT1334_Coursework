// File: QuizSystem.java
// Demonstrates OOP concepts: Polymorphism and Method Overriding

package Chapter1; // Declares that this file belongs to the package named Chapter1

// Abstract class representing a generic Quiz
abstract class Quiz {
    String title;        // Variable to store quiz title
    int numQuestions;    // Variable to store number of questions in the quiz

    // Constructor to initialize title and number of questions
    Quiz(String title, int numQuestions) {
        this.title = title;           // Assign quiz title to the object
        this.numQuestions = numQuestions; // Assign number of questions to the object
    }

    // Abstract method to evaluate quiz score — must be implemented by subclasses
    abstract int evaluate(int correctAnswers);
}

// EasyQuiz class inherits from Quiz
class EasyQuiz extends Quiz {
    // Constructor calls parent constructor to set title and number of questions
    EasyQuiz(String title, int numQuestions) {
        super(title, numQuestions); 
    }

    // Override evaluate method: each correct answer gives 1 point
    int evaluate(int correctAnswers) {
        return correctAnswers * 1; // simple scoring
    }
}

// HardQuiz class inherits from Quiz
class HardQuiz extends Quiz {
    // Constructor calls parent constructor
    HardQuiz(String title, int numQuestions) {
        super(title, numQuestions);
    }

    // Override evaluate method: each correct answer gives 2 points
    int evaluate(int correctAnswers) {
        return correctAnswers * 2; // double points for hard quizzes
    }
}

// Main class where program execution starts
public class QuizSystem {
    public static void main(String[] args) { // Main method — program entry point
        Quiz easy = new EasyQuiz("Basics of Java", 5);   // Create an EasyQuiz object
        Quiz hard = new HardQuiz("Advanced OOP", 5);     // Create a HardQuiz object

        // Display the score for easy and hard quizzes
        System.out.println(easy.title + " Score: " + easy.evaluate(4)); // 4 correct answers
        System.out.println(hard.title + " Score: " + hard.evaluate(4)); // 4 correct answers
    }
}
