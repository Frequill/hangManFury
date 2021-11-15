/**
  This class exists to solve an annoying object-related problem caused by programming inexperience...
 */
public class SinglePlayerGUIHelper {
    public static SinglePlayerGUIHelper userName = new SinglePlayerGUIHelper();

    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}