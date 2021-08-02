package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(0);

    private final Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem(AccidentTypeMem accidentTypeMem) {
        List<AccidentType> accidentTypes = accidentTypeMem.getAll();

        add(new Accident("ДТП №1", "Описание обстоятельств ДТП №1", "перекресток ул. Мира, ул. Ближняя", accidentTypes.get(0)));
        add(new Accident("ДТП №2", "Описание обстоятельств ДТП №2", "перекресток ул. Мира, ул. Средняя", accidentTypes.get(1)));
        add(new Accident("ДТП №3", "Описание обстоятельств ДТП №3", "перекресток ул. Мира, ул. Крайняя", accidentTypes.get(2)));
    }

    public Accident add(Accident accident) {
        int newId = ACCIDENT_ID.incrementAndGet();
        accident.setId(newId);
        accidents.put(newId, accident);
        return accident;
    }

    public Accident edit(Accident accident) {
        accidents.put(accident.getId(), accident);
        return accident;
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public List<Accident> getAll() {
        return List.copyOf(accidents.values());
    }
}
