package net.catstack.inspirance.component.mapper;

import net.catstack.inspirance.domain.dto.request.SendMessageRequestDTO;
import net.catstack.inspirance.domain.model.MessageModel;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public MessageModel mapDtoToModel(final SendMessageRequestDTO dto) {
        var messageModel = new MessageModel();
        messageModel.setText(dto.getText());
        messageModel.setDate(dto.getDate());
        return messageModel;
    }
}
