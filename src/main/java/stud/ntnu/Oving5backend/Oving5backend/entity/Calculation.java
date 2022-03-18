package stud.ntnu.Oving5backend.Oving5backend.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "equation", nullable = false)
    private String equation;
    @Column(name = "answer", nullable = false)
    private double answer;

    public Calculation(String equation) {
        this.equation = equation;
    }
}
