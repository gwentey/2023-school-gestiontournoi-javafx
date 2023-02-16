package fr.lma.pingpong;

import javafx.event.Event;
import javafx.event.EventType;

public class TournoiSupprimeEvent extends Event {
    public static final EventType<TournoiSupprimeEvent> TOURNOI_SUPPRIME =
            new EventType<>(Event.ANY, "TOURNOI_SUPPRIME");

    public TournoiSupprimeEvent() {
        super(TOURNOI_SUPPRIME);
    }
}