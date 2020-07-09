package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(ConferenceVenueLocationsPK.class)
public class ConferenceVenueLocations {
    private String conferenceId;
    private Timestamp holdTime;
    private int conferenceTime;
    private String venueLocationId;

    @Id
    @Column(name = "conferenceId", nullable = false, length = 20)
    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Id
    @Column(name = "holdTime", nullable = false)
    public Timestamp getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(Timestamp holdTime) {
        this.holdTime = holdTime;
    }

    @Id
    @Column(name = "conferenceTime", nullable = false)
    public int getConferenceTime() {
        return conferenceTime;
    }

    public void setConferenceTime(int conferenceTime) {
        this.conferenceTime = conferenceTime;
    }

    @Id
    @Column(name = "venueLocationId", nullable = false, length = 20)
    public String getVenueLocationId() {
        return venueLocationId;
    }

    public void setVenueLocationId(String venueLocationId) {
        this.venueLocationId = venueLocationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceVenueLocations that = (ConferenceVenueLocations) o;
        return conferenceTime == that.conferenceTime &&
                Objects.equals(conferenceId, that.conferenceId) &&
                Objects.equals(holdTime, that.holdTime) &&
                Objects.equals(venueLocationId, that.venueLocationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, holdTime, conferenceTime, venueLocationId);
    }
}
