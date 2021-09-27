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
    Question question;

    Integer answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Student student;

    public ExamAnswer(Question questions, Integer answer,Student student) {
        this.question = questions;
        this.answer = answer;
        this.student = student;
    }
}
