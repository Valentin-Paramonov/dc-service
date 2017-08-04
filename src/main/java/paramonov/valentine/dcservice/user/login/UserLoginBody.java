package paramonov.valentine.dcservice.user.login;

class UserLoginBody {
    private String email;
    private String password;

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
