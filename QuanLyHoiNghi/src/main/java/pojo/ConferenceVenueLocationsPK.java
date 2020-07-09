package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ConferenceVenueLocationsPK implements Serializable {
    private String conferenceId;
    private Timestamp holdTime;
    private int conferenceTime;
    private String venueLocationId;

    @Column(name = "conferenceId", nullable = false, length = 20)
    @Id
    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Column(name = "holdTime", nullable = false)
    @Id
    public Timestamp getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(Timestamp holdTime) {
        this.holdTime = holdTime;
    }

    @Column(name = "conferenceTime", nullable = false)
    @Id
    public int getConferenceTime() {
        return conferenceTime;
    }

    public void setConferenceTime(int conferenceTime) {
        this.conferenceTime = conferenceTime;
    }

    @Column(name = "venueLocationId", nullable = false, length = 20)
    @Id
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
        ConferenceVenueLocationsPK that = (ConferenceVenueLocationsPK) o;
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
