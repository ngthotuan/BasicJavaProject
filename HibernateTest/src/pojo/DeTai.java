package pojo;

import java.util.Collection;
import java.util.Objects;

public class DeTai {
    private String maDeTai;
    private String tenDeTai;
    private Collection<ThamGiaDeTai> thamGiaDeTaisByMaDeTai;

    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeTai deTai = (DeTai) o;
        return Objects.equals(maDeTai, deTai.maDeTai) &&
                Objects.equals(tenDeTai, deTai.tenDeTai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDeTai, tenDeTai);
    }

    public Collection<ThamGiaDeTai> getThamGiaDeTaisByMaDeTai() {
        return thamGiaDeTaisByMaDeTai;
    }

    public void setThamGiaDeTaisByMaDeTai(Collection<ThamGiaDeTai> thamGiaDeTaisByMaDeTai) {
        this.thamGiaDeTaisByMaDeTai = thamGiaDeTaisByMaDeTai;
    }
}
