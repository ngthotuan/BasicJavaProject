package Stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class IO {
    public static void main(String[] args) {
        String fileName = "xanadu.txt";

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream //
                    .onClose(() -> System.out.println("Done!")) //
                    .filter(s -> s.startsWith("tt")) //
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
