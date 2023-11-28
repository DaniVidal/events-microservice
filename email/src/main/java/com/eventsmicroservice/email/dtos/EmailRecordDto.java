package com.eventsmicroservice.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID eventId,
                             String emailTo,
                             String subject,
                             String text) {
}
