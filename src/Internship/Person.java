package Internship;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Comparable<Person>, Serializable {
    private String name;
    private double score;
    private String cod;

    public Person(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(" ").append(score);

        return sb.toString();
    }

    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getName)
                .thenComparing(Person::getScore)
                .compare(this, o);
    }
}
