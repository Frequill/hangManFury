import java.util.ArrayList;

public class mainFile {
    /*
    1. Huvudmeny - Låter användaren skapa eller välja en befintlig profil
    2. Textfil som lagrar användarnamn
    3. Spela "Hänga gubbe"
    */
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu()
    }

        public static void firstMenu (Menu menu) throws Exception {
        //    Menu menu = new Menu("main", 3);
            menu.getMenuOptions().add(0, "1) Select user");
            menu.getMenuOptions().add(1, "2) Play");
            menu.getMenuOptions().add(2, "3) Exit game...");
            menu.optionPrinter(menu.getMenuOptions());
            Menu.mainMenufunction();
        }
        static String secondMenu (Menu menu) throws Exception {
            System.out.println("Selected profile: " + user);
          //  Menu menu = new Menu("main", 3);
            menu.getMenuOptions().add(0, "1) Change user: ");
            menu.getMenuOptions().add(1, "2) Play");
            menu.getMenuOptions().add(2, "3) Exit game...");
            menu.optionPrinter(menu.getMenuOptions());
            Menu.mainMenufunction();
            return user;
        }

        public static String userNameMenu (Menu menu) throws Exception {
          //  Menu menu = new Menu("user", 2);
            menu.getMenuOptions().add(0, "1) Existing user");
            menu.getMenuOptions().add(1, "2) New user ");
            menu.optionPrinter(menu.getMenuOptions());
            user = Player.readUsername(user);
            return user;
        }
    }

