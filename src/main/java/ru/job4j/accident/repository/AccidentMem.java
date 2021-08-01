package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(0);

    private final Map<Integer, Accident> accidents = new HashMap<>();

    {
        add(new Accident("Авария №1", "ДТП с участием двух автомобилей", "перекресток ул. Мира, ул. Ленина"));
        add(new Accident("Авария №2", "ДТП с участием пешехода", "перекресток ул. Мира, ул. Ленина"));
        add(new Accident("Авария №3", "ДТП с участием автомобиля и велосипедиста", "перекресток ул. Мира, ул. Ленина"));
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
