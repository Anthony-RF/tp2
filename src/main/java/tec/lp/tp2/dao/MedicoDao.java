package tec.lp.tp2.dao;

import tec.lp.tp2.model.Medico;

import java.util.List;

public interface MedicoDao {

        List<Medico> readAllMedico();
        void createMedico(Medico medico);
        Medico readMedico(String cedula);
        void updateMedico(Medico medico);
        void deleteMedico(String cedula);
}
