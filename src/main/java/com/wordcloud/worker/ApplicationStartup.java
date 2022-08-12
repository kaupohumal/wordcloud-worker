package com.wordcloud.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        rabbitAdmin.initialize();
        rabbitAdmin.declareQueue(new Queue("core.queue", false));
    }
}
