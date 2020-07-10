package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "Conferences")
public class Conference {
    private int id;
    private Integer placeId;
    private String name;
    private String shortDescription;
    private String detailDescription;
    private String image;
    private Timestamp holdTime;
    private String conferenceTime;
    private Integer currentPerson;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "placeId", nullable = true)
    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
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
    @Column(name = "image", nullable = true, length = 200)
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
    @Column(name = "conferenceTime", nullable = true, length = -1)
    public String getConferenceTime() {
        return conferenceTime;
    }

    public void setConferenceTime(String conferenceTime) {
        this.conferenceTime = conferenceTime;
    }

    @Basic
    @Column(name = "currentPerson", nullable = true)
    public Integer getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Integer currentPerson) {
        this.currentPerson = currentPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conference that = (Conference) o;
        return id == that.id &&
                Objects.equals(placeId, that.placeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(detailDescription, that.detailDescription) &&
                Objects.equals(image, that.image) &&
                Objects.equals(holdTime, that.holdTime) &&
                Objects.equals(conferenceTime, that.conferenceTime) &&
                Objects.equals(currentPerson, that.currentPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeId, name, shortDescription, detailDescription, image, holdTime, conferenceTime, currentPerson);
    }
}
