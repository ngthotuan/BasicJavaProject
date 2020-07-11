package Model.Pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Place {
    private int id;
    private String name;
    private String address;
    private Integer limitPerson;
    private Collection<Conference> conferencesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "address", nullable = true, length = 50)
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
        Place place = (Place) o;
        return id == place.id &&
                Objects.equals(name, place.name) &&
                Objects.equals(address, place.address) &&
                Objects.equals(limitPerson, place.limitPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, limitPerson);
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<Conference> getConferencesById() {
        return conferencesById;
    }

    public void setConferencesById(Collection<Conference> conferencesById) {
        this.conferencesById = conferencesById;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", limitPerson=" + limitPerson +
                '}';
    }
}
