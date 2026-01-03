package org.galaxy.quarkus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.galaxy.quarkus.model.entity.ActivityEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDetailResponseDTO {
    private ActivityDetailDTO actividad;
    //private MinistrySummaryDTO ministerio;
    private List<MemberResponse> miembros;
}