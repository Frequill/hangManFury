import java.util.ArrayList;

public class mainFile {

    /*
    1. Huvudmeny - Låter användaren skapa eller välja en befintlig profil
    2. Textfil som lagrar användarnamn
    3. Spela "Hänga gubbe"
    */

    public static void main(String[] args) {

        Menu menu = new Menu("edwinÄrEnLitenGullegrisMenViGillarHanÄndå",3);
        menu.getMenuOptions().add(0, "1) Play");
        menu.getMenuOptions().add(1, "2) Select user");
        menu.getMenuOptions().add(2, "3) Exit game...");
        menu.optionPrinter(menu.getMenuOptions());

        //menu.getInt();


        //char result = menu.getAlpha();
        //System.out.println(result);


        //String resultat =  menu.getString();
        // System.out.println(resultat);

    }
}
