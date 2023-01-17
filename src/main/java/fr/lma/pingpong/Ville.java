package fr.lma.pingpong;

public class Ville {

    // Attributs
    private String codePostal;
    private String nom;

    // Constructeurs
    public Ville(){
        this("","");
    }
    public Ville(String codePostal, String nom) {
        this.codePostal = codePostal;
        this.nom = nom;
    }

    // Accesseurs

    // Getter
    public String getCodePostal() {
        return  this.codePostal;
    }

    public String getNom() {
        return  this.nom;
    }

    // Setter
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
