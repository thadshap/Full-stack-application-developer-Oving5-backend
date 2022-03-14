package stud.ntnu.Oving5backend.Oving5backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

    @OneToMany(targetEntity = Equation.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="eq_fk",referencedColumnName = "id")

    private List<Equation> products;
}
