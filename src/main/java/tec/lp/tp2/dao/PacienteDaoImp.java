package tec.lp.tp2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tec.lp.tp2.model.*;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PacienteDaoImp implements PacienteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createPaciente(Paciente paciente) {

    }

    @Override
    public List<Paciente> readAllPaciente() {
        String query = "FROM Paciente";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Paciente readByCedulaPaciente(int cedula) {
        String query = "FROM Paciente WHERE cedula = :cedula";
        return (Paciente) entityManager.createQuery(query);
    }

    @Override
    public void updatePaciente(Paciente Paciente) {

    }

    @Override
    public void deletePaciente(int cedula) {

    }

    public List<PacienteAgendaItem> getAgenda(int cedula) {
        String query = "FROM Paciente WHERE cedula = :cedula";
        Paciente Paciente = (Paciente) entityManager.createQuery(query);
        List<PacienteAgendaItem> agenda = new ArrayList<>();
        for (Cita cita : Paciente.getCitas()) {
            PacienteAgendaItem item = new PacienteAgendaItem();
            item.setFecha(cita.getFecha());
            item.setMedico(cita.getMedico());
            agenda.add(item);
        }
        return agenda;
    }

    public List<Medicamento> getTratamiento(){
        String query = "FROM Paciente WHERE cedula = :cedula";
        Paciente Paciente = (Paciente) entityManager.createQuery(query);
        List<Medicamento> tratamiento = new ArrayList<>();
        for (Cita cita : Paciente.getCitas()){
            tratamiento.add((Medicamento) cita.getMedicamentos());
        }
        return tratamiento;
    }

    public List<ExpedienteItem> getExpediente() {
        String query = "FROM Paciente WHERE cedula = :cedula";
        Paciente Paciente = (Paciente) entityManager.createQuery(query);
        List<ExpedienteItem> expediente = new ArrayList<>();
        for (Cita cita : Paciente.getCitas()) {
            ExpedienteItem item = new ExpedienteItem();
            item.setFecha(cita.getFecha());
            item.setPadecimiento(cita.getPadecimiento());
            item.setProcedimiento(cita.getProcedimiento());
            item.setMedicamentos(cita.getMedicamentos());
            expediente.add(item);
        }
        return expediente;
    }

}
