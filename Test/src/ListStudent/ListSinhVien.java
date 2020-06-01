package ListStudent;

import model.SinhVien;

import java.util.ArrayList;

public class ListSinhVien {
    private ArrayList<SinhVien> listSV = null;

    public ListSinhVien() {
        this.listSV = new ArrayList<>();
    }

    public ListSinhVien(ArrayList<SinhVien> listSV) {
        this.listSV = listSV;
    }

    public ArrayList<SinhVien> getListSV() {
        return listSV;
    }

    public void setListSV(ArrayList<SinhVien> listSV) {
        this.listSV = listSV;
    }

    public void addSV(int n){
        for(int i = 0; i< n; i++){
            SinhVien sv = new SinhVien(i+ "", "Tên + " + i);
            listSV.add(sv);
        }
    }

    public void printList(){
        for(SinhVien sv : listSV){
            System.out.println(sv);
        }
    }
}
