package entity;

public class NormalUser extends User{
    private Plan plan;
    public NormalUser(String username, String password) {
        super(username, password, "normal");
        this.plan = new Plan(false);
    }
}
