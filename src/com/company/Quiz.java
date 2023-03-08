package com.company;
import java.util.ArrayList;
import java.util.Scanner;


class Question {
    private String text;
    private ArrayList<String> choices;
    public int correctAnswer;

    public Question(String text, ArrayList<String> choices, int correctAnswer) {
        this.text = text;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(int answer) {
        return (answer == correctAnswer);
    }

    public void display() {
        System.out.println(text);
        for (int i = 0; i < choices.size(); i++) {
            System.out.printf("%d) %s\n", i+1, choices.get(i));
        }
    }

    @Override
    public String toString() {
        return text;
    }
}

class Answer {
    private Question question;
    private int answer;

    public Answer(Question question, int answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return String.format("Question: %s\nYour answer: %d\nThe correct answer: %d",
                question, answer, question.correctAnswer);
    }

    public boolean isCorrect() {
        return question.isCorrect(answer);
    }
}

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        // Add questions to the list
        questions.add(new Question(
                "Что такое конструктор у класса?",
                new ArrayList<String>() {{
                    add("метод, который вызывается при создании экземпляра объекта;");
                    add("специальная переменная класса");
                    add("объект класса");
                }},
                1));
        questions.add(new Question(
                "Если у класса в теле не объявлен конструктор тогда...",
                new ArrayList<String>() {{
                    add("у данного класса автоматически создается конструктор по умолчанию");
                    add("нельзя создать объект этого класса");
                    add("код не скомпилируется");
                }},
                1));
        questions.add(new Question(
                "Сколько конструкторов может быть у класса?",
                new ArrayList<String>() {{
                    add("неограниченное количество");
                    add("только один");
                    add("не более пяти");
                }},
                1));
        questions.add(new Question(
                "Переменные в классе инициализируется ",
                new ArrayList<String>() {{
                    add("в порядке их объявления");
                    add("все одновременно");
                    add("в случайном порядке");
                }},
                1));
        questions.add(new Question(
                "Для каких целей служат методы get и set",
                new ArrayList<String>() {{
                    add("чтобы другие классы могли корректно получать или менять данные внутри объектов вашего класса");
                    add("это специальные конструкторы класса");
                }},
                1));

        // Ask the questions and store the answers
        ArrayList<Answer> answers = new ArrayList<>();
        for (Question question : questions) {
            question.display();
            int answer = scanner.nextInt();
            answers.add(new Answer(question, answer));
        }

        // Display the results
        int numCorrect = 0;
        int numIncorrect = 0;
        for (Answer answer : answers) {
            if (answer.isCorrect()) {
                numCorrect++;
            } else {
                numIncorrect++;
            }
            System.out.println(answer);
            System.out.println();
        }

        System.out.printf("You got %d out of %d questions correct\n", numCorrect, questions.size());
    }
}
