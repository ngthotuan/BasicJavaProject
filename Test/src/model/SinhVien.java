package model;

public class SinhVien {
    private String id, name;

    public SinhVien() {
        this.id = "1712878";
        this.name = "Nguyễn Thọ Tuấn";
    }

    public SinhVien(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
