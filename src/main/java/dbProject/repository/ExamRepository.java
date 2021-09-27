package dbProject.repository;

import dbProject.domain.Exam;
import dbProject.provider.SessionFactoryProvider;

import java.util.List;

public class ExamRepository {


    public Exam getExamById(Integer examId) {
        return SessionFactoryProvider.getEntity(session -> session.get(Exam.class, examId));
    }

    public void createNewExam(Exam exam) {
        SessionFactoryProvider.changeEntity(session -> session.save(exam));
    }



}
