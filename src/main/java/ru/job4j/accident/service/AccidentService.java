package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.hibernate.AccidentHibernate;
import ru.job4j.accident.repository.hibernate.AccidentTypeHibernate;
import ru.job4j.accident.repository.hibernate.RuleHibernate;
import ru.job4j.accident.repository.springdata.AccidentRepository;
import ru.job4j.accident.repository.springdata.AccidentTypeRepository;
import ru.job4j.accident.repository.springdata.RuleRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentRepository accidents;
    private final AccidentTypeRepository accidentTypes;
    private final RuleRepository rules;

    @Autowired
    public AccidentService(AccidentRepository storage, AccidentTypeRepository accidentTypes, RuleRepository rules) {
        this.accidents = storage;
        this.accidentTypes = accidentTypes;
        this.rules = rules;
    }

    public Accident saveAccident(Accident accident) {
        return accidents.save(accident);
    }

    public Optional<Accident> findAccidentById(int id) {
        return accidents.findByIdWithRules(id);
    }

    public Optional<AccidentType> findAccidentTypeById(int id) {
        return accidentTypes.findById(id);
    }

    public Optional<Rule> findRuleById(int id) {
        return rules.findById(id);
    }

    public List<Accident> getAllAccidents() {
        return accidents.findAllWithRules();
    }

    public List<AccidentType> getAllAccidentTypes() {
        return (List<AccidentType>) accidentTypes.findAll();
    }

    public List<Rule> getAllRules() {
        return (List<Rule>) rules.findAll();
    }
}
