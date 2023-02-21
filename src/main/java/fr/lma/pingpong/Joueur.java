package fr.lma.pingpong;
public class Joueur {

    // Attributs
    private String nom;
    private String prenom;

    // Constructeurs

    /**
     * Constructeur de la classe joueur
     *
     *  @param p_nom nom du joueur
     * @param p_prenom prénom du joueur
     */
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
    //Nécessaire à la deserialization
    public Joueur() {

    }
}
