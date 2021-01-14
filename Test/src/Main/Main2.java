package Main;

import model.SinhVien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<SinhVien> sinhViens = Arrays.asList(
                new SinhVien(),
                new SinhVien("123", "ewr")
        );
        sinhViens.sort(Comparator.comparing(SinhVien::getId));
        System.out.println(sinhViens);
    }
}
