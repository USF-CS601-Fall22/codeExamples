package jsonParsing;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** The example demonstrates reading from a JSON file */
public class JsonProcessing {
    public static void main(String[] args) {
        //parseFruitFile("input/fruit.json");
        // parsePersonInfo("input/personInfo.json");
        parsePeopleArray("input/people.json");
    }

    /**
     * This method demonstrates how to parse a simple json file
     * that contains info about fruits; using GSON library.
     * Look at fruit.json and class Fruit.
     *
     * @param filePath path to the json file
     */
    public static void parseFruitFile(String filePath) {
        Gson gson = new Gson();
        System.out.println("Created the following object from fruit.json :");
        System.out.println();

        try (FileReader br = new FileReader(filePath)) {
            Fruit fruit = gson.fromJson(br, Fruit.class);
            System.out.println(fruit);
        } catch (IOException e) {
            System.out.println("Could not read the file:" + e);
        }
    }


    /**
     * This method demonstrates how to parse a json file
     * that contains info about a person using GSON library.
     * Person has an address that is also a Json object.
     * See exJsonPersonInfo.json and classes Person and Address.
     *
     * @param filePath path to the json file
     */
    public static void parsePersonInfo(String filePath) {
        Gson gson = new Gson();

        try (FileReader br = new FileReader(filePath)) {
            // Parse the json file into a Person object
            Person p = gson.fromJson(br, Person.class);
            System.out.println("Created the following object from exJsonPersonInfo.json file:");
            System.out.println();
            System.out.println(p);

            // If we want to do the opposite:
            // save an object p of class Person to a json file:
            Gson gsonForWriting = new GsonBuilder().setPrettyPrinting().create();
            String jsonInString = gsonForWriting.toJson(p);
            System.out.println();
            System.out.println("Write the object to the json file: ");
            //PrintWriter pw = new PrintWriter("output.json");
            //pw.println(jsonInString);
            //pw.flush();
            System.out.println(jsonInString);
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e);
        }
    }

    /**
     * This method demonstrates how to parse a json file
     * that contains info about several people (value stored in a JSON Array).
     * Uses GSON library.
     *
     * @param filePath path to the json file
     */
    public static void parsePeopleArray(String filePath) {
        Gson gson = new Gson();

        try (FileReader br = new FileReader(filePath)) {
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(br);

            // Alternatively, we could have done:
            // String fileData = new String(Files.readAllBytes(Paths.get(filePath)));
            // JsonObject jo = (JsonObject) parser.parse(fileData);

            JsonArray jsonArr = jo.getAsJsonArray("people");


            // The commented code is if we want to use an ArrayList instead of array of Person-s
            //Type peopleType = new TypeToken<ArrayList<Person>>(){}.getType();
            //ArrayList<Person> people = gson.fromJson(jsonArr, peopleType);
            Person[] people = gson.fromJson(jsonArr, Person[].class);
            for (Person p : people) {
                System.out.println(p);
                System.out.println();
            }

            // Another  way of reading from json to a class would be:
            // People people = gson.fromJson(br, People.class);

        } catch (IOException e) {
            System.out.println("Could not read the file: " + e);
        }
    }

    public static void parseHotelFile(String filePath) {
        // FILL IN CODE: parse hotel.json that contains info about one hotel
        // Store the data in an object of class Hotel

    }
}
