package tec.lp.tp2.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tec.lp.tp2.model.Cita;
import jakarta.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class CitaRepository implements CitaRepositoryI {

    private final SessionFactory sessionFactory;

    @Autowired
    public CitaRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Cita cita) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(cita);
    }

    public Cita read(String fecha) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Cita.class, fecha);
    }

    public void update(Cita cita) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(cita);
    }

    public void delete(String fecha) {
        Session session = sessionFactory.getCurrentSession();
        Cita cita = session.get(Cita.class, fecha);
        if (cita != null) {
            session.delete(cita);
        }
    }

    public List<Cita> readAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Cita> cq = cb.createQuery(Cita.class);
        Root<Cita> root = cq.from(Cita.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
