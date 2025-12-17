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
                        gestionCoureur.triDuNom();
                        flag = true;
                        break;
                    case 3:
                        gestionCoureur.triDuNomDecroissant();
                        flag = true;
                        break;
                    case 4:
                        gestionCoureur.triDuPrenom();
                        flag = true;
                        break;
                    case 5:
                        gestionCoureur.triDuPrenomDecroissant();
                        flag = true;
                        break;
                    case 6:
                        gestionCoureur.triClassement();
                        flag = true;
                        break;
                    case 7:
                        gestionCoureur.triClassementDecroissant();
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
                        gestionCoureur.ajoutCoureur(nom, prenom, genre, categorie, lt);
                        gestionCoureur.sauvegardeCoureur();
                        System.out.println("Coureur ajouté !");
                        break;

                    case 9:
                        //affichage de la liste
                        for (int i = 0; i < gestionCoureur.coureurs.size(); i++) {
                            Coureur c = gestionCoureur.coureurs.get(i);
                            System.out.println((i + 1) + " - "
                                    + c.getNom() + " "
                                    + c.getPrenom() + " "
                                    + c.getCategorie() + " "
                                    + c.getTemps());
                        }
                        System.out.println("Numéro du coureur à supprimer :");
                        int numero = In.readInteger();
                        boolean flag1 = gestionCoureur.supprimerCoureur(numero); //verifie si le numero est dans la liste
                        if (flag1) {
                            gestionCoureur.sauvegardeCoureur();
                            System.out.println("Coureur supprimé !");
                        } else {
                            System.out.println("Numéro invalide");
                        }
                        break;

                    case 10 :
                        //affichage de la liste
                        for (int i = 0; i < gestionCoureur.coureurs.size(); i++) {
                            Coureur c = gestionCoureur.coureurs.get(i);
                            System.out.println((i + 1) + " - "
                                    + c.getNom() + " "
                                    + c.getPrenom() + " "
                                    + c.getCategorie() + " "
                                    + c.getTemps());
                        }
                        System.out.println("Entrez le numero du coureur que vous voulez modifié :");
                        int num = In.readInteger(); //numero du coureur a modifié
                        int parametreModifier = 0;
                        int nouveauGenre = 0;
                        int nouvelleCategorie = 0;
                        String nouveauNom = "";
                        String nouveauPrenom = "";
                        int nouveauTemps = 0;
                        int index = num -1;
                        if (index >= 0 && index < gestionCoureur.coureurs.size()) {
                            Coureur c = gestionCoureur.coureurs.get(index);
                            System.out.println("Le coureur à modifier est : "
                                    + c.getGenre() + " "
                                    + c.getNom() + " "
                                    + c.getPrenom() + " "
                                    + c.getCategorie() + " "
                                    + c.getTemps());
                        } else {
                            System.out.println("Numéro invalide");
                        }
                        System.out.println("""
                                        Que voulez vous changé ? :
                                        1- Genre
                                        2- Nom
                                        3- Prenom
                                        4- Categorie
                                        5- Temps""");

                        parametreModifier = In.readInteger();

                                switch(parametreModifier){
                                    case 1:
                                        for (int j = 0; j < Genre.values().length; j++) {
                                            System.out.println(j + "." + Genre.values()[j].name());
                                        }
                                        nouveauGenre = In.readInteger();
                                        break;

                                    case 2:
                                        System.out.println("Tapez le nouveau nom du coureur :");
                                        nouveauNom = In.readString();
                                        break;

                                    case 3:
                                        System.out.println("Tapez le nouveau prenom du coureur :");
                                        nouveauPrenom = In.readString();
                                        break;

                                    case 4 :
                                        System.out.println("Entrez la nouvelle Categorie du coureur :");
                                        for (int j = 0; j < Categorie.values().length; j++) {
                                            System.out.println(j + ". " + Categorie.values()[j].name());
                                        }
                                        nouvelleCategorie = In.readInteger();
                                        break;

                                    case 5 :
                                        System.out.println("Entrez le nouveau temps du coureur (en seconde !!!) :");
                                        nouveauTemps = In.readInteger();
                                        break;
                                }
                        boolean flag2 = gestionCoureur.modifierCoureur(num, parametreModifier, nouveauGenre, nouveauNom, nouveauPrenom, nouvelleCategorie, nouveauTemps);
                        if (flag2) {
                            gestionCoureur.sauvegardeCoureur();
                            System.out.println("Coureur modifié !");
                        } else {
                            System.out.println("Numéro invalide");
                        }
                    break;

                    case 11:
                        gestionCoureur.sauvegardeCoureur();
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

                System.out.println("\t------------------------------------------------------------\n");
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
