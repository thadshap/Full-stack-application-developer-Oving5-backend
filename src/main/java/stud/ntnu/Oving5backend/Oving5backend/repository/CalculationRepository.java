package stud.ntnu.Oving5backend.Oving5backend.repository;

import org.springframework.stereotype.Repository;
import stud.ntnu.Oving5backend.Oving5backend.entity.Calculation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CalculationRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Calculation c, long key) {
        entityManager.createNativeQuery("INSERT INTO calculations(equation, answer, cp_fk) VALUES (?,?,?)")
                .setParameter(1, c.getEquation())
                .setParameter(2, c.getAnswer())
                .setParameter(3, key)
                .executeUpdate();
    }
}

