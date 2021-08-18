package ru.job4j.accident.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accident")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String address;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AccidentType type;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "accident_rule",
            joinColumns = {@JoinColumn(name = "accident_id")},
            inverseJoinColumns = {@JoinColumn(name = "rule_id")})
    private Set<Rule> rules = new HashSet<>();

    public static Accident of(String name, String text, String address, AccidentType type, Set<Rule> rules) {
        Accident newAccident = new Accident();
        newAccident.name = name;
        newAccident.text = text;
        newAccident.address = address;
        newAccident.type = type;
        if (rules != null) {
            newAccident.rules = new HashSet<>(rules);
        }
        return newAccident;
    }

    public int getId() {
        return id;
    }

    public Accident setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Accident setName(String name) {
        this.name = name;
        return this;
    }

    public String getText() {
        return text;
    }

    public Accident setText(String text) {
        this.text = text;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Accident setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Accident accident = (Accident) o;

        return id == accident.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Accident{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", text='" + text + '\''
                + ", address='" + address + '\''
                + '}';
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public Set<Rule> getRules() {
        return new HashSet<>(rules);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }
}
