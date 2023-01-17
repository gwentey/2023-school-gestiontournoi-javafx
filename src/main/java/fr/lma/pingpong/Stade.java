package fr.lma.pingpong;


public class Stade {

    // Attributs
    private String adresse;
    private Ville ville;

    // Constructeurs
    public Stade() {
        this("",new Ville());
    }

    private Stade(String p_adresse, Ville p_ville) {
        this.adresse = p_adresse;
        this.ville = p_ville;
    }

    // Accesseurs

    // Getter

    public String getAdresse() {
        return this.adresse;
    }

    public Ville getVille() {
        return this.ville;
    }

    // Setter
    public void setAdresse(String p_adresse) {
        this.adresse = p_adresse;
    }

    public void setVille(Ville p_ville) {
        this.ville = p_ville;
    }
}
