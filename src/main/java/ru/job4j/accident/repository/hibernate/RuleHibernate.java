package ru.job4j.accident.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.List;

@Repository
public class RuleHibernate {
    private final SessionFactory sf;

    public RuleHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Rule findById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Rule.class, id);
        }
    }

    public List<Rule> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("select r from Rule r", Rule.class)
                    .list();
        }
    }
}
