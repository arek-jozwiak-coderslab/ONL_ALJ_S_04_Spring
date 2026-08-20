package pl.visa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class NobilityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveNobility(Nobility nobility) {
        entityManager.persist(nobility);
    }

    public Nobility findById(long id) {
        return entityManager.find(Nobility.class, id);
    }

    public void update(Nobility nobility) {
        entityManager.merge(nobility);
    }

    public void delete(Nobility nobility) {
        entityManager.remove(entityManager.contains(nobility) ? nobility : entityManager.merge(nobility));
    }
}
