package resources;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "MaGiaoVien", referencedColumnName = "MaGiaoVien", nullable = false)
    public GiaoVien getGiaoVienByMaGiaoVien() {
        return giaoVienByMaGiaoVien;
    }

    public void setGiaoVienByMaGiaoVien(GiaoVien giaoVienByMaGiaoVien) {
        this.giaoVienByMaGiaoVien = giaoVienByMaGiaoVien;
    }
}
