package com.eventsmicroservice.events.services;

import com.eventsmicroservice.events.models.EventsModel;
import com.eventsmicroservice.events.producers.EventsProducer;
import com.eventsmicroservice.events.repositories.EventsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EventsService {
    final EventsRepository eventsRepository;
    final EventsProducer eventsProducer;

    // EventsService construct.
    public EventsService(EventsRepository eventsRepository, EventsProducer eventsProducer) {
        this.eventsRepository = eventsRepository;
        this.eventsProducer = eventsProducer;
    }

    @Transactional
    public EventsModel save(EventsModel eventsModel) {
        eventsModel = eventsRepository.save(eventsModel);
        eventsProducer.publishMessageEmail(eventsModel);
        return eventsModel;
    }
}
