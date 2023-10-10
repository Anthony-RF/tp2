package tec.lp.tp2.dao;

import tec.lp.tp2.model.Persona;

import java.util.List;

public interface PersonaDao {

        void createPersona(Persona persona);
        List<Persona> readAllPersona();
        Persona readByCedulaPersona(int cedula);
        void updatePersona(Persona persona);
        void deletePersona(int cedula);
}