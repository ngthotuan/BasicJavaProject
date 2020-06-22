package pojo;

import java.util.Objects;

public class ThamGiaDeTai {
    private String maGiaoVien;
    private String maDeTai;
    private GiaoVien giaoVienByMaGiaoVien;
    private DeTai deTaiByMaDeTai;

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThamGiaDeTai that = (ThamGiaDeTai) o;
        return Objects.equals(maGiaoVien, that.maGiaoVien) &&
                Objects.equals(maDeTai, that.maDeTai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, maDeTai);
    }

    public GiaoVien getGiaoVienByMaGiaoVien() {
        return giaoVienByMaGiaoVien;
    }

    public void setGiaoVienByMaGiaoVien(GiaoVien giaoVienByMaGiaoVien) {
        this.giaoVienByMaGiaoVien = giaoVienByMaGiaoVien;
    }

    public DeTai getDeTaiByMaDeTai() {
        return deTaiByMaDeTai;
    }

    public void setDeTaiByMaDeTai(DeTai deTaiByMaDeTai) {
        this.deTaiByMaDeTai = deTaiByMaDeTai;
    }
}
