package resources;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

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

        if (maGiaoVien != null ? !maGiaoVien.equals(that.maGiaoVien) : that.maGiaoVien != null) return false;
        if (dienThoai != null ? !dienThoai.equals(that.dienThoai) : that.dienThoai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maGiaoVien != null ? maGiaoVien.hashCode() : 0;
        result = 31 * result + (dienThoai != null ? dienThoai.hashCode() : 0);
        return result;
    }
}
