package fr.lma.pingpong;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe des tournois simples (1 contre 1)
 * @author MaximeVeschembes
 */
public class TournoiSimple extends Tournoi{

    /**
     * Constructeur de la classe TournoiSimple
     * @param p_nom
     * @param p_dateDebut
     * @param p_dateFin
     * @param p_nbJoueurs
     * @param p_matchs
     * @param p_stade
     * @param p_ville
     */
    public TournoiSimple(String p_nom, LocalDate p_dateDebut, LocalDate p_dateFin, int p_nbJoueurs, ArrayList<Match> p_matchs, String p_stade, String p_ville) {
        super(p_nom, p_dateDebut, p_dateFin, p_nbJoueurs, p_matchs, p_stade, p_ville);
    }
}
