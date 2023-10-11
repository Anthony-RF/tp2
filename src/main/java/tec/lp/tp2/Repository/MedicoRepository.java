package tec.lp.tp2.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tec.lp.tp2.model.Medico;
import jakarta.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class MedicoRepository implements MedicoRepositoryI{

    private final SessionFactory sessionFactory;

    @Autowired
    public MedicoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Medico medico) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(medico);
    }

    public Medico read(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Medico.class, id);
    }

    public void update(Medico medico) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(medico);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Medico medico = session.get(Medico.class, id);
        if (medico != null) {
            session.delete(medico);
        }
    }

    public List<Medico> readAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Medico> cq = cb.createQuery(Medico.class);
        Root<Medico> root = cq.from(Medico.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
