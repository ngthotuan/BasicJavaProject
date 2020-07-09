package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Conferences {
    private String id;
    private String name;
    private String shortDescription;
    private String detailDescription;
    private String image;
    private Timestamp holdTime;
    private Integer conferenceTime;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "shortDescription", nullable = true, length = 50)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "detailDescription", nullable = true, length = 200)
    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 20)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "holdTime", nullable = true)
    public Timestamp getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(Timestamp holdTime) {
        this.holdTime = holdTime;
    }

    @Basic
    @Column(name = "conferenceTime", nullable = true)
    public Integer getConferenceTime() {
        return conferenceTime;
    }

    public void setConferenceTime(Integer conferenceTime) {
        this.conferenceTime = conferenceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conferences that = (Conferences) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(detailDescription, that.detailDescription) &&
                Objects.equals(image, that.image) &&
                Objects.equals(holdTime, that.holdTime) &&
                Objects.equals(conferenceTime, that.conferenceTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescription, detailDescription, image, holdTime, conferenceTime);
    }
}
