package fr.lma.pingpong;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe des tournois double (2 contre 2)
 *
 * @author MaximeVeschembes
 */
public class TournoiDouble extends Tournoi {

    /**
     * Constructeur de la classe TournoiDouble
     *
     * @param p_nom Nom du Tournoi
     * @param p_dateDebut Date de début du Tournoi
     * @param p_dateFin Date de fin du Tournoi
     * @param p_nbJoueurs Nombre de Joueur du Tournoi
     * @param p_matchs Matchs du Tournoi
     * @param p_stade Stade où se déroule le Tournoi
     * @param p_ville Ville dans laquelle se trouve le stade
     */
    public TournoiDouble(String p_nom, LocalDate p_dateDebut, LocalDate p_dateFin, int p_nbJoueurs, ArrayList<Match> p_matchs, ArrayList<Joueur> p_joueurs, String p_stade, String p_ville) {
        super(p_nom, p_dateDebut, p_dateFin, p_nbJoueurs, p_matchs, p_joueurs, p_stade, p_ville);
    }
}
