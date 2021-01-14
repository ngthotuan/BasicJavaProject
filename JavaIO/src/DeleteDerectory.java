import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DeleteDerectory {
    void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete())
            throw new FileNotFoundException("Failed to delete file: " + f);
    }

}
