package tec.lp.tp2.dao;

import tec.lp.tp2.model.Paciente;
import tec.lp.tp2.model.PacienteAgendaItem;

import java.util.List;

public interface PacienteDao {

        void createPaciente(Paciente paciente);
        List<Paciente> readAllPaciente();
        Paciente readByCedulaPaciente(int cedula);
        void updatePaciente(Paciente paciente);
        void deletePaciente(int cedula);
}