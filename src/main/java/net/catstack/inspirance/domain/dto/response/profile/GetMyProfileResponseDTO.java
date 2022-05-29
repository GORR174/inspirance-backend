package net.catstack.inspirance.domain.dto.response.profile;

import lombok.Data;
import net.catstack.inspirance.domain.dto.response.awards.AwardResponseDTO;

import java.util.List;

@Data
public class GetMyProfileResponseDTO {
    private String username;
    private String email;
    private String firstName;
    private String imageUrl;
    private String description;
    private int followersCount;
    private int followingCount;
    private List<AwardResponseDTO> awards;
    private int likes;
}
