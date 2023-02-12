package SerializationDeserialization;

import Internship.Internship;
import Internship.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Serialization {
    public static void serialization(String fileName, List<Person> persons, Internship internship) {
        try (ObjectOutputStream objs = new ObjectOutputStream(new FileOutputStream(fileName))) {
            List<Person> saved = new ArrayList<>();
            Random rand = new Random();

            for (Person i: persons) {
                if (i.getScore() >= Double.parseDouble(internship.getMinScore())) {
                    i.setCod(String.valueOf(rand.nextInt(500_000)));
                    saved.add(i);
                }
            }

            objs.writeObject(saved);
            System.out.println("Serialization done succesfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
