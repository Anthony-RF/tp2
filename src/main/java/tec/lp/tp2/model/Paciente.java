package tec.lp.tp2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Paciente extends Persona{

    private static int cantidad;
    private List<Medicamento> tratamiento;

    public List<Medicamento> getTratamiento(){
        for (Cita cita : this.getCitas()){
            tratamiento.add((Medicamento) cita.getMedicamentos());
        }
        return tratamiento;
    }

    public List<MedicoAgendaItem> getAgenda() {
        List<MedicoAgendaItem> agenda = new ArrayList<>();
        for (Cita cita : this.getCitas()) {
            MedicoAgendaItem item = new MedicoAgendaItem();
            item.setFecha(cita.getFecha());
            item.setPaciente(cita.getPersona());
            agenda.add(item);
        }
        return agenda;
    }

    public List<ExpedienteItem> getExpediente() {
        List<ExpedienteItem> expediente = new ArrayList<>();
        for (Cita cita : this.getCitas()) {
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
