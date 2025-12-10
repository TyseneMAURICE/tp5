package fr.btsciel;

import fr.btsciel.clavier.In;

import java.io.IOException;
import java.time.LocalTime;

public class Ihm {
    public static void main(String[] args) {
        try {


            GestionCoureur gestionCoureur = new GestionCoureur();

            boolean flag = false; //affiche ou affiche pas la liste des coureurs


            System.out.println("""
                    faites votre choix :
                    1- Lire la liste des coureurs dans le fichier
                    2- Afficher par ordre alphabétique de leur nom croissant
                    3- Afficher par ordre alphabétique de leur nom décroissant
                    4- Afficher par ordre alphabétique de leur prénom croissant
                    5- Afficher par ordre alphabétique de leur prénom décroissant
                    6- Afficher par ordre de classement croissant
                    7- Afficher par ordre de classement décroissant
                    8- Ajouter un coureur
                    9- Supprimer un coureur
                    10- Modifier un coureur
                    11- Sauvegarder la liste des coureurs""");

            int choix = In.readInteger();

            switch(choix){
                case 1:
                    flag = true;
                    break;
                case 2:
                    gestionCoureur.TriDuNom();
                    flag = true;
                    break;
                case 3:
                    gestionCoureur.TriDuNomDecroissant();
                    flag = true;
                    break;
                case 4:
                    gestionCoureur.TriDuPrenom();
                    flag = true;
                    break;
                case 5:
                    gestionCoureur.TriDuPrenomDecroissant();
                    flag = true;
                    break;
                case 6 :
                    gestionCoureur.TriClassement();
                    flag = true;
                    break;
                case 7 :
                    gestionCoureur.TriClassementDecroissant();
                    flag = true;
                    break;
                case 8 :
                    System.out.println("Entrez le nom du coureur que vous voulez ajouté :");
                    String Nom = In.readString();

                    System.out.println("Entrez le prénom du coureur que vous voulez ajouté :");
                    String Prenom = In.readString();

                    System.out.println("Entrez le genre de votre coureur :");
                    gestionCoureur.ajoutCoureurGenre();

                    System.out.println("Entrez la categorie de votre coureur :");
                    gestionCoureur.ajoutCoureurCategorie();

                    System.out.println("Entrez le temps en secondes de votre coureur :");
                    int saisieTemps = In.readInteger();
                    LocalTime c = LocalTime.ofSecondOfDay(saisieTemps);

                    gestionCoureur.SauvegardeCoureur();

                    break;
                case 9:
                    //Supprimer un coureur
                    break;
                case 10 :
                    //Modifier un coureur
                    break;
                case 11:
                    //Sauvegarder la liste des coureurs
                    break;

            }

            if (flag){
               gestionCoureur.coureurs.forEach(c ->{
                           System.out.println(c.getGenre() + " " + c.getNom() + " " +  c.getPrenom() + " " + c.getCategorie() + " " + c.getTemps());
                       }  );
                System.out.println(gestionCoureur.coureurs);
                }


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
