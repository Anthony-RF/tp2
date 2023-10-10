package tec.lp.tp2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tec.lp.tp2.model.Medico;

import java.util.List;

@Repository
@Transactional
public class MedicoDaoImp implements MedicoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Medico> readAllMedico() {
        String query = "FROM Medico";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void createMedico(Medico medico) {

    }

    @Override
    public Medico readMedico(String cedula) {
        return null;
    }

    @Override
    public void updateMedico(Medico medico) {

    }

    @Override
    public void deleteMedico(String cedula) {

    }
}
