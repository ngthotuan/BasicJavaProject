package codes.nttuan.IO;

import java.io.*;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Scanning {

    public static void main(String[] args) throws FileNotFoundException {

//        Scanner s = null;
//        try{
//            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
////            s.useDelimiter(",");
//            s.useDelimiter(",\\s*");
//            while (s.hasNext()){
//                System.out.println(s.next());
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Khong tim thay file " + e.getMessage());
//        } finally {
//            if(s != null){
//                s.close();
//            }
//        }


        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }

        System.out.println(sum);

        BufferedWriter buff = null;
    }
}
