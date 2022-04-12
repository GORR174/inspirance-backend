package net.catstack.inspirance.controller;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.catstack.inspirance.domain.MessageModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = TestController.TAG, description = "Тестовый контроллер списка сообщений")
@RequestMapping("/v1")
public interface TestController {
    String TAG = "Test Message Controller";

    @Operation(summary = "Возвращает список сообщений", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @GetMapping("/getMessages")
    List<MessageModel> getMessages();

    @Operation(summary = "Отправляет сообщение", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @PostMapping("/sendMessage")
    String sendMessage(@ApiParam(value = "Сообщение для отправки") @RequestBody MessageModel message);
}
