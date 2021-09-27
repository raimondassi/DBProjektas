package dbProject.repository;

import dbProject.domain.Exam;
import dbProject.domain.ExamAnswer;
import dbProject.domain.Question;
import dbProject.domain.Student;
import dbProject.provider.SessionFactoryProvider;
import org.hibernate.query.Query;

import java.util.List;

public class GradeRepository {
    ExamAnswerRepository examAnswerRepository=new ExamAnswerRepository();

    public void getGradeByStudentIdAndExamId(Integer studentId, Integer examId){
//        SessionFactoryProvider.getInstance(session -> {
//
//        })
    }

//    public List<ExamAnswer> getExamAnswersByStudentIdAndExamId(Integer studentId, Integer examId){
//        SessionFactoryProvider.getInstance(session -> {
//            Query query=session.createQuery("from exam_answers where  ")
//        })
//    }

}
