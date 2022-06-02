package net.catstack.inspirance.service.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.request.tasks.GetTasksRequestDTO;
import net.catstack.inspirance.domain.dto.response.tasks.GetTasksResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.TaskDTO;
import net.catstack.inspirance.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetTasksAdapterService {
    private final TaskRepository repository;

    public GetTasksResponseDTO getTasks(final GetTasksRequestDTO dto) {
        var taskModels = repository.findTaskByThemeAndCategory(dto.getThemeId(), dto.getCategoryId());

        var tasksList = taskModels.stream()
                .filter(model -> {
                    var daysBetween = Duration.between(LocalDate.now().atStartOfDay(), model.getDeadline().toLocalDate().atStartOfDay()).toDays();
                    return (dto.getMinDays() == null || daysBetween >= dto.getMinDays()) && (dto.getMaxDays() == null || daysBetween <= dto.getMaxDays());
                }).map(model -> {
                    var resultDto = new TaskDTO();

                    resultDto.setDeadline(model.getDeadline());
                    resultDto.setCategoryId(model.getCategory().getId());
                    resultDto.setCategoryName(model.getCategory().getName());
                    resultDto.setThemeId(model.getTheme().getId());
                    resultDto.setThemeName(model.getTheme().getName());
                    resultDto.setWorksCount(model.getCompletedWorks().size());
                    resultDto.setName(model.getName());

                    return resultDto;
                }).collect(Collectors.toList());

        var response = new GetTasksResponseDTO();
        response.setTasks(tasksList);

        return response;
    }
}
