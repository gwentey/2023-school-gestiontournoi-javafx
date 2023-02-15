package fr.lma.pingpong;

public class Match implements Comparable<Match> {

    // Attributs
    private String date;
    private int heure; // en seconde

    // Constructeur
    public Match(String p_date, int p_heure) {
        this.date = p_date;
        this.heure = p_heure;
    }

    // Accesseurs

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
