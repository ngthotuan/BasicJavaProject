package resources;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class DeTai {
    private String maDeTai;
    private String tenDeTai;
    private String capQuanLy;
    private Double kinhPhi;
    private Timestamp ngayBatDau;
    private Timestamp ngayKetThuc;
    private String maChuDe;
    private String giaoVienChuNhiemDeTai;
    private Collection<CongViec> congViecsByMaDeTai;
    private ChuDe chuDeByMaChuDe;
    private GiaoVien giaoVienByGiaoVienChuNhiemDeTai;

    @Id
    @Column(name = "MaDeTai", nullable = false, length = 3)
    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    @Basic
    @Column(name = "TenDeTai", nullable = true, length = 100)
    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    @Basic
    @Column(name = "CapQuanLy", nullable = true, length = 40)
    public String getCapQuanLy() {
        return capQuanLy;
    }

    public void setCapQuanLy(String capQuanLy) {
        this.capQuanLy = capQuanLy;
    }

    @Basic
    @Column(name = "KinhPhi", nullable = true, precision = 0)
    public Double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(Double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    @Basic
    @Column(name = "NgayBatDau", nullable = true)
    public Timestamp getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    @Basic
    @Column(name = "NgayKetThuc", nullable = true)
    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Basic
    @Column(name = "MaChuDe", nullable = true, length = 4)
    public String getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    @Basic
    @Column(name = "GiaoVienChuNhiemDeTai", nullable = true, length = 5)
    public String getGiaoVienChuNhiemDeTai() {
        return giaoVienChuNhiemDeTai;
    }

    public void setGiaoVienChuNhiemDeTai(String giaoVienChuNhiemDeTai) {
        this.giaoVienChuNhiemDeTai = giaoVienChuNhiemDeTai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeTai deTai = (DeTai) o;

        if (maDeTai != null ? !maDeTai.equals(deTai.maDeTai) : deTai.maDeTai != null) return false;
        if (tenDeTai != null ? !tenDeTai.equals(deTai.tenDeTai) : deTai.tenDeTai != null) return false;
        if (capQuanLy != null ? !capQuanLy.equals(deTai.capQuanLy) : deTai.capQuanLy != null) return false;
        if (kinhPhi != null ? !kinhPhi.equals(deTai.kinhPhi) : deTai.kinhPhi != null) return false;
        if (ngayBatDau != null ? !ngayBatDau.equals(deTai.ngayBatDau) : deTai.ngayBatDau != null) return false;
        if (ngayKetThuc != null ? !ngayKetThuc.equals(deTai.ngayKetThuc) : deTai.ngayKetThuc != null) return false;
        if (maChuDe != null ? !maChuDe.equals(deTai.maChuDe) : deTai.maChuDe != null) return false;
        if (giaoVienChuNhiemDeTai != null ? !giaoVienChuNhiemDeTai.equals(deTai.giaoVienChuNhiemDeTai) : deTai.giaoVienChuNhiemDeTai != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maDeTai != null ? maDeTai.hashCode() : 0;
        result = 31 * result + (tenDeTai != null ? tenDeTai.hashCode() : 0);
        result = 31 * result + (capQuanLy != null ? capQuanLy.hashCode() : 0);
        result = 31 * result + (kinhPhi != null ? kinhPhi.hashCode() : 0);
        result = 31 * result + (ngayBatDau != null ? ngayBatDau.hashCode() : 0);
        result = 31 * result + (ngayKetThuc != null ? ngayKetThuc.hashCode() : 0);
        result = 31 * result + (maChuDe != null ? maChuDe.hashCode() : 0);
        result = 31 * result + (giaoVienChuNhiemDeTai != null ? giaoVienChuNhiemDeTai.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "deTaiByMaDeTai")
    public Collection<CongViec> getCongViecsByMaDeTai() {
        return congViecsByMaDeTai;
    }

    public void setCongViecsByMaDeTai(Collection<CongViec> congViecsByMaDeTai) {
        this.congViecsByMaDeTai = congViecsByMaDeTai;
    }

    @ManyToOne
    @JoinColumn(name = "MaChuDe", referencedColumnName = "MaChuDe")
    public ChuDe getChuDeByMaChuDe() {
        return chuDeByMaChuDe;
    }

    public void setChuDeByMaChuDe(ChuDe chuDeByMaChuDe) {
        this.chuDeByMaChuDe = chuDeByMaChuDe;
    }

    @ManyToOne
    @JoinColumn(name = "GiaoVienChuNhiemDeTai", referencedColumnName = "MaGiaoVien")
    public GiaoVien getGiaoVienByGiaoVienChuNhiemDeTai() {
        return giaoVienByGiaoVienChuNhiemDeTai;
    }

    public void setGiaoVienByGiaoVienChuNhiemDeTai(GiaoVien giaoVienByGiaoVienChuNhiemDeTai) {
        this.giaoVienByGiaoVienChuNhiemDeTai = giaoVienByGiaoVienChuNhiemDeTai;
    }
}
