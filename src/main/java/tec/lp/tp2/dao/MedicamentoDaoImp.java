package tec.lp.tp2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tec.lp.tp2.model.Medicamento;

import java.util.List;

@Repository
@Transactional
public class MedicamentoDaoImp implements MedicamentoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createMedicamento(Medicamento medicamento) {

    }

    @Override
    public List<Medicamento> readAllMedicamento() {
        String query = "FROM Medicamento";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Medicamento readByNombreMedicamento(String nombre) {
        String query = "FROM Medicamento WHERE cedula = :cedula";
        return (Medicamento) entityManager.createQuery(query);
    }

    @Override
    public void updateMedicamento(Medicamento medicamento) {

    }

    @Override
    public void deleteMedicamento(String nombre) {

    }
}
