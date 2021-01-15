package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fresher_groups")
@IdClass(FresherGroupsPK.class)
public class FresherGroups {
    private int fresherId;
    private int groupId;

    @Id
    @Column(name = "fresher_id")
    public int getFresherId() {
        return fresherId;
    }

    public void setFresherId(int fresherId) {
        this.fresherId = fresherId;
    }

    @Id
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FresherGroups that = (FresherGroups) o;
        return fresherId == that.fresherId && groupId == that.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fresherId, groupId);
    }
}
