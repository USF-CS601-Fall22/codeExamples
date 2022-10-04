package multithreading.poolOfThreads;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**  A single-threaded program. Counts all .json files inside a given directory and its subdirectories.
 *   No multithreading. */
public class JsonFileCounter {
    private int count;

    public JsonFileCounter(){
        count = 0;
    }

    public void countFiles(Path directory) {
        try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(directory)) {
            for (Path path: filesAndFolders) {
                if (Files.isDirectory(path))
                    countFiles(path);
                else {
                    if (path.toString().endsWith(".json")) {
                        System.out.println(path);
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        JsonFileCounter fileCounter = new JsonFileCounter();
        fileCounter.countFiles(Paths.get("input/reviews"));
        System.out.println(fileCounter.getCount());

    }

}
