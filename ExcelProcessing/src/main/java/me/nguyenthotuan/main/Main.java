package me.nguyenthotuan.main;

import me.nguyenthotuan.excelreader.IExcelReader;
import me.nguyenthotuan.excelreader.impl.VocabularyExcelReader;
import me.nguyenthotuan.model.Vocabulary;
import me.nguyenthotuan.excelreader.impl.ExcelReader;


import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            VocabularyExcelReader reader = new VocabularyExcelReader();

            ArrayList<Vocabulary> vocabularies = reader.readExcelFile("wordlist.xlsx", true);

            vocabularies.stream().filter(v -> v.getModule() == 1).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Could not read file!!!");
            System.err.printf("Error message: \n%s", e.getMessage());
        }
    }
}
