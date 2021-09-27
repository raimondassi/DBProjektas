package dbProject.service;

import dbProject.domain.Exam;
import dbProject.repository.ExamRepository;

public class ExamService {

    ExamRepository examRepository = new ExamRepository();

    public void createManyExams() {
        examRepository.createNewExam(new Exam(null, "Java"));
        examRepository.createNewExam(new Exam(null, "Biology"));
        examRepository.createNewExam(new Exam(null, "Phishing"));
        examRepository.createNewExam(new Exam(null, "Management"));
    }
}
