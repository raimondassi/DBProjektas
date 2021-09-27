package dbProject.service;

import dbProject.domain.Question;
import dbProject.repository.ExamRepository;
import dbProject.repository.QuestionRepository;

public class QuestionService {

    QuestionRepository questionRepository;
    ExamRepository examRepository=new ExamRepository();

    public QuestionService() {
        questionRepository = new QuestionRepository();
    }

    public void createManyQuestions() {
        questionRepository.createNewQuestion(new Question(null, "What is Java?", "My dog name", "My cat name", "Programming language", 3, examRepository.getExamById(1)));
        questionRepository.createNewQuestion(new Question(null, "What is OOP?", "My dog name", "Object oriented programming", "Programming language", 2, examRepository.getExamById(1)));
        questionRepository.createNewQuestion(new Question(null, "What is Hybernate?", "ORM", "My cat name", "Programming language", 1, examRepository.getExamById(1)));
        questionRepository.createNewQuestion(new Question(null, "ORM?", "My dog name", "My cat name", "Object ralational mapping", 3, examRepository.getExamById(1)));
        questionRepository.createNewQuestion(new Question(null, "What is Maven?", "My dog name", "My cat name", "Dependencies repository", 3, examRepository.getExamById(1)));

    }
}
