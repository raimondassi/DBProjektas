package dbProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exam_answers")
public class ExamAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Question questions;

    Integer answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Exam exam;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Student student;

    public ExamAnswer(Question questions, Integer answer, Exam exam, Student student) {
        this.questions = questions;
        this.answer = answer;
        this.exam = exam;
        this.student = student;
    }
}
