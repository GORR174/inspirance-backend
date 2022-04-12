package net.catstack.inspirance.controller.impl;

import net.catstack.inspirance.controller.TestController;
import net.catstack.inspirance.domain.MessageModel;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestControllerImpl implements TestController {
    private final ArrayList<MessageModel> messages = new ArrayList<>();

    @PostConstruct
    private void init() {
        MessageModel messageModel = new MessageModel();
        messageModel.setText("test");
        messageModel.setDate("12.12.2022");
        messages.add(messageModel);
        messageModel = new MessageModel();
        messageModel.setText("another test");
        messageModel.setDate("01.10.2021");
        messages.add(messageModel);
    }

    @Override
    public List<MessageModel> getMessages() {
        return messages;
    }

    @Override
    public String sendMessage(MessageModel message) {
        messages.add(message);
        return "Ok";
    }
}
