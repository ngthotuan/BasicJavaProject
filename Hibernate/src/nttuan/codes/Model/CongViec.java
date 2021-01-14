package nttuan.codes.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@IdClass(CongViecPK.class)
public class CongViec {
    private String maDeTai;
    private int soThuTu;
    private String tenCongViec;
    private Timestamp ngayBatDau;
    private Timestamp ngayKetThuc;
    private DeTai deTaiByMaDeTai;
    private Collection<ThamGiaDeTai> thamGiaDeTais;

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
    @Column(name = "TenCongViec", nullable = true, length = 40)
    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CongViec congViec = (CongViec) o;
        return soThuTu == congViec.soThuTu &&
                Objects.equals(maDeTai, congViec.maDeTai) &&
                Objects.equals(tenCongViec, congViec.tenCongViec) &&
                Objects.equals(ngayBatDau, congViec.ngayBatDau) &&
                Objects.equals(ngayKetThuc, congViec.ngayKetThuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDeTai, soThuTu, tenCongViec, ngayBatDau, ngayKetThuc);
    }

    @ManyToOne
    @JoinColumn(name = "MaDeTai", referencedColumnName = "MaDeTai", nullable = false)
    public DeTai getDeTaiByMaDeTai() {
        return deTaiByMaDeTai;
    }

    public void setDeTaiByMaDeTai(DeTai deTaiByMaDeTai) {
        this.deTaiByMaDeTai = deTaiByMaDeTai;
    }

    @OneToMany(mappedBy = "congViec")
    public Collection<ThamGiaDeTai> getThamGiaDeTais() {
        return thamGiaDeTais;
    }

    public void setThamGiaDeTais(Collection<ThamGiaDeTai> thamGiaDeTais) {
        this.thamGiaDeTais = thamGiaDeTais;
    }
}
