package com.formacion.pr5WebSocket.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.formacion.pr5WebSocket.domains.InboundMessage;
import com.formacion.pr5WebSocket.domains.OutboundMessage;

@Controller
public class CommunicationsHub {

	@MessageMapping("/send")
    @SendTo("/topic/verbose")
    public OutboundMessage send(InboundMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new OutboundMessage(message.getContent()+" Response");
    }
}
