package dataStructures;

import javaBasics.BankAccount;

import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(80, "Jones");
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("China");
        countries.add("Italy");

        for (int i = 0; i < countries.size(); i++) {
            System.out.print(countries.get(i) + " ");
        }

        for (String country: countries) {
            System.out.println(country);
        }
    }
}
