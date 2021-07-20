package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FresherGroupsPK implements Serializable {
    private int fresherId;
    private int groupId;

    @Column(name = "fresher_id")
    @Id
    public int getFresherId() {
        return fresherId;
    }

    public void setFresherId(int fresherId) {
        this.fresherId = fresherId;
    }

    @Column(name = "group_id")
    @Id
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
        FresherGroupsPK that = (FresherGroupsPK) o;
        return fresherId == that.fresherId && groupId == that.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fresherId, groupId);
    }
}
