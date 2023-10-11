package tec.lp.tp2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tec.lp.tp2.model.Cita;
import tec.lp.tp2.model.Medico;
import tec.lp.tp2.model.MedicoAgendaItem;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MedicoDaoImp implements MedicoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createMedico(Medico medico) {
    }

    @Override
    public List<Medico> readAllMedico() {
        String query = "FROM Medico";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Medico readByIDMedico(int id) {
        String query = "FROM Medico WHERE id = :id";
        return (Medico) entityManager.createQuery(query);
    }

    @Override
    public void updateMedico(Medico medico) {

    }

    @Override
    public void deleteMedico(int id) {

    }

    public List<MedicoAgendaItem> getAgenda(int id) {
        Medico medico = readByIDMedico(id);
        List<MedicoAgendaItem> agenda = new ArrayList<>();
        for (Cita cita : medico.getCitas()) {
            MedicoAgendaItem item = new MedicoAgendaItem();
            item.setFecha(cita.getFecha());
            item.setPaciente(cita.getPersona());
            agenda.add(item);
        }
        return agenda;
    }

}
