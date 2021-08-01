package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private static final AtomicInteger ACCIDENT_ID = new AtomicInteger(0);

    private static final Map<Integer, Accident> ACCIDENTS = new HashMap<>();

    {
        add(new Accident().setName("Авария №1")
                .setText("ДТП с участием двух автомобилей")
                .setAddress("перекресток ул. Мира, ул. Ленина"));
        add(new Accident().setName("Авария №2")
                .setText("ДТП с участием пешехода")
                .setAddress("перекресток ул. Мира, ул. Ленина"));
        add(new Accident().setName("Авария №3")
                .setText("ДТП с участием автомобиля и велосипедиста")
                .setAddress("перекресток ул. Мира, ул. Ленина"));
    }

    public Accident add(Accident accident) {
        int newId = ACCIDENT_ID.incrementAndGet();
        accident.setId(newId);
        ACCIDENTS.put(newId, accident);
        return accident;
    }

    public Optional<Accident> findById(int id) {
        return Optional.of(ACCIDENTS.get(id));
    }

    public Map<Integer, Accident> getAll() {
        return Collections.unmodifiableMap(ACCIDENTS);
    }
}
