package stud.ntnu.Oving5backend.Oving5backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import stud.ntnu.Oving5backend.Oving5backend.entity.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    private User user;
}
