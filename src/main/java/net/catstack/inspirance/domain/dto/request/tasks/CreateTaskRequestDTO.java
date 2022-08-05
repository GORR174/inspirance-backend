package net.catstack.inspirance.domain.dto.request.tasks;

import lombok.Data;

@Data
public class CreateTaskRequestDTO {
    private Integer categoryId;
    private Integer themeId;
    private String name;
    private String aboutCompany;
    private String taskDescription;
    private String deadline;
}
