package codes.nttuan.IO;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class ObjectStream {
    static class Student implements Serializable{
        private String id, name;

        public Student() {
        }

        public Student(String id, String name) {
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
            return this.id + " - " + this.name;
        }
    }

    public static void main(String[] args) {
        final String fileName = "data";
        Student student1 = new Student("1", "Nguyen Tho Tuan");
        Student student2 = new Student("2", "Nguyen Tho Tuan 1");

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeObject(student1);
            out.writeObject(student2);
            out.writeObject(new Date());
            out.writeDouble(12345.2223);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //readObject
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));

            Student s = (Student) in.readObject();
            System.out.println(s);

            Student s1 = (Student) in.readObject();
            System.out.println(s1);

            Date date = (Date) in.readObject();
            System.out.println(date);

            Double d = in.readDouble();
            System.out.println(d);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
