package com.wordcloud.worker.service;

import com.wordcloud.worker.WorkerLogic;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class RabbitMQConsumer {

    @Autowired
    WorkerLogic workerLogic;

    @RabbitListener(queues = "core.queue")
    public void handleReceivedMessage(byte[] bytes) {

        String text = new String(bytes);
        workerLogic.processText(text);
        workerLogic.insertToDB();
    }
}
