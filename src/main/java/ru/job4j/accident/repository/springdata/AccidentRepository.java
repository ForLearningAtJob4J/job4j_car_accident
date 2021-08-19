package ru.job4j.accident.repository.springdata;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.accident.model.Accident;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @Query(value = "select distinct acc from Accident acc left join fetch acc.rules")
    List<Accident> findAllWithRules();

    @Query(value = "select distinct acc from Accident acc left join fetch acc.rules where acc.id = :id")
    Optional<Accident> findByIdWithRules(@Param("id") int id);
}