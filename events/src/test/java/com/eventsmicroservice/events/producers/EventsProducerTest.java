package com.eventsmicroservice.events.producers;

import com.eventsmicroservice.events.dtos.EmailDto;
import com.eventsmicroservice.events.models.EventsModel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class EventsProducerTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private EventsProducer eventsProducer;

    public EventsProducerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPublishMessageEmail() {
        EventsModel eventsModel = new EventsModel();
        eventsModel.setEventsId(UUID.randomUUID());
        eventsModel.setEmail("testDani@test.com");
        eventsModel.setName("Daniele Vidal");

        eventsProducer.publishMessageEmail(eventsModel);

        EmailDto expectedEmailDto = new EmailDto();
        expectedEmailDto.setEventId(UUID.randomUUID()); // Generating a random UUID for testing
        expectedEmailDto.setEmailTo(eventsModel.getEmail());
        expectedEmailDto.setSubject("Cadastro realizado com sucesso!");
        expectedEmailDto.setText(eventsModel.getName() + ", seja bem vindo(a)! \n Evento criado com sucesso, agora o cadastro dos convidados já esta liberado. Aproveite todos os recursos da nossa plataforma!");

        verify(rabbitTemplate, times(1)).convertAndSend("", anyString(), eq(expectedEmailDto));
    }
}

