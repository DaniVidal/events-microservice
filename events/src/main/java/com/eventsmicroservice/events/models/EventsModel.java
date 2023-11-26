package com.eventsmicroservice.events.models;

import jakarta.persistence.*;
import java.util.UUID;
import java.io.Serializable;

@Entity
@Table(name = "TB_EVENTS")
public class EventsModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventsId;
    private String name;
    private String eventType;
    private String eventDate;
    private String eventHour;
    private String eventLocal;

    public UUID getEventsId() {
        return eventsId;
    }

    public void setEventsId(UUID eventsId) {
        this.eventsId = eventsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventHour() {
        return eventHour;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    public String getEventLocal() {
        return eventLocal;
    }

    public void setEventLocal(String eventLocal) {
        this.eventLocal = eventLocal;
    }
}
