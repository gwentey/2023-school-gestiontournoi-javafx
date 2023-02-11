package fr.lma.pingpong;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FichierJSON<O extends ConvertibleJSON> {

    // Attributs
    private static final String CHEMIN_DONNEES = "src\\main\\resources\\fr\\lma\\pingpong\\data\\";
    private String chemin;

    /**
     * Permet d'ouvrir un fichier avec le chemin passé en paramètre
     *
     * @param p_nomFichier Nom du fichier
     */
    public FichierJSON(String p_nomFichier) {
        this.chemin = CHEMIN_DONNEES + p_nomFichier + ".json";
    }

    // Accesseurs
    public String getChemin() {
        return chemin;
    }

    public void setChemin(String p_chemin) {
        this.chemin = p_chemin;
    }

    // Autres méthodes

    /**
     * Permet de créer un fichier
     *
     * @return Renvoi 1 si le fichier a été crée,
     * 2 si le fichier existait déjà,
     * 3 s'il y a eu une erreur
     */
    public int creer() {
        try {
            File f = new File(this.getChemin());
            return (f.createNewFile()) ? 1 : 2;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return 3;
        }
    }

    /**
     * Permet de remplir un fichier du contenu (Objet Enregistrable) passé en paramètre
     *
     * @param contenu le contenu doit-être au format JSON
     * @return Renvoi 1 sur le contenu en String a bien été écrit dans le fichier
     * ou 2 s'il y a eu une erreur lors de l'écriture
     */
    public int ecrire(O contenu) {
        try {
            FileWriter fw = new FileWriter(this.getChemin());
            fw.write(contenu.convertirToJSON());
            fw.close();
            return 1;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return 2;
        }
    }

    /**
     * Permet de supprimer le fichier ciblé par le chemin en argument
     *
     * @return Retourne si oui ou non le fichier à bien été supprimé
     */
    public boolean supprimer() {
        return new File(this.getChemin()).delete();
    }
}
