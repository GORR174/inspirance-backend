package net.catstack.inspirance.service.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.response.AwardResponseDTO;
import net.catstack.inspirance.domain.dto.response.GetMyProfileResponseDTO;
import net.catstack.inspirance.domain.model.AwardModel;
import net.catstack.inspirance.domain.model.UserModel;
import net.catstack.inspirance.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetMyProfileAdapterService {
    private final UserService userService;

    public GetMyProfileResponseDTO getMyProfile() {
        log.info("Get my profile: starting...");
        var userModel = userService.getCurrentUser();

        var response = mapModelToDto(userModel);

        log.info("Get my profile: response: {}", response);
        return response;
    }

    private GetMyProfileResponseDTO mapModelToDto(final UserModel userModel) {
        log.info("Mapping userModel to dto");
        var dto = new GetMyProfileResponseDTO();

        dto.setAwards(mapAwardModelsToAwardDTOs(userModel.getAwards()));
        dto.setDescription(userModel.getDescription());
        dto.setEmail(userModel.getEmail());
        dto.setUsername(userModel.getUsername());
        dto.setFirstName(userModel.getFirstName());
        dto.setImageUrl(userModel.getImageUrl());
        dto.setLikes(666); // TODO: set likes
        dto.setFollowersCount(userModel.getFollowers().size());
        dto.setFollowingCount(userModel.getFollowing().size());

        return dto;
    }

    private List<AwardResponseDTO> mapAwardModelsToAwardDTOs(final List<AwardModel> awardModels) {
        log.info("Mapping awards to dto");
        return awardModels.stream().map(this::mapAwardModelToAwardDTO).collect(Collectors.toList());
    }

    private AwardResponseDTO mapAwardModelToAwardDTO(final AwardModel awardModel) {
        var dto = new AwardResponseDTO();

        dto.setName(awardModel.getName());
        dto.setImageUrl(awardModel.getImageUrl());

        return dto;
    }
}
