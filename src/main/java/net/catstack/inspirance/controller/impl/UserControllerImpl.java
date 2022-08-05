package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.UserController;
import net.catstack.inspirance.domain.dto.request.profile.SetProfileDescriptionRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.profile.GetMyProfileResponseDTO;
import net.catstack.inspirance.domain.dto.response.profile.SetProfileDescriptionResponseDTO;
import net.catstack.inspirance.service.adapter.GetMyProfileAdapterService;
import net.catstack.inspirance.service.adapter.SetProfileDescriptionService;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final GetMyProfileAdapterService getMyProfileAdapterService;
    private final SetProfileDescriptionService setProfileDescriptionService;

    @Override
    public AdapterResponse<GetMyProfileResponseDTO> getMyProfile() {
        log.info("Get my profile: Request");
        var responseDto = getMyProfileAdapterService.getMyProfile();
        log.info("Get my profile: Response: {}", responseDto);
        return new AdapterResponse<>(responseDto);
    }

    @Override
    public AdapterResponse<SetProfileDescriptionResponseDTO> setProfileDescription(@Valid final SetProfileDescriptionRequestDTO request) {
        log.info("Set profile description: Request: {}", request);
        var response = setProfileDescriptionService.setProfileDescription(request);
        log.info("Set profile description: Response: {}", response);
        return new AdapterResponse<>(response);
    }
}
