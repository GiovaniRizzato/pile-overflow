package br.com.giovanirizzato.treeelo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    private JmsTemplate jmsTemplate;

    Logger log = LoggerFactory.getLogger(ColumnController.class);

    @GetMapping("publish/{msg}")
    public String publish(@PathVariable("msg") final String message){
        jmsTemplate.convertAndSend(message);
        log.info("Sent message='{}'", message);

        return "Your message <b>" + message + "</b> published successfully";
    }

    @JmsListener(destination = "${spring.jms.template.default-destination}")
        public void receive(String message) {
        log.info("Received message='{}'", message);
    }
}
