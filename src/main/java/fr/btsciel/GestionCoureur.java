package fr.btsciel;

import fr.btsciel.clavier.In;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    Path fichier1 = Paths.get("course1.txt");
    BufferedReader br;

    public GestionCoureur() throws IOException {
        lectureFichier();
    }

    private void lectureFichier()throws IOException {

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

    public void TriDuPrenom() {
        coureurs.sort(Comparator.comparing(Coureur::getPrenom));
    }

    public void TriDuNom() {
        coureurs.sort(Comparator.comparing(Coureur::getNom));
    }

    public void TriDuNomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getNom).reversed());
    }

    public void TriDuPrenomDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getPrenom).reversed());
    }


    public void TriClassement() {
        coureurs.sort(Comparator.comparing(Coureur::getCategorie));
    }


    public void TriClassementDecroissant() {
        coureurs.sort(Comparator.comparing(Coureur::getCategorie).reversed());
    }

    public void AjoutCoureur(String nom ,String prenom,int genre,int categorie,int lt) {
        Genre genre1 = Genre.values()[genre];
        Categorie categorie1 = Categorie.values()[categorie];
        LocalTime lt1 = LocalTime.ofSecondOfDay(lt);
        Coureur c1 = new Coureur(nom,prenom,genre1,categorie1,lt1);
        coureurs.add(c1);
    }


    public void SauvegardeCoureur() throws IOException {

        bw = Files.newBufferedWriter(fichier);

        for (int i = 0; i < coureurs.size(); i++) {
            bw.write(coureurs.get(i).getGenre().toString() + ", "
                    + coureurs.get(i).getNom() + ", "
                    + coureurs.get(i).getPrenom() + ", "
                    + coureurs.get(i).getCategorie().toString() + ", "
                    + coureurs.get(i).getTemps().toSecondOfDay());
            bw.newLine();


            bw.close();

        }
    }


    //public void supprimerCoureur() throws IOException {}



}

