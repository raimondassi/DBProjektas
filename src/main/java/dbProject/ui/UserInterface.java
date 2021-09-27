package dbProject.ui;

import dbProject.domain.Exam;
import dbProject.domain.Question;
import dbProject.domain.Student;
import dbProject.repository.ExamRepository;
import dbProject.repository.QuestionRepository;
import dbProject.repository.StudentRepository;
import dbProject.service.ExamAnswerRepository;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    StudentRepository studentRepository = new StudentRepository();

    QuestionRepository questionRepository = new QuestionRepository();

    ExamRepository examRepository = new ExamRepository();

    ExamAnswerRepository examAnswerRepository=new ExamAnswerRepository();

    public void start() {
        while(true) {
            System.out.println("Choose what you want to do: " + "\n 1. Take exam?" + "\n 2. Enter new question" + "\n 3. Edit existing question" + "\n 4. Check statistics" + "\n 5. Log out");
            Integer variant = scanner.nextInt();
            if(variant > 0 && variant < 5) {
                letsDoSomeStuff(variant);
                break;
            }
            if(variant == 5) {
                System.exit(-1);
            } else {
                System.out.println("you have choosen not existing variant, choose again");
            }
        }
    }

    private void letsDoSomeStuff(Integer variant) {
        switch(variant) {
            case 1:
                takeExam();
                break;
            case 2:
                enterNewQuestions();
                break;
            case 3:
                editQuestion();
                break;
            case 4:
                checkStatistics();
                break;
        }
    }

    public void enterNewQuestions() {
        System.out.println(" Enter exam id, on which you will enter question ");
        Integer examId = scanner.nextInt();
        System.out.println("Enter new question");
        scanner.nextLine();
        String question = scanner.nextLine();
        System.out.println("---------Enter 3 possible answers, and which answer is correct----------");
        System.out.println("Enter 1st answer");
        String firstAnswer = scanner.nextLine();
        System.out.println("Enter 2st answer");
        String secondAnswer = scanner.nextLine();
        System.out.println("Enter 3st answer");
        String thirdAnswer = scanner.nextLine();
        System.out.println("Which answer is correct?");
        Integer correctAnswer = scanner.nextInt();
        Exam exam = examRepository.getExamById(examId);
        if(exam != null) {
            questionRepository.createNewQuestion(new Question(null, question, firstAnswer, secondAnswer, thirdAnswer, correctAnswer, exam));
        } else
            createNewExam();
    }

    private void createNewExam() {
        System.out.println("Such exam does not exist");
        System.out.println("Do you want to enter new Exam? press y(yes) or n(no)");
        String enterNewExam = scanner.next();
        if(enterNewExam.equals("y")) {
            System.out.println("Please enter Exam name");
            String examName = scanner.next();
            examRepository.createNewExam(new Exam(null, examName));
        }
    }

    public void takeExam() {
        System.out.println("What is your studentId? ");
        int studentId = scanner.nextInt();
        Student student = studentRepository.checkStudentById(studentId);
        if(student != null) {
            System.out.println("Let's start exam mr/ms: " + student.getName());
            System.out.println("Select exam, please write exam id");
            Integer examId = scanner.nextInt();
            Exam exam = examRepository.getExamById(examId);
            if(exam != null) {
                examAnswerRepository.takeExam(exam);
            } else {
                createNewExam();
            }
        } else {
            System.out.println("Such student do not exist");
        }
    }

    public void editQuestion() {
        System.out.println("Enter question id you want to edit");
        Integer questionId = scanner.nextInt();
        Question question = questionRepository.getQuestionByQuestionId(questionId);
        if(question != null) {
            System.out.println("This is the question you have selected: " + question);
            System.out.println("To delete question press y if edit e");
            String choise = scanner.next();
            if(choise.equals("y")) {
                questionRepository.deleteQuestion(question);
            }
            if(choise.equals("e")) {
                System.out.println("Change question describtion");
                scanner.nextLine();
                String describtion = scanner.nextLine();
                question.setQuestion(describtion);
                questionRepository.editQuestion(question);
            }
        }
    }

    public void checkStatistics() {
    }
}




