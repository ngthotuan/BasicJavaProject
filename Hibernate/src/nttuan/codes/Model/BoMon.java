package nttuan.codes.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class BoMon {
    private String maBoMon;
    private String tenBoMon;
    private String phong;
    private String dienThoai;
    private String truongBoMon;
    private String maKhoa;
    private Timestamp ngayNhanChuc;
    private GiaoVien giaoVienByTruongBoMon;
    private Khoa khoaByMaKhoa;
    private Collection<GiaoVien> giaoViensByMaBoMon;

    @Id
    @Column(name = "MaBoMon", nullable = false, length = 5)
    public String getMaBoMon() {
        return maBoMon;
    }

    public void setMaBoMon(String maBoMon) {
        this.maBoMon = maBoMon;
    }

    @Basic
    @Column(name = "TenBoMon", nullable = true, length = 40)
    public String getTenBoMon() {
        return tenBoMon;
    }

    public void setTenBoMon(String tenBoMon) {
        this.tenBoMon = tenBoMon;
    }

    @Basic
    @Column(name = "Phong", nullable = true, length = 5)
    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    @Basic
    @Column(name = "DienThoai", nullable = true, length = 12)
    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Basic
    @Column(name = "TruongBoMon", nullable = true, length = 5)
    public String getTruongBoMon() {
        return truongBoMon;
    }

    public void setTruongBoMon(String truongBoMon) {
        this.truongBoMon = truongBoMon;
    }

    @Basic
    @Column(name = "MaKhoa", nullable = true, length = 4)
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Basic
    @Column(name = "NgayNhanChuc", nullable = true)
    public Timestamp getNgayNhanChuc() {
        return ngayNhanChuc;
    }

    public void setNgayNhanChuc(Timestamp ngayNhanChuc) {
        this.ngayNhanChuc = ngayNhanChuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoMon boMon = (BoMon) o;
        return Objects.equals(maBoMon, boMon.maBoMon) &&
                Objects.equals(tenBoMon, boMon.tenBoMon) &&
                Objects.equals(phong, boMon.phong) &&
                Objects.equals(dienThoai, boMon.dienThoai) &&
                Objects.equals(truongBoMon, boMon.truongBoMon) &&
                Objects.equals(maKhoa, boMon.maKhoa) &&
                Objects.equals(ngayNhanChuc, boMon.ngayNhanChuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBoMon, tenBoMon, phong, dienThoai, truongBoMon, maKhoa, ngayNhanChuc);
    }

    @ManyToOne
    @JoinColumn(name = "TruongBoMon", referencedColumnName = "MaGiaoVien")
    public GiaoVien getGiaoVienByTruongBoMon() {
        return giaoVienByTruongBoMon;
    }

    public void setGiaoVienByTruongBoMon(GiaoVien giaoVienByTruongBoMon) {
        this.giaoVienByTruongBoMon = giaoVienByTruongBoMon;
    }

    @ManyToOne
    @JoinColumn(name = "MaKhoa", referencedColumnName = "MaKhoa")
    public Khoa getKhoaByMaKhoa() {
        return khoaByMaKhoa;
    }

    public void setKhoaByMaKhoa(Khoa khoaByMaKhoa) {
        this.khoaByMaKhoa = khoaByMaKhoa;
    }

    @OneToMany(mappedBy = "boMonByMaBoMon")
    public Collection<GiaoVien> getGiaoViensByMaBoMon() {
        return giaoViensByMaBoMon;
    }

    public void setGiaoViensByMaBoMon(Collection<GiaoVien> giaoViensByMaBoMon) {
        this.giaoViensByMaBoMon = giaoViensByMaBoMon;
    }
}
