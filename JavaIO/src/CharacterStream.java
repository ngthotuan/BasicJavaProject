import java.io.*;

public class CharacterStream {
    public static void main(String[] args) throws IOException {
        FileReader fis = null;
        FileWriter fos = null;
        try {
            fis = new FileReader("xanadu.txt");
            fos = new FileWriter("test.txt");
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
