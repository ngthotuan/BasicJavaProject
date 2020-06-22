package pojo;

import java.io.Serializable;
import java.util.Objects;

public class ThamGiaDeTaiPK implements Serializable {
    private String maGiaoVien;
    private String maDeTai;

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
        ThamGiaDeTaiPK that = (ThamGiaDeTaiPK) o;
        return Objects.equals(maGiaoVien, that.maGiaoVien) &&
                Objects.equals(maDeTai, that.maDeTai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, maDeTai);
    }
}
