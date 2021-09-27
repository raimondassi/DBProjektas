package dbProject.repository;

import dbProject.domain.Exam;
import dbProject.domain.ExamAnswer;
import dbProject.domain.Question;
import dbProject.domain.Student;
import dbProject.provider.SessionFactoryProvider;

import java.util.List;
import java.util.Scanner;

public class ExamAnswerRepository {

    Scanner scanner = new Scanner(System.in);

    QuestionRepository questionRepository = new QuestionRepository();

    public void takeExam(Student student, Exam exam) {
        List<Question> questions = questionRepository.getQuestionsByExam(exam);
        for(Question question : questions) {
            System.out.println("Question: " + question.getQuestion());
            System.out.println("First answer: " + question.getFirstAnswer());
            System.out.println("Second answer: " + question.getSecondAnswer());
            System.out.println("Third answer: " + question.getThirdAnswer());
            System.out.println("Write correct answer");
            Integer atsakymas = scanner.nextInt();
            ExamAnswer examAnswer = new ExamAnswer(question, atsakymas, student);
            SessionFactoryProvider.editInstance(session -> session.save(examAnswer));
        }
    }
}

