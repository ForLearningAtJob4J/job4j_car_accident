package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.repository.AccidentTypeMem;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentMem accidents;
    private final AccidentTypeMem accidentTypes;

    @Autowired
    public AccidentService(AccidentMem storage, AccidentTypeMem accidentTypes) {
        this.accidents = storage;
        this.accidentTypes = accidentTypes;
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

    public List<Accident> getAllAccidents() {
        return accidents.getAll();
    }

    public List<AccidentType> getAllAccidentTypes() {
        return accidentTypes.getAll();
    }
}
