package com.codefactory.todoapp.service.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Data
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta;

}
