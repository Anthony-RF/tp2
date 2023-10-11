package tec.lp.tp2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tec.lp.tp2.model.Persona;

import java.util.List;

@Repository
@Transactional
public class PersonaDaoImp implements PersonaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createPersona(Persona persona) {

    }

    @Override
    public List<Persona> readAllPersona() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Persona readByCedulaPersona(int cedula) {
        String query = "FROM Persona WHERE cedula = :cedula";
        return (Persona) entityManager.createQuery(query);
    }

    @Override
    public void updatePersona(Persona persona) {

    }

    @Override
    public void deletePersona(int cedula) {

    }



}
