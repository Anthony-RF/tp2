package tec.lp.tp2.dao;

import tec.lp.tp2.model.Medico;
import java.util.List;

public interface MedicoDao {

        void createMedico(Medico medico);
        List<Medico> readAllMedico();
        Medico readByIDMedico(int id);
        void updateMedico(Medico medico);
        void deleteMedico(int id);
}
