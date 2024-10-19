public class Student extends User {
    public Student(String name) {
        super(name);
    }

    // Method for taking quizzes
    public void takeQuiz(Quiz quiz) {
        System.out.println("Taking quiz: " + quiz.getTitle());
    }
}
