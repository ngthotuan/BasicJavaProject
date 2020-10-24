package me.nguyenthotuan.main;

import me.nguyenthotuan.excelreader.impl.VocabularyExcelReader;
import me.nguyenthotuan.model.Vocabulary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            VocabularyExcelReader reader = new VocabularyExcelReader();

            ArrayList<Vocabulary> vocabularies = reader.readExcelFile("wordlist.xlsx", true);


            for(int i =1; i <= 15; i++){
                int finalI = i;
                Files.write(Paths.get(String.format("Module %d.csv", finalI)),
                        (Iterable<String>)vocabularies.stream().
                                filter(v -> v.getModule() == finalI).map(Objects::toString)::iterator);
            }
        } catch (IOException e) {
            System.err.println("Could not read file!!!");
            System.err.printf("Error message: \n%s", e.getMessage());
        }
    }
}
