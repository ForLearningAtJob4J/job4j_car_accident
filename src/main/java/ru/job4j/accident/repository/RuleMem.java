package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RuleMem {
    private static final AtomicInteger RULE_ID = new AtomicInteger(0);

    private final Map<Integer, Rule> rules = new HashMap<>();

    public RuleMem() {
        add(Rule.of("Статья 1"));
        add(Rule.of("Статья 1.1"));
        add(Rule.of("Статья 2"));
        add(Rule.of("Статья 3"));
    }

    public Rule add(Rule rule) {
        int newId = RULE_ID.incrementAndGet();
        rule.setId(newId);
        rules.put(newId, rule);
        return rule;
    }

    public Rule edit(Rule rule) {
        rules.put(rule.getId(), rule);
        return rule;
    }

    public Rule findById(int id) {
        return rules.get(id);
    }

    public List<Rule> getAll() {
        return List.copyOf(rules.values());
    }
}
