package resources;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

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

        if (maGiaoVien != null ? !maGiaoVien.equals(that.maGiaoVien) : that.maGiaoVien != null) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maGiaoVien != null ? maGiaoVien.hashCode() : 0;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        return result;
    }
}
