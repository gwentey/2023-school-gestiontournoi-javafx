package fr.lma.pingpong;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

/**
 * Classe des tournois simples (1 contre 1)
 *
 * @author MaximeVeschembes
 */
public class TournoiSimple extends Tournoi {

    /**
     * Constructeur de la classe TournoiSimple
     *
     * @param p_nom Nom du Tournoi
     * @param p_dateDebut Date de début du Tournoi
     * @param p_dateFin Date de fin du Tournoi
     * @param p_nbJoueurs Nombre de joueurs du Tournoi
     * @param p_matchs Matchs du Tournoi
     * @param p_stade Stade où se déroule le Tournoi
     * @param p_ville Ville dans laquelle se trouve le stade
     */
    public TournoiSimple(String p_nom, LocalDate p_dateDebut, LocalDate p_dateFin, int p_nbJoueurs, Map<String, Match> p_matchs, ArrayList<Joueur> p_joueurs, String p_stade, String p_ville) {
        super(p_nom, p_dateDebut, p_dateFin, p_nbJoueurs, p_matchs,p_joueurs, p_stade, p_ville);
    }

    // Nécessaire pour deserializer
    public TournoiSimple(){}
}
