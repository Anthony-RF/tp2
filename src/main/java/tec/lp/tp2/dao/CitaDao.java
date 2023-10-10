package tec.lp.tp2.dao;

import tec.lp.tp2.model.Cita;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaDao {

        void createCita(Cita cita);
        List<Cita> readAllCita();
        Cita readByFechaCita(LocalDateTime fecha);
        void updateCita(Cita cita);
        void deleteCita(LocalDateTime fecha);
}