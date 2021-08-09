package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.jdbc.AccidentJdbcTemplate;
import ru.job4j.accident.repository.jdbc.AccidentTypeJdbcTemplate;
import ru.job4j.accident.repository.jdbc.RuleJdbcTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentJdbcTemplate accidents;
    private final AccidentTypeJdbcTemplate accidentTypes;
    private final RuleJdbcTemplate rules;

    @Autowired
    public AccidentService(AccidentJdbcTemplate storage, AccidentTypeJdbcTemplate accidentTypes, RuleJdbcTemplate rules) {
        this.accidents = storage;
        this.accidentTypes = accidentTypes;
        this.rules = rules;
    }

    public Accident saveAccident(Accident accident) {
        if (accident.getId() == 0) {
            return accidents.add(accident);
        } else {
            return accidents.edit(accident);
        }
    }

    public AccidentType saveAccidentType(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            return accidentTypes.add(accidentType);
        } else {
            return accidentTypes.edit(accidentType);
        }
    }

    public Optional<Accident> findAccidentById(int id) {
        return Optional.of(accidents.findById(id));
    }

    public Optional<AccidentType> findAccidentTypeById(int id) {
        return Optional.of(accidentTypes.findById(id));
    }

    public Optional<Rule> findRuleById(int id) {
        return Optional.of(rules.findById(id));
    }

    public List<Accident> getAllAccidents() {
        return accidents.getAll();
    }

    public List<AccidentType> getAllAccidentTypes() {
        return accidentTypes.getAll();
    }

    public List<Rule> getAllRules() {
        return rules.getAll();
    }
}
