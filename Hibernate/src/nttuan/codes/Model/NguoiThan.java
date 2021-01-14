package nttuan.codes.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

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
        return Objects.equals(maGiaoVien, nguoiThan.maGiaoVien) &&
                Objects.equals(ten, nguoiThan.ten) &&
                Objects.equals(ngaySinh, nguoiThan.ngaySinh) &&
                Objects.equals(phai, nguoiThan.phai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, ten, ngaySinh, phai);
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
