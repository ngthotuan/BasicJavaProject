package pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class VenueLocations {
    private String id;
    private String name;
    private String address;
    private Integer limitPerson;

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
    @Column(name = "address", nullable = true, length = 20)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "limitPerson", nullable = true)
    public Integer getLimitPerson() {
        return limitPerson;
    }

    public void setLimitPerson(Integer limitPerson) {
        this.limitPerson = limitPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenueLocations that = (VenueLocations) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(limitPerson, that.limitPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, limitPerson);
    }
}
