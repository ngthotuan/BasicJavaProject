package nttuan.codes.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

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
        return Objects.equals(maKhoa, khoa.maKhoa) &&
                Objects.equals(tenKhoa, khoa.tenKhoa) &&
                Objects.equals(namThanhLap, khoa.namThanhLap) &&
                Objects.equals(phong, khoa.phong) &&
                Objects.equals(dienThoai, khoa.dienThoai) &&
                Objects.equals(truongKhoa, khoa.truongKhoa) &&
                Objects.equals(ngayNhanChuc, khoa.ngayNhanChuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhoa, tenKhoa, namThanhLap, phong, dienThoai, truongKhoa, ngayNhanChuc);
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
