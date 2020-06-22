package resources;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

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

        if (maBoMon != null ? !maBoMon.equals(boMon.maBoMon) : boMon.maBoMon != null) return false;
        if (tenBoMon != null ? !tenBoMon.equals(boMon.tenBoMon) : boMon.tenBoMon != null) return false;
        if (phong != null ? !phong.equals(boMon.phong) : boMon.phong != null) return false;
        if (dienThoai != null ? !dienThoai.equals(boMon.dienThoai) : boMon.dienThoai != null) return false;
        if (truongBoMon != null ? !truongBoMon.equals(boMon.truongBoMon) : boMon.truongBoMon != null) return false;
        if (maKhoa != null ? !maKhoa.equals(boMon.maKhoa) : boMon.maKhoa != null) return false;
        if (ngayNhanChuc != null ? !ngayNhanChuc.equals(boMon.ngayNhanChuc) : boMon.ngayNhanChuc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maBoMon != null ? maBoMon.hashCode() : 0;
        result = 31 * result + (tenBoMon != null ? tenBoMon.hashCode() : 0);
        result = 31 * result + (phong != null ? phong.hashCode() : 0);
        result = 31 * result + (dienThoai != null ? dienThoai.hashCode() : 0);
        result = 31 * result + (truongBoMon != null ? truongBoMon.hashCode() : 0);
        result = 31 * result + (maKhoa != null ? maKhoa.hashCode() : 0);
        result = 31 * result + (ngayNhanChuc != null ? ngayNhanChuc.hashCode() : 0);
        return result;
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
