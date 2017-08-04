package paramonov.valentine.dcservice;

import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

import java.io.Serializable;

@Indices({
    @Index(value = "personalId", type = IndexType.Unique)
})
public class Customer implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String personalId;
    private String agent;

    public Customer() {
    }

    public Customer(String name, String surname, String email, String personalId, String agent) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personalId = personalId;
        this.agent = agent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
