package com.eventsmicroservice.events.controllers;

import com.eventsmicroservice.events.dtos.EventsRecordDto;
import com.eventsmicroservice.events.models.EventsModel;
import com.eventsmicroservice.events.services.EventsService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    final EventsService eventsService;

    // EventsController construct.
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping("/events")
    public ResponseEntity<EventsModel> saveEvent(@RequestBody @Valid EventsRecordDto eventsRecordDto) {
        var eventsModel = new EventsModel();
        BeanUtils.copyProperties(eventsRecordDto, eventsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventsService.save(eventsModel));
    }
}
