package com.eventsmicroservice.events.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EventsRecordDto(
        @NotBlank String name,
        @NotBlank String eventType,
        @NotBlank String eventDate,
        @NotBlank String eventHour,
        @NotBlank String eventLocal) {
}
