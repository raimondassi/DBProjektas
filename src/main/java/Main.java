import dbProject.domain.Exam;
import dbProject.service.ExamService;
import dbProject.service.QuestionService;
import dbProject.service.StudentService;
import dbProject.ui.UserInterface;

public class Main {



    public static void main(String[] args) {

        ExamService examService=new ExamService();
        StudentService studentService=new StudentService();
        QuestionService questionService=new QuestionService();

        examService.createManyExams();
        studentService.createManyStudents();
        questionService.createManyQuestions();


        UserInterface userInterface = new UserInterface();
        userInterface.start();
    }
}
