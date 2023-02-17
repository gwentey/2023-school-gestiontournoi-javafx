package fr.lma.pingpong;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Tournoi implements Comparable<Tournoi> {

    // Attributs
    private String nom;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateDebut;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateFin;
    private int nbJoueurs;
    private ArrayList<Match> matchs;
    private ArrayList<Joueur> joueurs;
    private String stade;
    private String ville;

    // Constructeurs
    public Tournoi(String p_nom, LocalDate p_dateDebut, LocalDate p_dateFin, int p_nbJoueurs, ArrayList<Match> p_matchs, ArrayList<Joueur> p_joueurs, String p_stade, String p_ville) {
        this.nom = p_nom;
        this.dateDebut = p_dateDebut;
        this.dateFin = p_dateFin;
        this.nbJoueurs = p_nbJoueurs;
        this.matchs = p_matchs;
        this.joueurs = p_joueurs;
        this.stade = p_stade;
        this.ville = p_ville;
    }

    // Nécessaire pour déserialiser
    public Tournoi(){}

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

    public ArrayList<Joueur> getJoueurs(){return this.joueurs;}

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

    public void setJoueurs(ArrayList<Joueur> p_joueurs){this.joueurs = p_joueurs;}

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


    @Override
    public String toString() {
        return "Tournoi{" +
                "nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", nbJoueurs=" + nbJoueurs +
                ", matchs=" + matchs +
                ", joueurs=" + joueurs +
                ", stade='" + stade + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
