import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamIO {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("xanadu.txt");
            fos = new FileOutputStream("test.txt");
            int c, count = 0;
            while ((c = fis.read()) != -1){
                count++;
                System.out.println(c);
                fos.write(c);
            }
            System.out.println("count: "+ count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                fos.close();
            }
            if(fos != null){
                fos.close();
            }
        }
    }
}
