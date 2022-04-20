package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import net.catstack.inspirance.component.mapper.MessageMapper;
import net.catstack.inspirance.domain.dto.request.SendMessageRequestDTO;
import net.catstack.inspirance.domain.model.MessageModel;
import net.catstack.inspirance.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public void sendMessage(final SendMessageRequestDTO dto) {
        messageRepository.save(messageMapper.mapDtoToModel(dto));
    }

    public MessageModel getMessageById(final long id) {
        return messageRepository.getById(id);
    }

    public List<MessageModel> getMessages() {
        return messageRepository.findAll();
    }
}
