package Model.Pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(MeetingAccountPK.class)
public class MeetingAccount {
    private String userId;
    private int conferenceId;
    private User userByUserId;
    private Conference conferenceByConferenceId;

    @Id
    @Column(name = "userId", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "conferenceId", nullable = false)
    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingAccount that = (MeetingAccount) o;
        return conferenceId == that.conferenceId &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, conferenceId);
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "username", nullable = false, insertable=false, updatable=false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "conferenceId", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Conference getConferenceByConferenceId() {
        return conferenceByConferenceId;
    }

    public void setConferenceByConferenceId(Conference conferenceByConferenceId) {
        this.conferenceByConferenceId = conferenceByConferenceId;
    }

    @Override
    public String toString() {
        return "MeetingAccount{" +
                "userId='" + userId + '\'' +
                ", conferenceId=" + conferenceId +
                '}';
    }
}
