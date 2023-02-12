package SerializationDeserialization;

import Internship.Person;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserialization {
    public static void deserialization(String fileName) {
        try (ObjectInputStream obji = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Person> retreived = (List<Person>) obji.readObject();

            StringBuilder sb = new StringBuilder();
            FileWriter writer = new FileWriter(fileName, false);

            for (Person i: retreived) {
                sb.append(i.toString()).append(" ").append(i.getCod()).append("\n");
            }

            writer.write(sb.toString());
            writer.close();
            System.out.println("Deserialization done succesfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
