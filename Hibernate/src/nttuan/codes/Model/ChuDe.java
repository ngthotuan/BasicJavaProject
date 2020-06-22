package nttuan.codes.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

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
        return Objects.equals(maChuDe, chuDe.maChuDe) &&
                Objects.equals(tenChuDe, chuDe.tenChuDe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maChuDe, tenChuDe);
    }

    @OneToMany(mappedBy = "chuDeByMaChuDe")
    public Collection<DeTai> getDeTaisByMaChuDe() {
        return deTaisByMaChuDe;
    }

    public void setDeTaisByMaChuDe(Collection<DeTai> deTaisByMaChuDe) {
        this.deTaisByMaChuDe = deTaisByMaChuDe;
    }
}
