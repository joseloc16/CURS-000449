package org.galaxy.quarkus.client;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.galaxy.quarkus.model.dto.MemberResponse;

import java.util.List;

@Path("/members")
@RegisterRestClient(configKey = "members-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MemberClient {

    @POST
    @Path("/by-ids")
    List<MemberResponse> getMembersByIds(List<Long> ids);
}