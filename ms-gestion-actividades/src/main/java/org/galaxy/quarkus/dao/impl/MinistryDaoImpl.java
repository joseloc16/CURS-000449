package org.galaxy.quarkus.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.galaxy.quarkus.client.MinistryClient;
import org.galaxy.quarkus.dao.MinistryDao;
import org.galaxy.quarkus.model.dto.MinistrySummaryDTO;

@ApplicationScoped
public class MinistryDaoImpl implements MinistryDao {

    @Inject
    @RestClient
    MinistryClient ministryClient;

    @Override
    public MinistrySummaryDTO getMinistry(Long id) {
        try {
            return ministryClient.findById(id);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 404) {
                throw new NotFoundException("Ministry not found with id: " + id);
            }
            throw new RuntimeException("Error in ministry service");
        }
    }
}
