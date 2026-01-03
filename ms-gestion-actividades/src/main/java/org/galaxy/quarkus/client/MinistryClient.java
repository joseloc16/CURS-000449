package org.galaxy.quarkus.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.galaxy.quarkus.model.dto.MinistrySummaryDTO;

@Path("/ministrys")
@RegisterRestClient(configKey = "clientes-api")
@Consumes(MediaType.APPLICATION_JSON)
public interface MinistryDao {

    @GET
    @Path("/{id}")
    MinistrySummaryDTO findById(@PathParam("id") Long id);
}
