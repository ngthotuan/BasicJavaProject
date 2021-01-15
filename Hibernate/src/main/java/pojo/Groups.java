package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "groups")
public class Groups {
    private int groupId;
    private String name;

    @Id
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groups groups = (Groups) o;
        return groupId == groups.groupId && Objects.equals(name, groups.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, name);
    }
}
