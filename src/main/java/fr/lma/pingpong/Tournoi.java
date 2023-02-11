package fr.lma.pingpong;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import javafx.util.converter.LocalDateStringConverter;


import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Tournoi implements Comparable<Tournoi>, ConvertibleJSON<Tournoi> {

    // Attributs
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int nbJoueurs;
    private ArrayList<Match> matchs;
    private String stade;
    private String ville;

    // Constructeurs
    public Tournoi(String p_nom, LocalDate p_dateDebut, LocalDate p_dateFin, int p_nbJoueurs, ArrayList<Match> p_matchs, String p_stade, String p_ville) {
        this.nom = p_nom;
        this.dateDebut = p_dateDebut;
        this.dateFin = p_dateFin;
        this.nbJoueurs = p_nbJoueurs;
        this.matchs = p_matchs;
        this.stade = p_stade;
        this.ville = p_ville;
    }

    // Accesseurs

    // Getter

    public String getNom() {
        return this.nom;
    }

    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    public LocalDate getDateFin() {
        return this.dateFin;
    }

    public int getNbJoueurs() {
        return this.nbJoueurs;
    }

    public ArrayList<Match> getMatchs() {
        return this.matchs;
    }

    public Match getMatchByIndex(int i) {
        return this.matchs.get(i);
    }

    public String getStade() {
        return this.stade;
    }

    public String getVille() {
        return this.ville;
    }

    // Setter

    public void setNom(String p_nom) {
        this.nom = p_nom;
    }

    public void setDateDebut(LocalDate p_dateDebut) {
        this.dateDebut = p_dateDebut;
    }

    public void setDateFin(LocalDate p_dateFin) {
        this.dateFin = p_dateFin;
    }

    public void setNbJoueurs(int p_nbJoueurs) {
        this.nbJoueurs = p_nbJoueurs;
    }

    public void setMatchs(ArrayList<Match> p_matchs) {
        this.matchs = p_matchs;
    }

    public void ajouterMatch(Match m) {
        this.matchs.add(m);
    }

    public void setStade(String p_stade) {
        this.stade = p_stade;
    }

    public void setVille(String p_ville) {
        this.ville = p_ville;
    }

    // Autres méthodes

    // Comparable

    /**
     * Permet la comparaison de deux instances de Tournoi
     *
     * @param o à comparer
     * @return int
     */
    @Override
    public int compareTo(Tournoi o) {
        int distance;
        distance = this.getDateDebut().compareTo(o.getDateDebut());
        if (distance == 0) {
            distance = this.getDateFin().compareTo(o.getDateFin());
        }
        return distance;
    }

    /**
     * Permet d'enregistrer une instance de Tournoi dans un fichier JSON
     * Le nom du fichier sera le nom du tournois concaténé par un underscore
     * à la date de début du tournois
     */
    public void enregistrer() {
        FichierJSON<Tournoi> fichier = new FichierJSON<>(this.getNom()
                + "_" + this.getDateDebut().toString());
        switch (fichier.creer()) {
            case 1, 2 -> fichier.ecrire(this);
            default -> {
            }
        }
    }

    /**
     * Permet de convertir l'instance en String format JSON
     *
     * @return String format JSON de l'instance
     */
    @Override
    public String convertirToJSON() {
        try {
            /** Après de nombreux essais de différentes librairies toutes plus
             * obsolètes et bordéliques les unes que les autres, je me suis
             * résigné à faire ça moi-même.
             */
            StringBuilder json =
                    new StringBuilder("{\n" +
                            "   \"nom\": \"" + this.nom + "\",\n" +
                            "   \"dateDebut\": \"" + this.dateFin + "\",\n" +
                            "   \"dateFin\": \"" + this.dateFin + "\",\n" +
                            "   \"nbJoueurs\": " + this.nbJoueurs + ",\n" +
                            "   \"matchs\": [\n");
                    for (Match m : this.matchs) {
                        json.append(m.convertirToJSON());
                    }
            json.append("   ],\n   \"stade\": \"").append(this.stade).append("\",\n")
                    .append("   \"ville\": \"").append(this.ville).append("\"\n").append('}');
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", nbJoueurs=" + nbJoueurs +
                ", matchs=" + matchs +
                ", stade='" + stade + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
