package nttuan.codes.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CongViecPK implements Serializable {
    private String maDeTai;
    private int soThuTu;

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
        CongViecPK that = (CongViecPK) o;
        return soThuTu == that.soThuTu &&
                Objects.equals(maDeTai, that.maDeTai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDeTai, soThuTu);
    }
}
