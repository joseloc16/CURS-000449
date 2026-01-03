package org.galaxy.quarkus.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.galaxy.quarkus.dto.MemberResponseDTO;
import org.jboss.resteasy.reactive.RestResponse;

@Slf4j
@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberResource {

    @POST
    @Path("/by-ids")
    public RestResponse<List<MemberResponseDTO>> findByIds(List<Long> memberIds) {
        log.info("Received request to find members by IDs: {}", memberIds);
        // MOCK
        List<MemberResponseDTO> members = memberIds.stream()
            .map(id -> {
                MemberResponseDTO dto = new MemberResponseDTO();
                dto.setId(id);
                dto.setName("Member " + id);
                return dto;
            })
            .toList();
        return RestResponse.ok(members);
    }
}