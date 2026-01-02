package org.galaxy.quarkus.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.galaxy.quarkus.model.dto.CreateActivityResponseDTO;
import org.galaxy.quarkus.model.dto.CreateActivityRequestDTO;
import org.galaxy.quarkus.model.dto.ActivityListResponseDTO;
import org.galaxy.quarkus.model.dto.UpdateActivityStatusRequestDTO;
import org.galaxy.quarkus.model.dto.UpdateActivityStatusResponseDTO;
import org.galaxy.quarkus.model.dto.ActivityDetailResponseDTO;
import org.galaxy.quarkus.service.ActivityService;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/activities/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActivityResource {

    @Inject
    ActivityService activityService;

    @POST
    public RestResponse<CreateActivityResponseDTO> create(CreateActivityRequestDTO activity) {
        return RestResponse.ok(activityService.recordActivity(activity));
    }

    @GET
    public RestResponse<List<ActivityListResponseDTO>> findAll() {
        return activityService.findAllActivities().isEmpty()
            ? RestResponse.noContent()
            : RestResponse.ok(activityService.findAllActivities());
    }

    @PUT
    @Path("/{id}/status")
    public RestResponse<UpdateActivityStatusResponseDTO> update(@PathParam("id") Long id, UpdateActivityStatusRequestDTO requestMascota) {
        return null;
    }

    @GET
    @Path("/{id}/detail")
    public RestResponse<ActivityDetailResponseDTO> getActivityDetail(@PathParam("id") Long id) {
        return null;
    }
}