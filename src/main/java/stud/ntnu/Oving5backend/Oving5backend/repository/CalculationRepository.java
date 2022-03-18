package stud.ntnu.Oving5backend.Oving5backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.ntnu.Oving5backend.Oving5backend.entity.Calculation;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {
}
