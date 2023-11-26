package com.eventsmicroservice.events.controllers;

import com.eventsmicroservice.events.dtos.EventsRecordDto;
import com.eventsmicroservice.events.models.EventsModel;
import com.eventsmicroservice.events.services.EventsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Validator;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EventsControllerTest {
    @Mock
    private EventsService eventsService;

    @InjectMocks
    private EventsController eventsController;

    private Validator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSaveEvent() {
        EventsRecordDto recordDto = new EventsRecordDto(
                "Event Name",
                "Event Type",
                "Event Date",
                "Event Hour",
                "Event Local");

        EventsModel eventsModel = new EventsModel();
        eventsModel.setName("Event Name");
        eventsModel.setEventType("Event Type");
        eventsModel.setEventDate("Event Date");
        eventsModel.setEventHour("Event Hour");
        eventsModel.setEventLocal("Event Local");

        when(eventsService.save(any(EventsModel.class))).thenReturn(eventsModel);

        ResponseEntity<EventsModel> responseEntity = eventsController.saveEvent(recordDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Event Name", responseEntity.getBody().getName());
    }
}
