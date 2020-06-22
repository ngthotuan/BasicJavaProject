import java.io.File;
import java.io.IOException;

public class DeleteFiles {
    static void deleteDirectoryRecursionJava6(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursionJava6(entry);
                }
            }
        }
        if(file.isHidden()){
//            if (!file.delete()) {
//                throw new IOException("Failed to delete " + file);
//            }
            System.out.println(file.getPath());
        }
    }

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir"));
        try {
            System.out.println(file.getPath());
            deleteDirectoryRecursionJava6(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
