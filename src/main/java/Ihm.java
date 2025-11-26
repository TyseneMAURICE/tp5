import java.io.IOException;

public class Ihm {
    public static void main(String[] args) {
        try {
            GestionCoureur gestionCoureur = new GestionCoureur();
            gestionCoureur.LectureFichier();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
