package fr.btsciel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionCoureur {
    ArrayList<Coureur> coureurs = new ArrayList();
    BufferedWriter bw;
    Path fichier = Paths.get("course.txt");
    BufferedReader br;

    public GestionCoureur() throws IOException {
        lectureFichier();
    }

    private void lectureFichier() throws IOException {

        br = Files.newBufferedReader(fichier);
        while (br.ready()) {
            String line = br.readLine();
            if (line != null) {
                String[] s = line.split(",");
                if (s.length == 5) {
                    Coureur coureur = new Coureur(s[1].trim().toUpperCase(), s[2].trim(), Genre.valueOf(s[0].trim()), Categorie.valueOf(s[3].trim()), LocalTime.ofSecondOfDay(Integer.parseInt(s[4].trim())));
                    coureurs.add(coureur);
                }
            }
        }
        br.close();
    }

    public void triDuPrenom() {
        coureurs.sort(Comparator.comparing(Coureur::getPrenom));
    }
    public void triDuPrenomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getPrenom).reversed());
    }

    public void triDuNom() {
        coureurs.sort(Comparator.comparing(Coureur::getNom));
    }
    public void triDuNomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getNom).reversed());
    }

    public void triClassement() {
        coureurs.sort(Comparator.comparing(Coureur::getCategorie));
    }
    public void triClassementDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getCategorie).reversed());
    }


    /**
     * @param nom nom du coureur ajouté
     * @param prenom prénom du coureur ajouté
     * @param genre genre du coureur ajouté
     * @param categorie Catégorie du coureur ajouté
     * @param lt Temps (en secondes) du coureur ajouté
     */
    public void ajoutCoureur(String nom, String prenom, int genre, int categorie, int lt) {
        Genre genre1 = Genre.values()[genre];
        Categorie categorie1 = Categorie.values()[categorie];
        LocalTime lt1 = LocalTime.ofSecondOfDay(lt);
        Coureur c1 = new Coureur(nom, prenom, genre1, categorie1, lt1);
        coureurs.add(c1);
    }

    public void sauvegardeCoureur() throws IOException {

        bw = new BufferedWriter(new FileWriter("course.txt"));
        //écrase le fichier pour le remplacer avec les nouvelles modifications

        for (int i = 0; i < coureurs.size(); i++) {
            bw.write(coureurs.get(i).getGenre().toString() + ", "
                    + coureurs.get(i).getNom() + ", "
                    + coureurs.get(i).getPrenom() + ", "
                    + coureurs.get(i).getCategorie().toString() + ", "
                    + coureurs.get(i).getTemps().toSecondOfDay());
            bw.newLine();
        }
        bw.close();
    }



    /**
     * @param indiceCoureur numéro attribué au coureur dans la liste
     * @return true = le coureur est supprimé, false = le numéro est invalide
     * @throws IOException
     */
    public boolean supprimerCoureur(int indiceCoureur) throws IOException {

        int CoureurSupprimer = indiceCoureur - 1;

        if (CoureurSupprimer < 0 || CoureurSupprimer >= coureurs.size()) {
            return false; //si le numéro est invalide
        }
        coureurs.remove(CoureurSupprimer);
        return true;
    }


    /**
     * @param num represente le numero du coureur a modifié
     * @param parametreModifier represente le choix de la modification a apporter au coureur
     * @param nouveauGenre represente le nouveau genre du coureur après modification
     * @param nouveauNom represente le nouveau nom du coureur après modification
     * @param nouveauPrenom represente le nouveau prénom du coureur après modification
     * @param nouvelleCategorie represente la nouvelle categorie du coureur après modification
     * @param nouveauTemps represente le nouveau temps du coureur après modification
     */
    public boolean modifierCoureur(int num,int parametreModifier,int nouveauGenre,String nouveauNom, String nouveauPrenom, int nouvelleCategorie, int nouveauTemps) {
        int index = num - 1;

        if (index < 0 || index >= coureurs.size()) {
            return false;
        }
        Coureur c = coureurs.get(index);
                switch (parametreModifier) {
                    case 1:
                        Genre genre = Genre.values()[nouveauGenre];
                        c.setGenre(genre);
                        break;
                    case 2:
                        c.setNom(nouveauNom);
                        break;
                    case 3:
                        c.setPrenom(nouveauPrenom);
                        break;
                    case 4:
                        c.setCategorie(Categorie.values()[nouvelleCategorie]);
                        break;
                    case 5:
                        c.setTemps(LocalTime.ofSecondOfDay(nouveauTemps));
                        break;

                }
                return true;
    }

}

