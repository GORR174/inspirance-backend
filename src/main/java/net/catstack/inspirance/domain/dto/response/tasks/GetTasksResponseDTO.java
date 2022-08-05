package net.catstack.inspirance.domain.dto.response.tasks;

import lombok.Data;

import java.util.List;

@Data
public class GetTasksResponseDTO {
    private List<TaskDTO> tasks;
}
