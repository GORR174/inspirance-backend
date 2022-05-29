package net.catstack.inspirance.service.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.request.SetProfileDescriptionRequestDTO;
import net.catstack.inspirance.domain.dto.response.SetProfileDescriptionResponseDTO;
import net.catstack.inspirance.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SetProfileDescriptionService {
    private final UserService userService;

    public SetProfileDescriptionResponseDTO setProfileDescription(final SetProfileDescriptionRequestDTO requestDTO) {
        var userModel = userService.getCurrentUser();
        userModel.setDescription(requestDTO.getDescription());
        userService.saveUserModel(userModel);

        var response = new SetProfileDescriptionResponseDTO();
        response.setMessage("Success");

        return response;
    }
}
