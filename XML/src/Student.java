public class Student {
    private String id, name;
    private int code, age;

    public Student() {
    }

    public Student(String id, String name, int code, int age) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.age = age;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", age=" + age +
                '}';
    }
}
