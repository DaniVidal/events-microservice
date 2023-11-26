package com.eventsmicroservice.events.services;

import com.eventsmicroservice.events.models.EventsModel;
import com.eventsmicroservice.events.repositories.EventsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EventsService {
    final EventsRepository eventsRepository;

    // EventsService construct.
    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Transactional
    public EventsModel save(EventsModel eventsModel) {
        return eventsRepository.save(eventsModel);
    }
}
