package fr.lma.pingpong;

public class Match implements Comparable<Match> {

    // Attributs
    private String date;

    private Joueur joueur1;
    private Joueur joueur2;

    private int score1;
    private int score2;

    private int heure; // en seconde

    // Constructeur
    public Match(Joueur joueur1, Joueur joueur2, int score1, int score2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.score1 = score1;
        this.score2 = score2;
    }

    // Accesseurs

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
    public void setScore1(int score1) {
        this.score1 = score1;
    }


    public void setScore2(int scoreé) {
        this.score2 = scoreé;
    }

    // Getter
    public String getDate() {
        return date;
    }

    public int getHeure() {
        return heure;
    }

    // Setter
    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    // Autres méthodes

    /**
     * @desc Permet de convertir un format type "16:32:48" en son équivalent en minute
     * @param heure String
     * @return Integer
     */
    public int convertHeureStringVersInt(String heure) {
        String[] heuMinSec = heure.split(":");
        return Integer.parseInt(heuMinSec[0]) * 60 + Integer.parseInt(heuMinSec[1]);
    }

    /**
     * @desc Permet de convertir un nombre de seconde en un format type "16:32"
     * @param heure int
     * @return String
     */
    public String convertHeureIntVersString(int heure) {
        String message = String.valueOf(heure/60);
        heure %= 60;
        message += ":" + heure;
        return message;
    }

    // Comparable
    /**
     * @desc Permet la comparaison de deux instances de Match
     * @param o Match
     * @return int
     */
    @Override
    public int compareTo(Match o) {
        int distance;
        String[] thisDateJMA = this.getDate().split("/");
        String[] oDateJMA = o.getDate().split("/");
        distance = Integer.parseInt(thisDateJMA[2]) - Integer.parseInt(oDateJMA[2]); // Comparaison année
        if (distance == 0) {
            distance = Integer.parseInt(thisDateJMA[1]) - Integer.parseInt(oDateJMA[1]); // Comparaison mois
            if (distance == 0) {
                distance = Integer.parseInt(thisDateJMA[0]) - Integer.parseInt(oDateJMA[0]); // Comparaison jour
                if (distance == 0) {
                    distance = this.heure - o.heure;
                }
            }
        }
        return distance;
    }

}
