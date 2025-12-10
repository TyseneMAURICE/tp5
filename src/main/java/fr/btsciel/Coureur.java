package fr.btsciel;

import java.time.LocalTime;

public class Coureur extends Personne {
    private Categorie categorie;
    LocalTime temps;

    public Coureur(String nom, String prenom, Genre genre, Categorie categorie, LocalTime temps) {
        super(nom, prenom, genre);
        this.categorie = categorie;
        this.temps = temps;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public LocalTime getTemps() {
        return temps;
    }

    public void setTemps(LocalTime temps) {
        this.temps = temps;
    }
}
