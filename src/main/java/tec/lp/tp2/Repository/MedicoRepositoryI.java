package tec.lp.tp2.Repository;

import tec.lp.tp2.model.Medico;

import java.util.List;

public interface MedicoRepositoryI {

    void create(Medico medico);

    Medico read(int id);

    void update(Medico medico);

    void delete(int id);

    List<Medico> readAll();
}
