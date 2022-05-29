package net.catstack.inspirance.service.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.request.tasks.CreateTaskRequestDTO;
import net.catstack.inspirance.domain.dto.response.tasks.CreateTaskResponseDTO;
import net.catstack.inspirance.domain.model.TaskModel;
import net.catstack.inspirance.repository.TaskRepository;
import net.catstack.inspirance.service.CategoriesService;
import net.catstack.inspirance.service.ThemesService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateTaskAdapterService {
    private final TaskRepository repository;
    private final ThemesService themesService;
    private final CategoriesService categoriesService;

    public CreateTaskResponseDTO createTask(final CreateTaskRequestDTO request) {
        log.info("Creating task {}", request.getName());
        var createdModel = repository.save(mapTaskDtoToTaskModel(request));
        var response = new CreateTaskResponseDTO();
        response.setTaskId(createdModel.getId());
        return response;
    }

    private TaskModel mapTaskDtoToTaskModel(final CreateTaskRequestDTO request) {
        log.info("Mapping task `{}` DTO to model", request.getName());
        var taskModel = new TaskModel();

        taskModel.setApplicants(new ArrayList<>());
        taskModel.setTaskDescription(request.getTaskDescription());
        taskModel.setAboutCompany(request.getAboutCompany());
        taskModel.setName(request.getName());
        taskModel.setTheme(themesService.getThemeById(request.getThemeId()));
        taskModel.setCategory(categoriesService.getCategoryById(request.getCategoryId()));
        taskModel.setDeadline(Date.valueOf(request.getDeadline()));

        return taskModel;
    }
}
