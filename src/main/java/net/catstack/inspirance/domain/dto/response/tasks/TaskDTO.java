package net.catstack.inspirance.domain.dto.response.tasks;

import lombok.Data;

import java.sql.Date;

@Data
public class TaskDTO {
    private String name;
    private String categoryName;
    private Long categoryId;
    private String themeName;
    private Long themeId;
    private Date deadline;
    private Integer worksCount;
}
