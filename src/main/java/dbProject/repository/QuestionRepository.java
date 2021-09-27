package dbProject.repository;

import dbProject.domain.Exam;
import dbProject.domain.Question;
import dbProject.provider.SessionFactoryProvider;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionRepository {

    public Question createNewQuestion(Question question) {
        SessionFactoryProvider.editInstance(session -> session.save(question));
        return question;
    }

    public Question getQuestionByQuestionId(Integer questionId) {
        return SessionFactoryProvider.getInstance(session -> session.get(Question.class, questionId));
    }

    public void deleteQuestion(Question question){
        SessionFactoryProvider.editInstance(session -> session.delete(question));
    }

    public void editQuestion(Question question){
        SessionFactoryProvider.editInstance(session -> session.update(question));
    }

    public List<Question> getQuestionsByExam(Exam exam){
     return SessionFactoryProvider.getInstance(session -> {
            Query query = session.createQuery("from Question where exam_id=:id");
            query.setParameter("id", exam.getId());
            return query.list();
        });
    }

}
