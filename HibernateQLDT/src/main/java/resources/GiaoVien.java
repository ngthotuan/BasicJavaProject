package resources;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class GiaoVien {
    private String maGiaoVien;
    private String hoTen;
    private Double luong;
    private String phai;
    private Timestamp ngaySinh;
    private String diaChi;
    private String gvqlcm;
    private String maBoMon;
    private Collection<BoMon> boMonsByMaGiaoVien;
    private Collection<DeTai> deTaisByMaGiaoVien;
    private GiaoVien giaoVienByGvqlcm;
    private Collection<GiaoVien> giaoViensByMaGiaoVien;
    private BoMon boMonByMaBoMon;
    private Collection<GiaoVienDeTai> giaoVienDeTaisByMaGiaoVien;
    private Collection<Khoa> khoasByMaGiaoVien;
    private Collection<NguoiThan> nguoiThansByMaGiaoVien;
    private Collection<ThamGiaDeTai> thamGiaDeTaisByMaGiaoVien;

    @Id
    @Column(name = "MaGiaoVien", nullable = false, length = 5)
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Basic
    @Column(name = "HoTen", nullable = true, length = 40)
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Basic
    @Column(name = "Luong", nullable = true, precision = 0)
    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    @Basic
    @Column(name = "Phai", nullable = true, length = 3)
    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    @Basic
    @Column(name = "NgaySinh", nullable = true)
    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "DiaChi", nullable = true, length = 100)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "Gvqlcm", nullable = true, length = 5)
    public String getGvqlcm() {
        return gvqlcm;
    }

    public void setGvqlcm(String gvqlcm) {
        this.gvqlcm = gvqlcm;
    }

    @Basic
    @Column(name = "MaBoMon", nullable = true, length = 5)
    public String getMaBoMon() {
        return maBoMon;
    }

    public void setMaBoMon(String maBoMon) {
        this.maBoMon = maBoMon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GiaoVien giaoVien = (GiaoVien) o;

        if (maGiaoVien != null ? !maGiaoVien.equals(giaoVien.maGiaoVien) : giaoVien.maGiaoVien != null) return false;
        if (hoTen != null ? !hoTen.equals(giaoVien.hoTen) : giaoVien.hoTen != null) return false;
        if (luong != null ? !luong.equals(giaoVien.luong) : giaoVien.luong != null) return false;
        if (phai != null ? !phai.equals(giaoVien.phai) : giaoVien.phai != null) return false;
        if (ngaySinh != null ? !ngaySinh.equals(giaoVien.ngaySinh) : giaoVien.ngaySinh != null) return false;
        if (diaChi != null ? !diaChi.equals(giaoVien.diaChi) : giaoVien.diaChi != null) return false;
        if (gvqlcm != null ? !gvqlcm.equals(giaoVien.gvqlcm) : giaoVien.gvqlcm != null) return false;
        if (maBoMon != null ? !maBoMon.equals(giaoVien.maBoMon) : giaoVien.maBoMon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maGiaoVien != null ? maGiaoVien.hashCode() : 0;
        result = 31 * result + (hoTen != null ? hoTen.hashCode() : 0);
        result = 31 * result + (luong != null ? luong.hashCode() : 0);
        result = 31 * result + (phai != null ? phai.hashCode() : 0);
        result = 31 * result + (ngaySinh != null ? ngaySinh.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + (gvqlcm != null ? gvqlcm.hashCode() : 0);
        result = 31 * result + (maBoMon != null ? maBoMon.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "giaoVienByTruongBoMon")
    public Collection<BoMon> getBoMonsByMaGiaoVien() {
        return boMonsByMaGiaoVien;
    }

    public void setBoMonsByMaGiaoVien(Collection<BoMon> boMonsByMaGiaoVien) {
        this.boMonsByMaGiaoVien = boMonsByMaGiaoVien;
    }

    @OneToMany(mappedBy = "giaoVienByGiaoVienChuNhiemDeTai")
    public Collection<DeTai> getDeTaisByMaGiaoVien() {
        return deTaisByMaGiaoVien;
    }

    public void setDeTaisByMaGiaoVien(Collection<DeTai> deTaisByMaGiaoVien) {
        this.deTaisByMaGiaoVien = deTaisByMaGiaoVien;
    }

    @ManyToOne
    @JoinColumn(name = "Gvqlcm", referencedColumnName = "MaGiaoVien")
    public GiaoVien getGiaoVienByGvqlcm() {
        return giaoVienByGvqlcm;
    }

    public void setGiaoVienByGvqlcm(GiaoVien giaoVienByGvqlcm) {
        this.giaoVienByGvqlcm = giaoVienByGvqlcm;
    }

    @OneToMany(mappedBy = "giaoVienByGvqlcm")
    public Collection<GiaoVien> getGiaoViensByMaGiaoVien() {
        return giaoViensByMaGiaoVien;
    }

    public void setGiaoViensByMaGiaoVien(Collection<GiaoVien> giaoViensByMaGiaoVien) {
        this.giaoViensByMaGiaoVien = giaoViensByMaGiaoVien;
    }

    @ManyToOne
    @JoinColumn(name = "MaBoMon", referencedColumnName = "MaBoMon")
    public BoMon getBoMonByMaBoMon() {
        return boMonByMaBoMon;
    }

    public void setBoMonByMaBoMon(BoMon boMonByMaBoMon) {
        this.boMonByMaBoMon = boMonByMaBoMon;
    }

    @OneToMany(mappedBy = "giaoVienByMaGiaoVien")
    public Collection<GiaoVienDeTai> getGiaoVienDeTaisByMaGiaoVien() {
        return giaoVienDeTaisByMaGiaoVien;
    }

    public void setGiaoVienDeTaisByMaGiaoVien(Collection<GiaoVienDeTai> giaoVienDeTaisByMaGiaoVien) {
        this.giaoVienDeTaisByMaGiaoVien = giaoVienDeTaisByMaGiaoVien;
    }

    @OneToMany(mappedBy = "giaoVienByTruongKhoa")
    public Collection<Khoa> getKhoasByMaGiaoVien() {
        return khoasByMaGiaoVien;
    }

    public void setKhoasByMaGiaoVien(Collection<Khoa> khoasByMaGiaoVien) {
        this.khoasByMaGiaoVien = khoasByMaGiaoVien;
    }

    @OneToMany(mappedBy = "giaoVienByMaGiaoVien")
    public Collection<NguoiThan> getNguoiThansByMaGiaoVien() {
        return nguoiThansByMaGiaoVien;
    }

    public void setNguoiThansByMaGiaoVien(Collection<NguoiThan> nguoiThansByMaGiaoVien) {
        this.nguoiThansByMaGiaoVien = nguoiThansByMaGiaoVien;
    }

    @OneToMany(mappedBy = "giaoVienByMaGiaoVien")
    public Collection<ThamGiaDeTai> getThamGiaDeTaisByMaGiaoVien() {
        return thamGiaDeTaisByMaGiaoVien;
    }

    public void setThamGiaDeTaisByMaGiaoVien(Collection<ThamGiaDeTai> thamGiaDeTaisByMaGiaoVien) {
        this.thamGiaDeTaisByMaGiaoVien = thamGiaDeTaisByMaGiaoVien;
    }
}
