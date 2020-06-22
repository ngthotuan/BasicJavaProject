package resources;

import javax.persistence.*;

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

        if (soThuTu != that.soThuTu) return false;
        if (maGiaoVien != null ? !maGiaoVien.equals(that.maGiaoVien) : that.maGiaoVien != null) return false;
        if (maDeTai != null ? !maDeTai.equals(that.maDeTai) : that.maDeTai != null) return false;
        if (phuCap != null ? !phuCap.equals(that.phuCap) : that.phuCap != null) return false;
        if (ketQua != null ? !ketQua.equals(that.ketQua) : that.ketQua != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maGiaoVien != null ? maGiaoVien.hashCode() : 0;
        result = 31 * result + (maDeTai != null ? maDeTai.hashCode() : 0);
        result = 31 * result + soThuTu;
        result = 31 * result + (phuCap != null ? phuCap.hashCode() : 0);
        result = 31 * result + (ketQua != null ? ketQua.hashCode() : 0);
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

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "MaDeTai", referencedColumnName = "MaDeTai", nullable = false), @JoinColumn(name = "SoThuTu", referencedColumnName = "SoThuTu", nullable = false)})
    public CongViec getCongViec() {
        return congViec;
    }

    public void setCongViec(CongViec congViec) {
        this.congViec = congViec;
    }
}
