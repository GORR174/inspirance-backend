package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.UserController;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.GetMyProfileResponseDTO;
import net.catstack.inspirance.service.adapter.GetMyProfileAdapterService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final GetMyProfileAdapterService getMyProfileAdapterService;

    @Override
    public AdapterResponse<GetMyProfileResponseDTO> getMyProfile() {
        log.info("Get my profile: Request");
        var responseDto = getMyProfileAdapterService.getMyProfile();
        log.info("Get my profile: Response: {}", responseDto);
        return new AdapterResponse<>(responseDto);
    }
}
