package org.galaxy.quarkus.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateActivityStatusRequestDTO {
    @NotNull(message = "El estado de la actividad es obligatorio")
    private String status;
}