package dbProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "questions")
@ToString
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Integer question_id;

    private String question;

    @NonNull
    private String FirstAnswer;

    @NonNull
    private String SecondAnswer;

    @NonNull
    private String ThirdAnswer;

    @NonNull
    private Integer correctAnswerNr;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Exam exam;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ExamAnswer> examAnswers;



    public Question(Integer question_id, @NonNull String question, @NonNull String firstAnswer, @NonNull String secondAnswer, @NonNull String thirdAnswer, @NonNull Integer correctAnswerNr, @NonNull Exam exam) {
        this.question_id = question_id;
        this.question = question;
        FirstAnswer = firstAnswer;
        SecondAnswer = secondAnswer;
        ThirdAnswer = thirdAnswer;
        this.correctAnswerNr = correctAnswerNr;
        this.exam=exam;
    }
}
