package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Map;

@Service
public class AccidentService {
    private final AccidentMem storage;

    @Autowired
    public AccidentService(AccidentMem storage) {
        this.storage = storage;
    }

    public Map<Integer, Accident> getAll() {
        return storage.getAll();
    }
}
