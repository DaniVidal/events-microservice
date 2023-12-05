package com.eventsmicroservice.events.services;

import com.eventsmicroservice.events.models.EventsModel;
import com.eventsmicroservice.events.producers.EventsProducer;
import com.eventsmicroservice.events.repositories.EventsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class EventsServiceTest {

    @Mock
    private EventsRepository eventsRepository;

    @Mock
    private EventsProducer eventsProducer;

    @InjectMocks
    private EventsService eventsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        eventsService = new EventsService(eventsRepository, eventsProducer);
    }

    @Test
    public void testSave() {
        EventsModel eventsModel = new EventsModel();
        when(eventsRepository.save(eventsModel)).thenReturn(eventsModel);

        eventsService.save(eventsModel);

        verify(eventsRepository, times(1)).save(eventsModel);
        verify(eventsProducer, times(1)).publishMessageEmail(eventsModel);
    }
}