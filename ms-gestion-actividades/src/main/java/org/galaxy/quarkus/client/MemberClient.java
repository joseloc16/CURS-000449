package org.galaxy.quarkus.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.galaxy.quarkus.model.dto.MemberSummaryDTO;

@Path("/members")
@RegisterRestClient(configKey = "clientes-api")
@Consumes(MediaType.APPLICATION_JSON)
public interface MemberDao {

    @GET
    @Path("/{id}")
    MemberSummaryDTO findById(@PathParam("id") Long id);
}
