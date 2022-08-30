package jsonParsing;

import java.util.List;

/** This class stores an ArrayList of Person-s.
 *  Used while parsing a json file that contains info about several people.
 */
public class People {
    private List<Person> people;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < people.size(); i++) {
           sb.append(people.get(i));
           sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
