package Internship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Internship implements Serializable {
    private InternshipNameEnum name;
    private String minScore;
    private List<Person> persons = new ArrayList<>();

    public Internship(InternshipNameEnum name, String minScore) {
        this.name = name;
        this.minScore = minScore;
    }

    public InternshipNameEnum getName() {
        return name;
    }

    public String getMinScore() {
        return minScore;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(Person person) {
        this.persons.add(person);
    }

    public static Person getPersonsByIntershipName(Internship intership) {
        Random rand = new Random();

        System.out.println("Internship.Internship name: " + intership.getName());
        int j = rand.nextInt(intership.getPersons().size());
        return intership.getPersons().get(j);
    }

    public static void getPhoneInterview(Internship internship) {
        StringBuilder sb = new StringBuilder();

        for (Person i: internship.getPersons()) {
            if (i.getScore() >= Double.parseDouble(internship.getMinScore())) {
                sb.append("Candidate ").append(i.getName()).append(" got a phone interview at ").append(internship.getName()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Internship.Internship: ").append(name).append("\nRequired score: ").append(minScore).append("\nPersons\n");
        for(Person i: persons) {
            sb.append(i.toString()).append("\n");
        }

        return sb.toString();
    }
}
