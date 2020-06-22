package resources;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ThamGiaDeTaiPK implements Serializable {
    private String maGiaoVien;
    private String maDeTai;
    private int soThuTu;

    @Column(name = "MaGiaoVien", nullable = false, length = 5)
    @Id
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Column(name = "MaDeTai", nullable = false, length = 3)
    @Id
    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    @Column(name = "SoThuTu", nullable = false)
    @Id
    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThamGiaDeTaiPK that = (ThamGiaDeTaiPK) o;

        if (soThuTu != that.soThuTu) return false;
        if (maGiaoVien != null ? !maGiaoVien.equals(that.maGiaoVien) : that.maGiaoVien != null) return false;
        if (maDeTai != null ? !maDeTai.equals(that.maDeTai) : that.maDeTai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maGiaoVien != null ? maGiaoVien.hashCode() : 0;
        result = 31 * result + (maDeTai != null ? maDeTai.hashCode() : 0);
        result = 31 * result + soThuTu;
        return result;
    }
}
