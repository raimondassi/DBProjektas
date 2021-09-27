package dbProject.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstName")
    private String name;

    @Column(name = "lastName")
    private String surname;

    private String password;

    public Student(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
