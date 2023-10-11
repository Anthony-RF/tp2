package tec.lp.tp2.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.criteria.*;
import tec.lp.tp2.model.Persona;
import java.util.List;

@Repository
@Transactional
public class PersonaRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonaRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Persona persona) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(persona);
    }

    public Persona read(int cedula) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Persona.class, cedula);
    }

    public void update(Persona persona) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(persona);
    }

    public void delete(int cedula) {
        Session session = sessionFactory.getCurrentSession();
        Persona persona = session.get(Persona.class, cedula);
        if (persona != null) {
            session.delete(persona);
        }
    }

    public List<Persona> readAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
