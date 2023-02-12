import Internship.Internship;
import Internship.InternshipNameEnum;
import Internship.Person;
import SerializationDeserialization.Deserialization;
import SerializationDeserialization.Serialization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class JobMarket {
    public static void main(String[] args) throws IOException {
        List<Internship> internships = new ArrayList<>(getPersons("Persons.txt"));

        System.out.println("~Candidates that got a phone interview~");
        for (Internship i: internships) {
            Internship.getPhoneInterview(i);
        }

        insertPersons("PersonsByOrder.txt", internships);

        Person person1 = new Person("Ion Creanga", 40);
        Person person2 = new Person("Ion Creanga", 40);
        compare(person1, person2);

        System.out.println("\n~Sort by score asc from " + internships.get(0).getName() + "~");
        sort(internships.get(0).getPersons());


        System.out.println("\n~Serialization / Deserialization of company " + internships.get(2).getName() + "~");
        Serialization.serialization("Serialization" + internships.get(2).getName()+ ".txt", internships.get(2).getPersons(), internships.get(2));
        Deserialization.deserialization("Serialization" + internships.get(2).getName()+ ".txt");
    }

    public static List<Internship> getPersons(String path) throws IOException {
        List<Internship> internships = new ArrayList<>((int) Files.lines(Paths.get(path)).count());

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(currentLine, ",");
                InternshipNameEnum name = InternshipNameEnum.valueOf(st.nextToken());

                if (internships.size() == 0) {
                    internships.add(new Internship(name, st.nextToken()));
                    internships.get(0).setPersons(new Person(st.nextToken(), Double.parseDouble(st.nextToken())));
                } else {
                    boolean isPresent = false;

                    for (Internship i: internships) {
                        if (i.getName().equals(name)) {
                            st.nextToken();
                            i.setPersons(new Person(st.nextToken(), Double.parseDouble(st.nextToken())));
                            isPresent = true;
                        }
                    }

                    if (!isPresent) {
                        internships.add(new Internship(name, st.nextToken()));
                        internships.get(internships.size() - 1).setPersons(new Person(st.nextToken(), Double.parseDouble(st.nextToken())));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return internships;
    }

    static void insertPersons(String path, List<Internship> internships) {
        try (FileWriter fw = new FileWriter(path, false)) {
            for (Internship i: internships) {
                fw.write(i.toString() + "\n");
            }
            System.out.println("~Insertion done successfully!~\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static void compare(Person person1, Person person2) {
        StringBuilder sb = new StringBuilder();

        sb.append("Are the objects the same?\n");
        if (person1.compareTo(person2) == 0) {
            sb.append("yes");
        } else
            sb.append("no");

        System.out.println(sb);
    }

    public static void sort(List<Person> persons) {
        Comparator<Person> compareByName = Comparator
                .comparing(Person::getScore);

        List<Person> sortedEmployees = persons.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());

        for (Person i: sortedEmployees) {
            System.out.println(i.toString());
        }
    }
}
