package com.eventsmicroservice.events.repositories;

import com.eventsmicroservice.events.models.EventsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventsRepository extends JpaRepository<EventsModel, UUID> {
}
