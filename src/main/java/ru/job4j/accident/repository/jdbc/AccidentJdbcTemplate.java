package ru.job4j.accident.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;
    private final RowMapper<Accident> rowMapper;

    public AccidentJdbcTemplate(JdbcTemplate jdbc, AccidentTypeJdbcTemplate types, RuleJdbcTemplate rules) {
        this.jdbc = jdbc;

        rowMapper = (rs, row) -> new Accident(
                rs.getString("name"),
                rs.getString("text"),
                rs.getString("address"),
                types.findById(rs.getInt("type_id")),
                rules.getAllByAccidentId(rs.getInt("id")))
                .setId(rs.getInt("id"));
    }

    private void recreateRules(Accident accident) {
        jdbc.update("DELETE FROM accident_rule WHERE accident_id = (?)", accident.getId());
        accident.getRules().forEach(el -> jdbc.update(
                "INSERT INTO accident_rule (accident_id, rule_id) VALUES (?, ?)",
                accident.getId(),
                el.getId()));
    }

    public Accident add(Accident accident) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO accident (name, text, address, type_id) VALUES (?, ?, ?, ?)", new String[]{"id"});
            ps.setString(1, accident.getName());
            ps.setString(2, accident.getText());
            ps.setString(3, accident.getAddress());
            ps.setInt(4, accident.getType().getId());
            return ps;
        }, keyHolder);
        accident.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        recreateRules(accident);
        return accident;
    }

    public Accident edit(Accident accident) {
        jdbc.update(
                "UPDATE accident SET name = ?, text = ?, address = ?, type_id = ? WHERE id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getType().getId(),
                accident.getId());
        recreateRules(accident);
        return accident;
    }

    public Accident findById(int id) {
        return jdbc.queryForObject(
                "SELECT id, name, text, address, type_id FROM accident WHERE id = ?", rowMapper, id);
    }

    public List<Accident> getAll() {
        return jdbc.query("SELECT id, name, text, address, type_id FROM accident", rowMapper);
    }
}