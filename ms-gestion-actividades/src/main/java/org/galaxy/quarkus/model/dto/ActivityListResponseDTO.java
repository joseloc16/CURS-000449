package org.galaxy.quarkus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityListResponseDTO {
    private Long id;
    private String activityName;
    private LocalDate activityDate;
    private String activityStatus;
}