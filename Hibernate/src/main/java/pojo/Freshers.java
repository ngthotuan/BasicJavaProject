package pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "freshers")
public class Freshers {
    private int fresherId;
    private String name;
    private String phone;
    private Integer identityCardId;
    private Integer courseId;

    @Id
    @Column(name = "fresher_id")
    public int getFresherId() {
        return fresherId;
    }

    public void setFresherId(int fresherId) {
        this.fresherId = fresherId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "identity_card_id")
    public Integer getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(Integer identityCardId) {
        this.identityCardId = identityCardId;
    }

    @Basic
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Freshers freshers = (Freshers) o;
        return fresherId == freshers.fresherId && Objects.equals(name, freshers.name) && Objects.equals(phone, freshers.phone) && Objects.equals(identityCardId, freshers.identityCardId) && Objects.equals(courseId, freshers.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fresherId, name, phone, identityCardId, courseId);
    }
}
