package com.eventsmicroservice.events.producers;

import com.eventsmicroservice.events.dtos.EmailDto;
import com.eventsmicroservice.events.models.EventsModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventsProducer {
    final RabbitTemplate rabbitTemplate;

    public EventsProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(EventsModel eventsModel) {
        var emailDto = new EmailDto();
        emailDto.setEventId(eventsModel.getEventsId());
        emailDto.setEmailTo(eventsModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(eventsModel.getName() + ", seja bem vindo(a)! \n Evento criado com sucesso, agora o cadastro dos convidados já esta liberado. Aproveite todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
