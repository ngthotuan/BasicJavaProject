package codes.nttuan.IO;

import java.io.*;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class DataStream {


    public static void main(String[] args) {
        final String dataFile = "invoicedata";
        final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
        final int[] units = {12, 8, 13, 29, 50};
        final String[] descs = {
                "Java T-shirt",
                "Java Mug",
                "Duke Juggling Dolls",
                "Java Pin",
                "Java Key Chain"
        };

        //write files
        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

            for(int i = 0; i < prices.length; i++){
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Readfile
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            double price ;
            int unit;
            String desc;
            double total = 0;
            try {
                while (true) {
                    price = in.readDouble();
                    unit = in.readInt();
                    desc = in.readUTF();
                    System.out.format("You ordered %d" + " units of %s at $%.2f%n",
                            unit, desc, price);
                    total += unit*price;
                }
            } catch (EOFException e){}
            System.out.printf("Total: %.2f", total);
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
