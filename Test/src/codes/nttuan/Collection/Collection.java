package codes.nttuan.Collection;

import java.util.*;
import java.util.function.BiFunction;

public class Collection {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1712878", "Nguyen Tho Tuan"));
        list.add(new Student("1712868", "Chau Xuan Tuan"));
        list.add(new Student("1712882", "Nguyen Thanh Tung"));

        Collections.shuffle(list);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
        System.out.println("list = " + list);
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });
        list.sort((sv1, sv2) -> sv1.getName().compareTo(sv2.getName()));
        System.out.println("list = " + list);
    }

}
