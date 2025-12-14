package fr.btsciel;

import fr.btsciel.clavier.In;

import java.io.IOException;
import java.time.LocalTime;

public class Ihm {
    public static void main(String[] args) {
        try {


            GestionCoureur gestionCoureur = new GestionCoureur();
            boolean continuer = true;
            boolean flag;

            while(continuer) { //boucle, tant qu'on ne quitte pas on continue

                flag = false; //affiche ou n'affiche pas la liste des coureurs


                System.out.println("""
                        faites votre choix :
                        0-Quitter
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

                switch (choix) {
                    case 0:
                        continuer = false;
                        break;
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
                    case 6:
                        gestionCoureur.TriClassement();
                        flag = true;
                        break;
                    case 7:
                        gestionCoureur.TriClassementDecroissant();
                        flag = true;
                        break;
                    case 8:
                        System.out.println("Entrez le nom du coureur que vous voulez ajouté :");
                        String nom = In.readString();

                        System.out.println("Entrez le prénom du coureur que vous voulez ajouté :");
                        String prenom = In.readString();

                        System.out.println("Entrez le genre de votre coureur :");
                        for (int i = 0; i < Genre.values().length; i++) {
                            System.out.println(i + ". " + Genre.values()[i]);
                        }
                        int genre = In.readInteger();

                        System.out.println("Entrez la categorie de votre coureur :");
                        for (int i = 0; i < Categorie.values().length; i++) {
                            System.out.println(i + ". " + Categorie.values()[i]);
                        }
                        int categorie = In.readInteger();

                        System.out.println("Entrez le temps en secondes de votre coureur :");
                        int lt = In.readInteger();
                        LocalTime temps = LocalTime.ofSecondOfDay(lt);
                        gestionCoureur.AjoutCoureur(nom, prenom, genre, categorie, lt);
                        gestionCoureur.SauvegardeCoureur();
                        break;

                    case 9:
                        System.out.println("Numéro du coureur à supprimer :");
                        int numero = In.readInteger();

                        boolean ok = gestionCoureur.supprimerCoureur(numero);

                        if (ok) {
                            gestionCoureur.SauvegardeGlobal();
                            System.out.println("Coureur supprimé");
                        } else {
                            System.out.println("Numéro invalide");
                        }

                        break;

                    case 10:
                        //Modifier un coureur
                        break;
                    case 11:
                        gestionCoureur.SauvegardeCoureur();
                        System.out.println("Liste des coureurs sauvegardé");
                        break;
                    default:
                        System.out.println("Choix invalide");

                }

                if (flag) {
                    for (int i = 0; i < gestionCoureur.coureurs.size(); i++) {
                        Coureur c = gestionCoureur.coureurs.get(i);
                        System.out.println((i + 1) + " - "
                                + c.getNom() + " "
                                + c.getPrenom() + " "
                                + c.getCategorie() + " "
                                + c.getTemps());
                    }
                }

                System.out.println("\t--------------------------\n");
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
