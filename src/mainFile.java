public class mainFile {

    /*
    1. Huvudmeny - Låter användaren skapa eller välja en befintlig profil
    2. Textfil som lagrar användarnamn
    3. Spela "Hänga gubbe"
    */

    public static void main(String[] args) {

        Menu menu = new Menu();
        //menu.getInt();


        //char result = menu.getAlpha();
        //System.out.println(result);


        String resultat =  menu.getString();
        System.out.println(resultat);

    }
}
