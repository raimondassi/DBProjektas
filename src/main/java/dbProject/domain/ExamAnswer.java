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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Question> questions;

    Integer answer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Exam> exams;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Student> students;


}
