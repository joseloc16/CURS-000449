package org.galaxy.quarkus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDetailResponseDTO {
    private ActivityDetailDTO actividad;
    //private MinistrySummaryDTO ministerio;
    private List<MemberResponse> miembros;

    public static ActivityDetailResponse from(
        ActivityEntity activity,
        List<MemberResponse> members
    ) {
        ActivityDetailResponse r = new ActivityDetailResponse();
        r.actividad = new ActivityDto(activity);
        r.miembros = members;
        return r;
    }
}