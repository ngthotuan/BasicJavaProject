package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(MeetingAccountsPK.class)
public class MeetingAccounts {
    private String accountId;
    private String conferenceId;

    @Id
    @Column(name = "accountId", nullable = false, length = 20)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Id
    @Column(name = "conferenceId", nullable = false, length = 20)
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
        MeetingAccounts that = (MeetingAccounts) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(conferenceId, that.conferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, conferenceId);
    }
}
