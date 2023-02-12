package CompareToMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Andrei", 19, "andryha@mail.ru");
        User user2 = new User("Oleg", 25, "oleg@mail.ru");
        User user3 = new User("Andrei", 24,"opr@google.com");
        User user4 = new User("Ion", 16, "igor@mail.ru");
        User user5 = new User("Andrei", 44,"stary@google.com");
        List<User> list = new ArrayList<>();

        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        System.out.println("-------Pana la sortare--------");
        for (User u : list) {
            System.out.println(u);
        }

        System.out.println("\n-------Dupa sortare-----");
        Collections.sort(list);
        for (User u : list) {
            System.out.println(u);
        }
    }
}
