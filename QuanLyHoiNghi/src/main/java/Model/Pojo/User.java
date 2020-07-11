package Model.Pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User implements DAO{
    private String username;
    private String password;
    private String name;
    private String email;
    private Byte isAdmin;
    private Collection<MeetingAccount> meetingAccountsByUsername;

    @Id
    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "isAdmin", nullable = true)
    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, name, email, isAdmin);
    }

    @OneToMany(mappedBy = "userByUserId", fetch = FetchType.EAGER)
    public Collection<MeetingAccount> getMeetingAccountsByUsername() {
        return meetingAccountsByUsername;
    }

    public void setMeetingAccountsByUsername(Collection<MeetingAccount> meetingAccountsByUsername) {
        this.meetingAccountsByUsername = meetingAccountsByUsername;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
