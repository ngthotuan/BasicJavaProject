package Stream.Speed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static void writeFile(String fileName, Stream<String> values){
        try {
            Files.write(Paths.get(fileName), (Iterable<String>) values::iterator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<String> values = DummyData.createDummyDataString(1000);
        long startTime, count, endTime, millis;

        // sequential sort
        startTime = System.nanoTime();
//        count = values.stream().sorted().count();
//        System.out.println(count);
        writeFile("sequential.txt", values.stream().sorted());
        endTime = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // parallel sort
        startTime = System.nanoTime();
//        count = values.parallelStream().sorted().count();
//        System.out.println(count);
        writeFile("parallel.txt", values.stream().sorted());

        endTime = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(String.format("parallel sort took: %d ms", millis));

    }
}
