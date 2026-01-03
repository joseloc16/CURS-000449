package org.galaxy.quarkus.dao.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.galaxy.quarkus.client.MemberClient;
import org.galaxy.quarkus.dao.MemberDao;
import org.galaxy.quarkus.model.dto.MemberResponse;

@Slf4j
@ApplicationScoped
public class MemberDaoImpl implements MemberDao {

    @Inject
    @RestClient
    MemberClient memberClient;

    @Override
    public List<MemberResponse> getMembersByIds(List<Long> ids) {
        try {
            log.info("Fetching members for ids: {}", ids);

            if (ids == null || ids.isEmpty()) {
                return List.of();
            }

            return memberClient.getMembersByIds(ids);

        } catch (WebApplicationException e) {
            log.error("Error calling member service", e);
            throw new RuntimeException("Member service error");
        }
    }
}
