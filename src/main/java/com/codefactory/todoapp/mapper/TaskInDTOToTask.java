package com.codefactory.todoapp.mapper;

import com.codefactory.todoapp.persistence.entity.Task;
import com.codefactory.todoapp.persistence.entity.TaskStatus;
import com.codefactory.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements  IMapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO in) {

        Task task = new Task();
        task.setTitulo(in.getTitle());
        task.setDescripcion(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
