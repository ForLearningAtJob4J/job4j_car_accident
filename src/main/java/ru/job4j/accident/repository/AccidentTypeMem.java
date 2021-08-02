package ru.job4j.accident.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentTypeMem {
    private static final AtomicInteger ACCIDENT_TYPE_ID = new AtomicInteger(0);

    private final Map<Integer, AccidentType> accidentTypes = new HashMap<>();

    public AccidentTypeMem() {
        add(AccidentType.of("Две машины"));
        add(AccidentType.of("Машина и человек"));
        add(AccidentType.of("Машина и велосипед"));
    }

    public AccidentType add(AccidentType accidentType) {
        int newId = ACCIDENT_TYPE_ID.incrementAndGet();
        accidentType.setId(newId);
        accidentTypes.put(newId, accidentType);
        return accidentType;
    }

    public AccidentType edit(AccidentType accidentType) {
        accidentTypes.put(accidentType.getId(), accidentType);
        return accidentType;
    }

    public AccidentType findById(int id) {
        return accidentTypes.get(id);
    }

    public List<AccidentType> getAll() {
        return List.copyOf(accidentTypes.values());
    }
}
