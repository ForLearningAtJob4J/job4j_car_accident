package ru.job4j.accident.repository.jdbc;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.List;

//@Repository
public class AccidentTypeJdbcTemplate {
        private final JdbcTemplate jdbc;

        public AccidentTypeJdbcTemplate(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }

        public AccidentType add(AccidentType model) {
            throw new NotImplementedException("Not implemented yet!");
        }

        public AccidentType edit(AccidentType model) {
            throw new NotImplementedException("Not implemented yet!");
        }

        public AccidentType findById(int id) {
            return jdbc.queryForObject(
                    "SELECT id, name FROM type WHERE id = ?",
                    (rs, row) -> {
                        AccidentType type = new AccidentType();
                        type.setId(rs.getInt("id"));
                        type.setName(rs.getString("name"));
                        return type;
                    }, id);
        }

        public List<AccidentType> getAll() {
            return jdbc.query(
                    "SELECT id, name FROM type",
                    (rs, row) -> {
                        AccidentType type = new AccidentType();
                        type.setId(rs.getInt("id"));
                        type.setName(rs.getString("name"));
                        return type;
                    });
        }
    }
