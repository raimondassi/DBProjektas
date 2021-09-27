package dbProject.repository;

import dbProject.domain.Exam;
import dbProject.provider.SessionFactoryProvider;

public class ExamRepository {

    public Exam getExamById(Integer examId) {
        return SessionFactoryProvider.getInstance(session -> session.get(Exam.class, examId));
    }

    public void createNewExam(Exam exam) {
        SessionFactoryProvider.editInstance(session -> session.save(exam));
    }
}
