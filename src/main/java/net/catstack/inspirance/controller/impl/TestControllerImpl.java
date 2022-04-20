package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import net.catstack.inspirance.controller.TestController;
import net.catstack.inspirance.domain.dto.request.SendMessageRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.model.MessageModel;
import net.catstack.inspirance.service.MessageService;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestControllerImpl implements TestController {
    private final MessageService messageService;

    @Override
    public AdapterResponse<List<MessageModel>> getMessages() {
        return new AdapterResponse<>(messageService.getMessages());
    }

    @Override
    public AdapterResponse<String> sendMessage(@Valid final SendMessageRequestDTO request) {

        messageService.sendMessage(request);
        return new AdapterResponse<>("Ok");
    }
}
