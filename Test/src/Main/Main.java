package Main;


import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("={'page 1'!A4:F48");

        for(int i = 2; i <= 26; i++){
            builder.append(String.format("; 'page %d'!A2:F49", i));
        }
        builder.append("}");
        try {
            FileWriter myWriter = new FileWriter("out.txt");
            myWriter.write(builder.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
