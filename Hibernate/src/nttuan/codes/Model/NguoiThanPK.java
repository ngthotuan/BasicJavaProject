package nttuan.codes.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class NguoiThanPK implements Serializable {
    private String maGiaoVien;
    private String ten;

    @Column(name = "MaGiaoVien", nullable = false, length = 5)
    @Id
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Column(name = "Ten", nullable = false, length = 20)
    @Id
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NguoiThanPK that = (NguoiThanPK) o;
        return Objects.equals(maGiaoVien, that.maGiaoVien) &&
                Objects.equals(ten, that.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, ten);
    }
}
