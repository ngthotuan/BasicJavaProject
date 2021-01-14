package nttuan.codes.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ThamGiaDeTaiPK.class)
public class ThamGiaDeTai {
    private String maGiaoVien;
    private String maDeTai;
    private int soThuTu;
    private Double phuCap;
    private String ketQua;
    private GiaoVien giaoVienByMaGiaoVien;
    private CongViec congViec;

    @Id
    @Column(name = "MaGiaoVien", nullable = false, length = 5)
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Id
    @Column(name = "MaDeTai", nullable = false, length = 3)
    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    @Id
    @Column(name = "SoThuTu", nullable = false)
    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    @Basic
    @Column(name = "PhuCap", nullable = true, precision = 0)
    public Double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(Double phuCap) {
        this.phuCap = phuCap;
    }

    @Basic
    @Column(name = "KetQua", nullable = true, length = 40)
    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThamGiaDeTai that = (ThamGiaDeTai) o;
        return soThuTu == that.soThuTu &&
                Objects.equals(maGiaoVien, that.maGiaoVien) &&
                Objects.equals(maDeTai, that.maDeTai) &&
                Objects.equals(phuCap, that.phuCap) &&
                Objects.equals(ketQua, that.ketQua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, maDeTai, soThuTu, phuCap, ketQua);
    }

    @ManyToOne
    @JoinColumn(name = "MaGiaoVien", referencedColumnName = "MaGiaoVien", nullable = false)
    public GiaoVien getGiaoVienByMaGiaoVien() {
        return giaoVienByMaGiaoVien;
    }

    public void setGiaoVienByMaGiaoVien(GiaoVien giaoVienByMaGiaoVien) {
        this.giaoVienByMaGiaoVien = giaoVienByMaGiaoVien;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "MaDeTai", referencedColumnName = "MaDeTai", nullable = false), @JoinColumn(name = "SoThuTu", referencedColumnName = "SoThuTu", nullable = false)})
    public CongViec getCongViec() {
        return congViec;
    }

    public void setCongViec(CongViec congViec) {
        this.congViec = congViec;
    }
}
