package cl.duoc.fullstack_back_users.models;

public class LoginResponse {
    private String token;
    private UserModel user;

    public LoginResponse() {}

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
