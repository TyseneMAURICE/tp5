import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionCoureur {
    ArrayList<Coureur> coureurs = new ArrayList();
    public void LectureFichier() throws IOException {
        Path fichier = Paths.get("course.txt");
        BufferedReader br = Files.newBufferedReader(fichier);
        while (br.ready()) {
            String line = br.readLine();
            System.out.println(line);
            if(line !=null){
                String[] s = line.split(",");
                if(s.length == 5 ){
                    int duree = Integer.parseInt(s[4].trim());
                    Categorie c = Categorie.valueOf(s[3].trim().toString());
                    Coureur coureur = new Coureur(s[1].toString().toUpperCase(),s[2].toString(),Genre.valueOf(s[0].trim().toString()),c, LocalTime.ofSecondOfDay(duree));
                }
            }

        }

    }
}
