package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentMem storage;

    @Autowired
    public AccidentService(AccidentMem storage) {
        this.storage = storage;
    }

    public Accident add(Accident accident) {
        if (accident.getId() == 0) {
            return storage.add(accident);
        } else {
            return storage.edit(accident);
        }
    }

    public Optional<Accident> findById(int id) {
        return Optional.of(storage.findById(id));
    }

    public List<Accident> getAll() {
        return storage.getAll();
    }
}
