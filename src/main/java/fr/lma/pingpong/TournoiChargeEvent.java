package fr.lma.pingpong;

import javafx.event.Event;
import javafx.event.EventType;

public class TournoiChargeEvent extends Event {
    public static final EventType<TournoiChargeEvent> TOURNOI_CHARGE =
            new EventType<>(Event.ANY, "TOURNOI_CHARGE");

    public TournoiChargeEvent() {
        super(TOURNOI_CHARGE);
    }
}