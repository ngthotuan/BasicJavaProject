package resources;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private Integer namThanhLap;
    private String phong;
    private String dienThoai;
    private String truongKhoa;
    private Timestamp ngayNhanChuc;
    private Collection<BoMon> boMonsByMaKhoa;
    private GiaoVien giaoVienByTruongKhoa;

    @Id
    @Column(name = "MaKhoa", nullable = false, length = 4)
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Basic
    @Column(name = "TenKhoa", nullable = true, length = 40)
    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Basic
    @Column(name = "NamThanhLap", nullable = true)
    public Integer getNamThanhLap() {
        return namThanhLap;
    }

    public void setNamThanhLap(Integer namThanhLap) {
        this.namThanhLap = namThanhLap;
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
    @Column(name = "TruongKhoa", nullable = true, length = 5)
    public String getTruongKhoa() {
        return truongKhoa;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
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

        Khoa khoa = (Khoa) o;

        if (maKhoa != null ? !maKhoa.equals(khoa.maKhoa) : khoa.maKhoa != null) return false;
        if (tenKhoa != null ? !tenKhoa.equals(khoa.tenKhoa) : khoa.tenKhoa != null) return false;
        if (namThanhLap != null ? !namThanhLap.equals(khoa.namThanhLap) : khoa.namThanhLap != null) return false;
        if (phong != null ? !phong.equals(khoa.phong) : khoa.phong != null) return false;
        if (dienThoai != null ? !dienThoai.equals(khoa.dienThoai) : khoa.dienThoai != null) return false;
        if (truongKhoa != null ? !truongKhoa.equals(khoa.truongKhoa) : khoa.truongKhoa != null) return false;
        if (ngayNhanChuc != null ? !ngayNhanChuc.equals(khoa.ngayNhanChuc) : khoa.ngayNhanChuc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maKhoa != null ? maKhoa.hashCode() : 0;
        result = 31 * result + (tenKhoa != null ? tenKhoa.hashCode() : 0);
        result = 31 * result + (namThanhLap != null ? namThanhLap.hashCode() : 0);
        result = 31 * result + (phong != null ? phong.hashCode() : 0);
        result = 31 * result + (dienThoai != null ? dienThoai.hashCode() : 0);
        result = 31 * result + (truongKhoa != null ? truongKhoa.hashCode() : 0);
        result = 31 * result + (ngayNhanChuc != null ? ngayNhanChuc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "khoaByMaKhoa")
    public Collection<BoMon> getBoMonsByMaKhoa() {
        return boMonsByMaKhoa;
    }

    public void setBoMonsByMaKhoa(Collection<BoMon> boMonsByMaKhoa) {
        this.boMonsByMaKhoa = boMonsByMaKhoa;
    }

    @ManyToOne
    @JoinColumn(name = "TruongKhoa", referencedColumnName = "MaGiaoVien")
    public GiaoVien getGiaoVienByTruongKhoa() {
        return giaoVienByTruongKhoa;
    }

    public void setGiaoVienByTruongKhoa(GiaoVien giaoVienByTruongKhoa) {
        this.giaoVienByTruongKhoa = giaoVienByTruongKhoa;
    }
}
