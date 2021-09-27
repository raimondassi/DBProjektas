package dbProject.repository;

import dbProject.domain.Student;
import dbProject.provider.SessionFactoryProvider;

import java.util.List;
public class StudentRepository {

    public Student checkStudentById(Integer studentId) {
        return SessionFactoryProvider.getEntity(session -> session.get(Student.class, studentId));
    }

    public List<Student> getAllStudents() {
        return SessionFactoryProvider.getEntity(session -> session.createQuery("FROM Student", Student.class).list());
    }

    public Student createNewStudent(Student student){
         SessionFactoryProvider.changeEntity(session -> session.save(student));
        return student;
    }
}


