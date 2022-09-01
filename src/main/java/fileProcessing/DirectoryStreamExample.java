package fileProcessing;


import java.io.IOException;
import java.nio.file.*;


/** Demonstrates how to use DirectoryStream to get all files and subdirectories
 *  in a given directory */
public class DirectoryStreamExample {

    /** Prints the names of all files in a given directory (on the top level,
     * without going into subdirectories
     * @param directory directory where the method searches for files
     */
    public static void processFiles(String directory) {

        Path p = Paths.get(directory);
        try (DirectoryStream<Path> pathsInDir = Files.newDirectoryStream(p)) {
            for (Path path : pathsInDir) {
                // print the name of each file in the directory
                //if (!Files.isDirectory(path) && (path.toString().endsWith(".java")))
                    System.out.println(path);

            }
        } catch (IOException e) {
            System.out.println("Can not open directory: " + directory);
        }
    }

    /**
     * The main function
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //Path path = Paths.get("src/main/java", "dataStructures");

        DirectoryStreamExample.processFiles("src/main/java");

    }
}
