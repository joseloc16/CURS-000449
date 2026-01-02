package org.galaxy.quarkus.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateActivityRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 20, message = "El nombre debe tener al menos {min} y {max} caracteres")
    private String name;

    @NotNull(message = "El tipo de actividad es obligatorio")
    private String activityType;

    @NotNull(message = "La fecha de la actividad es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o una fecha futura")
    private LocalDate activityDate;

    @NotNull(message = "Debe especificarse el ministryId")
    private Long ministryId;

    @NotNull(message = "Debe especificarse al menos el id de un miembro")
    private List<Long> membersIds;
}