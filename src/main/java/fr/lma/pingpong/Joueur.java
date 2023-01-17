package fr.lma.pingpong;

public class Joueur {

    // Attributs
    private String nom;
    private String prenom;

    // Constructeurs

    public Joueur(String p_nom, String p_prenom) {
        this.nom = p_nom;
        this.prenom = p_prenom;
    }

    // Accesseurs

    // Getter
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }


    // Setter
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
