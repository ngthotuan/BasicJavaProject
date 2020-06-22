package pojo;

import java.util.Collection;
import java.util.Objects;

public class GiaoVien {
    private String maGiaoVien;
    private String tenGiaoVien;
    private Collection<ThamGiaDeTai> thamGiaDeTaisByMaGiaoVien;

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaoVien giaoVien = (GiaoVien) o;
        return Objects.equals(maGiaoVien, giaoVien.maGiaoVien) &&
                Objects.equals(tenGiaoVien, giaoVien.tenGiaoVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGiaoVien, tenGiaoVien);
    }

    public Collection<ThamGiaDeTai> getThamGiaDeTaisByMaGiaoVien() {
        return thamGiaDeTaisByMaGiaoVien;
    }

    public void setThamGiaDeTaisByMaGiaoVien(Collection<ThamGiaDeTai> thamGiaDeTaisByMaGiaoVien) {
        this.thamGiaDeTaisByMaGiaoVien = thamGiaDeTaisByMaGiaoVien;
    }
}
