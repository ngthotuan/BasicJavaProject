package resources;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ChuDe {
    private String maChuDe;
    private String tenChuDe;
    private Collection<DeTai> deTaisByMaChuDe;

    @Id
    @Column(name = "MaChuDe", nullable = false, length = 4)
    public String getMaChuDe() {
        return maChuDe;
    }

    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    @Basic
    @Column(name = "TenChuDe", nullable = true, length = 50)
    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChuDe chuDe = (ChuDe) o;

        if (maChuDe != null ? !maChuDe.equals(chuDe.maChuDe) : chuDe.maChuDe != null) return false;
        if (tenChuDe != null ? !tenChuDe.equals(chuDe.tenChuDe) : chuDe.tenChuDe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maChuDe != null ? maChuDe.hashCode() : 0;
        result = 31 * result + (tenChuDe != null ? tenChuDe.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "chuDeByMaChuDe")
    public Collection<DeTai> getDeTaisByMaChuDe() {
        return deTaisByMaChuDe;
    }

    public void setDeTaisByMaChuDe(Collection<DeTai> deTaisByMaChuDe) {
        this.deTaisByMaChuDe = deTaisByMaChuDe;
    }
}
