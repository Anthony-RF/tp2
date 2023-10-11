package tec.lp.tp2.Repository;

import tec.lp.tp2.model.Cita;

import java.util.List;

public interface CitaRepositoryI {

    void create(Cita cita);

    Cita read(String fecha);

    void update(Cita cita);

    void delete(String fecha);

    List<Cita> readAll();
}
