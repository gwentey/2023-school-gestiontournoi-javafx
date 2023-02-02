package fr.lma.pingpong;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Tournoi implements Comparable<Tournoi>, Enregistrable {

    // Attributs
    private String nom;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Match> matchs;
    private Stade stade;

    // Constructeurs
    public Tournoi(String p_nom, String p_dateDebut, String p_dateFin, ArrayList<Match> p_matchs, Stade p_stade) {
        this.nom = p_nom;
        this.dateDebut = p_dateDebut;
        this.dateFin = p_dateFin;
        this.matchs = p_matchs;
        this.stade = p_stade;
    }

    // Accesseurs

    // Getter

    public String getNom() {
        return this.nom;
    }

    public String getDateDebut() {
        return this.dateDebut;
    }

    public String getDateFin() {
        return this.dateFin;
    }

    public ArrayList<Match> getMatchs() {
        return this.matchs;
    }

    public Match getMatchByIndex(int i) {
        return this.matchs.get(i);
    }

    public Stade getStade() {
        return stade;
    }

    // Setter

    public void setNom(String p_nom) {
        this.nom = p_nom;
    }

    public void setDateDebut(String p_dateDebut) {
        this.dateDebut = p_dateDebut;
    }

    public void setDateFin(String p_dateFin) {
        this.dateFin = p_dateFin;
    }

    public void setMatchs(ArrayList<Match> p_matchs) {
        this.matchs = p_matchs;
    }

    public void ajouterMatch(Match m) {
        this.matchs.add(m);
    }

    public void setStade(Stade p_stade) {
        this.stade = p_stade;
    }

    // Autres méthodes

    // Comparable
    /**
     * @desc Permet la comparaison de deux instances de Tournoi
     * @param o Tournoi
     * @return int
     */
    @Override
    public int compareTo(Tournoi o) {
        int distance;
        distance = compareDate(this.getDateDebut(),o.getDateDebut());
        if (distance == 0) {
            distance = compareDate(this.getDateFin(),o.getDateFin());
        }
        return distance;
    }

    private int compareDate(String d1, String d2) {
        int distance;
        String[] Date1JMA = d1.split("/");
        String[] Date2JMA = d2.split("/");
        distance = Integer.parseInt(Date1JMA[2]) - Integer.parseInt(Date2JMA[2]); // Comparaison année
        if (distance == 0) {
            distance = Integer.parseInt(Date1JMA[1]) - Integer.parseInt(Date2JMA[1]); // Comparaison mois
            if (distance == 0) {
                distance = Integer.parseInt(Date1JMA[0]) - Integer.parseInt(Date2JMA[0]); // Comparaison jour
            }
        }
        return distance;
    }

    @Override
    public void enregistrer() {
        String path = "..../ressources/fr/lma/pingpong/joueurs.json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(this);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
