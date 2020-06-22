package pojo;

import java.util.Objects;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private Double giaBan;
    private Integer soLuong;
    private String maDm;
    private String hinhAnh;
    private DanhMuc danhMucByMaDm;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaDm() {
        return maDm;
    }

    public void setMaDm(String maDm) {
        this.maDm = maDm;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sach sach = (Sach) o;
        return Objects.equals(maSach, sach.maSach) &&
                Objects.equals(tenSach, sach.tenSach) &&
                Objects.equals(tacGia, sach.tacGia) &&
                Objects.equals(giaBan, sach.giaBan) &&
                Objects.equals(soLuong, sach.soLuong) &&
                Objects.equals(maDm, sach.maDm) &&
                Objects.equals(hinhAnh, sach.hinhAnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSach, tenSach, tacGia, giaBan, soLuong, maDm, hinhAnh);
    }

    public DanhMuc getDanhMucByMaDm() {
        return danhMucByMaDm;
    }

    public void setDanhMucByMaDm(DanhMuc danhMucByMaDm) {
        this.danhMucByMaDm = danhMucByMaDm;
    }

    public String toString() {
        return "Sach{" +
                "maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", maDm='" + maDm + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }
}
