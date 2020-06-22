package nttuan.codes.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

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
        return Objects.equals(maDeTai, deTai.maDeTai) &&
                Objects.equals(tenDeTai, deTai.tenDeTai) &&
                Objects.equals(capQuanLy, deTai.capQuanLy) &&
                Objects.equals(kinhPhi, deTai.kinhPhi) &&
                Objects.equals(ngayBatDau, deTai.ngayBatDau) &&
                Objects.equals(ngayKetThuc, deTai.ngayKetThuc) &&
                Objects.equals(maChuDe, deTai.maChuDe) &&
                Objects.equals(giaoVienChuNhiemDeTai, deTai.giaoVienChuNhiemDeTai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDeTai, tenDeTai, capQuanLy, kinhPhi, ngayBatDau, ngayKetThuc, maChuDe, giaoVienChuNhiemDeTai);
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
