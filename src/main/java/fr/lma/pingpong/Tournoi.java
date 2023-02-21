package fr.lma.pingpong;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Match> matchs = new HashMap<>();
    @JsonProperty("joueurs")
    private ArrayList<Joueur> joueurs;
    private String stade;
    private String ville;

    /**
     * Constructeur de la classe tournoi
     *
     * @param p_nom nom du tournoi
     * @param p_dateDebut date de début du tournoi
     * @param p_dateFin date de fin du tournoi
     * @param p_nbJoueurs nombre de joueurs
     * @param p_matchs matchs
     * @param p_joueurs joueurs
     * @param p_stade stade du tournoi
     * @param p_ville ville du tournoi
     */
    // Constructeurs
    public Tournoi(String p_nom, LocalDate p_dateDebut, LocalDate p_dateFin, int p_nbJoueurs, Map<String, Match> p_matchs, ArrayList<Joueur> p_joueurs, String p_stade, String p_ville) {
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


    // Getters

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

    public Map<String, Match> getMatchs() {
        return this.matchs;
    }

    public ArrayList<Joueur> getJoueurs(){return this.joueurs;}

    public Match getMatchByIndex(int i) {
        return this.matchs.get(""+i);
    }

    public String getStade() {
        return this.stade;
    }

    public String getVille() {
        return this.ville;
    }

    // Setters
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

    public void setMatchs(Map<String, Match> p_matchs) {
        this.matchs = p_matchs;
    }

    public void setJoueurs(ArrayList<Joueur> p_joueurs){this.joueurs = p_joueurs;}

    public void ajouterMatch(String position, Match m) {
        this.matchs.put(position, m);
    }

    public void setStade(String p_stade) {
        this.stade = p_stade;
    }

    public void setVille(String p_ville) {
        this.ville = p_ville;
    }

    // Autres méthodes
    public void addJoueur(Joueur j){
        this.joueurs.add(j);
    }
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
