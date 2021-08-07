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

    public AccidentMem(AccidentTypeMem accidentTypeMem, RuleMem rulesMem) {
        add(new Accident("ДТП №1", "Описание обстоятельств ДТП №1", "перекресток ул. Мира, ул. Ближняя", accidentTypeMem.findById(1), Set.of(rulesMem.findById(1))));
        add(new Accident("ДТП №2", "Описание обстоятельств ДТП №2", "перекресток ул. Мира, ул. Средняя", accidentTypeMem.findById(2), Set.of(rulesMem.findById(2))));
        add(new Accident("ДТП №3", "Описание обстоятельств ДТП №3", "перекресток ул. Мира, ул. Крайняя", accidentTypeMem.findById(3), Set.of(rulesMem.findById(3))));
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
