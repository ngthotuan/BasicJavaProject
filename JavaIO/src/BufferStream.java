import java.io.*;
import java.util.stream.Stream;

public class BufferStream {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("xanadu.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

            String buffer;
            while ((buffer = bufferedReader.readLine()) != null){
                bufferedWriter.write(buffer+"\n");
            }
        } catch (FileNotFoundException e){
            System.err.println("Can't not find file: "+ e.getMessage());
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }
}
