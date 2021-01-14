package nttuan.codes.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(GiaoVienDeTaiPK.class)
public class GiaoVienDeTai {
    private String maGiaoVien;
    private String dienThoai;
    private GiaoVien giaoVienByMaGiaoVien;

    @Id
    @Column(name = "MaGiaoVien", nullable = false, length = 5)
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Id
    @Column(name = "DienThoai", nullable = false, length = 12)
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
        GiaoVienDeTai that = (GiaoVienDeTai) o;
        return Objects.equals(maGiaoVien, that.maGiaoVien) &&
                Objects.equals(dienThoai, that.dienThoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, dienThoai);
    }

    @ManyToOne
    @JoinColumn(name = "MaGiaoVien", referencedColumnName = "MaGiaoVien", nullable = false)
    public GiaoVien getGiaoVienByMaGiaoVien() {
        return giaoVienByMaGiaoVien;
    }

    public void setGiaoVienByMaGiaoVien(GiaoVien giaoVienByMaGiaoVien) {
        this.giaoVienByMaGiaoVien = giaoVienByMaGiaoVien;
    }
}
