package tec.lp.tp2.Repository;

import tec.lp.tp2.model.Persona;

import java.util.List;

public interface PersonaRepositoryI {

    void create(Persona persona);

    Persona read(int cedula);

    void update(Persona persona);

    void delete(int cedula);

    List<Persona> readAll();
}
