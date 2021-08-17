package ru.job4j.accident.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident add(Accident accident) {
        return edit(accident);
    }

    public Accident edit(Accident accident) {
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();

            session.saveOrUpdate(accident);
            session.getTransaction().commit();
        }
        return accident;
    }

    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("select distinct acc from Accident acc left join fetch acc.rules", Accident.class)
                    .list();
        }
    }

    public Accident findById(int id) {
        try (Session session = sf.openSession()) {
            return session.createQuery(
                    "select distinct acc from Accident acc left join fetch acc.rules where acc.id = :id", Accident.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }
}