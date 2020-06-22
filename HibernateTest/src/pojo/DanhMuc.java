package pojo;

import java.util.Collection;
import java.util.Objects;

public class DanhMuc {
    private String maDanhMuc;
    private String tenDanhMuc;
    private Collection<Sach> sachesByMaDanhMuc;

    public DanhMuc() {
    }

    public DanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DanhMuc danhMuc = (DanhMuc) o;
        return Objects.equals(maDanhMuc, danhMuc.maDanhMuc) &&
                Objects.equals(tenDanhMuc, danhMuc.tenDanhMuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDanhMuc, tenDanhMuc);
    }

    public Collection<Sach> getSachesByMaDanhMuc() {
        return sachesByMaDanhMuc;
    }

    public void setSachesByMaDanhMuc(Collection<Sach> sachesByMaDanhMuc) {
        this.sachesByMaDanhMuc = sachesByMaDanhMuc;
    }

    @Override
    public String toString() {
        return "DanhMuc{" +
                "maDanhMuc='" + maDanhMuc + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", sachesByMaDanhMuc=" + sachesByMaDanhMuc +
                '}';
    }
}
