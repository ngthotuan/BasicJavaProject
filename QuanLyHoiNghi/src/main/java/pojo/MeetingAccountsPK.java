package pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MeetingAccountsPK implements Serializable {
    private String accountId;
    private String conferenceId;

    @Column(name = "accountId", nullable = false, length = 20)
    @Id
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Column(name = "conferenceId", nullable = false, length = 20)
    @Id
    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingAccountsPK that = (MeetingAccountsPK) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(conferenceId, that.conferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, conferenceId);
    }
}
