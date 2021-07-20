package pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "identity_cards")
public class IdentityCards {
    private int identityCardId;
    private String number;
    private String name;
    private Date validDate;

    @Id
    @Column(name = "identity_card_id")
    public int getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(int identityCardId) {
        this.identityCardId = identityCardId;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
    @Column(name = "valid_date")
    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityCards that = (IdentityCards) o;
        return identityCardId == that.identityCardId && Objects.equals(number, that.number) && Objects.equals(name, that.name) && Objects.equals(validDate, that.validDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityCardId, number, name, validDate);
    }
}
