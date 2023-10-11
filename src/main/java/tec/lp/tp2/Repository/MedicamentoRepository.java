package tec.lp.tp2.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.criteria.*;
import tec.lp.tp2.model.Medicamento;
import java.util.List;

@Repository
@Transactional
public class MedicamentoRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public MedicamentoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Medicamento medicamento) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(medicamento);
    }

    public Medicamento read(String nombre) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Medicamento.class, nombre);
    }

    public void update(Medicamento medicamento) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(medicamento);
    }

    public void delete(String nombre) {
        Session session = sessionFactory.getCurrentSession();
        Medicamento medicamento = session.get(Medicamento.class, nombre);
        if (medicamento != null) {
            session.delete(medicamento);
        }
    }

    public List<Medicamento> readAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Medicamento> cq = cb.createQuery(Medicamento.class);
        Root<Medicamento> root = cq.from(Medicamento.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
