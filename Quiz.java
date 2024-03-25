import java.util.Scanner;

class Quiz {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int questionNumber = 0;

    private static String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote the book 'A Song of Ice and Fire'?"
    };

    private static String[][] options = {
            {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
            {"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"},
            {"A. J.K. Rowling", "B. Stephen King", "C. J.R.R. Tolkien", "D. George R.R. Martin"}
    };

    private static String[] answers = {"B", "B", "D"};
    private static String[] userAnswers = new String[questions.length];

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        System.out.println("====================================");

        askQuestion();
        showResult();
    }

    private static void askQuestion() {
        if (questionNumber < questions.length) {
            System.out.println("Question " + (questionNumber + 1) + ": " + questions[questionNumber]);
            for (String option : options[questionNumber]) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();
            userAnswers[questionNumber] = userAnswer;

            if (userAnswer.equals(answers[questionNumber])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + answers[questionNumber]);
            }
            System.out.println("------------------------------------");
            questionNumber++;
            askQuestion();
        }
    }

    private static void showResult() {
        System.out.println("Quiz Ended!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("Summary of Correct/Incorrect Answers:");

        for (int i = 0; i < questions.length; i++) {
            String result = userAnswers[i].equals(answers[i]) ? "Correct" : "Incorrect";
            System.out.println("Question " + (i + 1) + ": " + result);
        }
    }
}
