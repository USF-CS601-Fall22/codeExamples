package multithreading.poolOfThreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MultithreadedJsonFileCounter {
    private int count;
    private ExecutorService executor;
    private Logger logger = LogManager.getLogger();
    private Phaser phaser;

    public MultithreadedJsonFileCounter(){
        count = 0;
        executor = Executors.newFixedThreadPool(5);
        phaser = new Phaser();
    }

    private class DirectoryWorker implements Runnable {
        Path dir;
        int localCount = 0;
        DirectoryWorker(Path dir) {
            this.dir = dir;
        }

        @Override
        public void run() {
            if (!Files.isDirectory(dir)) {
                return;
            }
            try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(dir)) {
                for (Path path: filesAndFolders) {
                    if (Files.isDirectory(path)) {
                        DirectoryWorker worker =  new DirectoryWorker(path);
                        logger.debug("Created a worker for " + path);
                        phaser.register();
                        executor.submit(worker);
                    }
                    else {
                        if (path.toString().endsWith(".json")) {
                            System.out.println(path);
                            localCount++;
                            //incrementCount();
                        }
                    }
                }
                combineCounts(localCount);
                logger.debug("Worker is done processing " + dir + "  current count = " + getCount());

            } catch (IOException e) {
                System.out.println(e);
            }
            finally {
                phaser.arrive();
            }

        }
    }

    public synchronized void incrementCount() {
        count++;
    }

    public synchronized void combineCounts(int localCount) {
        count += localCount;
    }

    public void countFiles(Path directory) {
       DirectoryWorker worker = new DirectoryWorker(directory);
       logger.debug("Created a worker for " + directory);
       phaser.register();
       executor.submit(worker);

       int phase = phaser.getPhase();
       phaser.awaitAdvance(phase);
       System.out.println(getCount());

       shutdownExecutor();
    }

    public synchronized int getCount() {
        logger.debug("Great! We have a result: " + count);
        return count;
    }

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MultithreadedJsonFileCounter fileCounter = new MultithreadedJsonFileCounter();
        fileCounter.countFiles(Paths.get("input/reviews"));
        // System.out.println(fileCounter.getCount());
    }

}
