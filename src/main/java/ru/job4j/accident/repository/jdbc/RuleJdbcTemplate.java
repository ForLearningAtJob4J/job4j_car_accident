package ru.job4j.accident.repository.jdbc;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.List;

//@Repository
public class RuleJdbcTemplate {
    private final JdbcTemplate jdbc;

    public RuleJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Rule add(Rule rule) {
        throw new NotImplementedException("Not implemented yet!");
    }

    public Rule edit(Rule rule) {
        throw new NotImplementedException("Not implemented yet!");
    }

    public Rule findById(int id) {
        return jdbc.queryForObject(
                "SELECT id, name FROM rule WHERE id = ?",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                }, id);
    }

    public List<Rule> getAllByAccidentId(int accidentId) {
        return jdbc.query(
                "SELECT id, name FROM rule WHERE id IN (SELECT rule_id FROM accident_rule WHERE accident_id = ?)",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                },
                accidentId);
    }

    public List<Rule> getAll() {
        return jdbc.query(
                "SELECT id, name FROM rule",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }
}
