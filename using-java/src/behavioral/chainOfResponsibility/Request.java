package behavioral.chainOfResponsibility;

public class Request {
    public String username;
    public String password;
    public String ip;
    public String payload;
    public boolean isAdmin;

    public Request(String username, String password, String ip, String payload) {
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.payload = payload;
    }
}
