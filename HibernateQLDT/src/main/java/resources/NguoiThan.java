package resources;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(NguoiThanPK.class)
public class NguoiThan {
    private String maGiaoVien;
    private String ten;
    private Timestamp ngaySinh;
    private String phai;
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
    @Column(name = "Ten", nullable = false, length = 20)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
    @Column(name = "Phai", nullable = true, length = 3)
    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NguoiThan nguoiThan = (NguoiThan) o;

        if (maGiaoVien != null ? !maGiaoVien.equals(nguoiThan.maGiaoVien) : nguoiThan.maGiaoVien != null) return false;
        if (ten != null ? !ten.equals(nguoiThan.ten) : nguoiThan.ten != null) return false;
        if (ngaySinh != null ? !ngaySinh.equals(nguoiThan.ngaySinh) : nguoiThan.ngaySinh != null) return false;
        if (phai != null ? !phai.equals(nguoiThan.phai) : nguoiThan.phai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maGiaoVien != null ? maGiaoVien.hashCode() : 0;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (ngaySinh != null ? ngaySinh.hashCode() : 0);
        result = 31 * result + (phai != null ? phai.hashCode() : 0);
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
