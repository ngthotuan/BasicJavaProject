package nttuan.codes.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GiaoVienDeTaiPK implements Serializable {
    private String maGiaoVien;
    private String dienThoai;

    @Column(name = "MaGiaoVien", nullable = false, length = 5)
    @Id
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Column(name = "DienThoai", nullable = false, length = 12)
    @Id
    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaoVienDeTaiPK that = (GiaoVienDeTaiPK) o;
        return Objects.equals(maGiaoVien, that.maGiaoVien) &&
                Objects.equals(dienThoai, that.dienThoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, dienThoai);
    }
}
