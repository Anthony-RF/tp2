package tec.lp.tp2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tec.lp.tp2.model.Cita;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class CitaDaoImp implements CitaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createCita(Cita cita) {

    }

    @Override
    public List<Cita> readAllCita() {
        String query = "FROM Cita";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Cita readByFechaCita(LocalDateTime fecha) {
        String query = "FROM Cita WHERE fecha = :fecha";
        return (Cita) entityManager.createQuery(query);
    }

    @Override
    public void updateCita(Cita cita) {

    }

    @Override
    public void deleteCita(LocalDateTime fecha) {

    }
}
