package dbProject.service;

import dbProject.domain.Exam;
import dbProject.domain.Question;
import dbProject.repository.QuestionRepository;

import java.util.List;

public class ExamAnswerRepository {
    QuestionRepository questionRepository=new QuestionRepository();

    public void takeExam(Exam exam){
     List<Question> qestions= questionRepository.getQuestionsByExam(exam);

    }

}
