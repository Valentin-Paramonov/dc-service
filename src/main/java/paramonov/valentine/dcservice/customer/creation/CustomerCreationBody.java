package paramonov.valentine.dcservice.customer.creation;

class CustomerCreationBody {
    private String name;
    private String surname;
    private String email;
    private String personalId;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPersonalId() {
        return personalId;
    }

    void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}
