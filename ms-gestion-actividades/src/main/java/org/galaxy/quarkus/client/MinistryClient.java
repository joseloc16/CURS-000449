package org.galaxy.quarkus.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.galaxy.quarkus.model.dto.MinistrySummaryDTO;

@Path("/ministrys/v1")
@RegisterRestClient(configKey = "clientes-api")
public interface MinistryClient {

    @GET
    @Path("/{id}")
    MinistrySummaryDTO findById(@PathParam("id") Long id);
}
