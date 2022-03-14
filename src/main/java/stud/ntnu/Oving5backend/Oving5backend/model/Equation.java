package stud.ntnu.Oving5backend.Oving5backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Equation {
    @Id
    @GeneratedValue
    private int eid;
    private String equation;
    private double answer;
}
