package dbProject.service;

import dbProject.domain.Student;
import dbProject.repository.StudentRepository;

public class StudentService {
    StudentRepository studentRepository=new StudentRepository();

    public void createManyStudents(){
        studentRepository.createNewStudent(new Student("Jonas", "Ponas", "jonasPonas"));
        studentRepository.createNewStudent(new Student("Antanas", "Fontanas", "antanasFontanas"));
        studentRepository.createNewStudent(new Student("Onute", "Konduktore", "tralialia"));
        studentRepository.createNewStudent(new Student("Janina", "Vaiciauskiene", "vaitaitai"));
    }

}
