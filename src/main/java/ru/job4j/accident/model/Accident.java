package ru.job4j.accident.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private final Set<Rule> rules;

    public Accident(String name, String text, String address, AccidentType type, Collection<Rule> rules) {
        this.name = name;
        this.text = text;
        this.address = address;
        this.type = type;
        if (rules == null) {
            rules = new HashSet<>();
        }
        this.rules = new HashSet<>(rules);
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
        this.rules.add(rule);
    }
}
